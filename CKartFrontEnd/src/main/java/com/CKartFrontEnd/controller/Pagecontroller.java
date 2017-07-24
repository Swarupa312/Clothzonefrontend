package com.CKartFrontEnd.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.OnlineKartZone.CKartonline.Dao.CategoryDao;
import com.OnlineKartZone.CKartonline.Dao.UserDao;
import com.OnlineKartZone.CKartonline.Model.Category;
import com.OnlineKartZone.CKartonline.Model.User;
@Controller
public class Pagecontroller
{
	@Autowired
	UserDao userDao;
	
	@Autowired
	CategoryDao categoryDao;
	@RequestMapping("/")
	public String showMainPage(HttpSession session,Model m)
	{
		
		boolean loggedin=false;
		session.setAttribute("loggedin",loggedin);
		System.out.println("--Main Page dispalying-----");
		
		List<Category> list=categoryDao.getCategoryDetails();
		m.addAttribute("catdetail",list);
		return "main";
	}
	
	
	
	@RequestMapping("/home")
	public String showhomePage(HttpSession session)
	{
		System.out.println("--home Page dispalying-----");
		
		return "home";
	}
	
	@RequestMapping("/aboutus")
	public String showaboutusPage()
	{
		System.out.println("--AboutUs Page dispalying-----");
		return "aboutus";
	}
	@RequestMapping("/User")
	public String showuserMainPage()
	{
		System.out.println("--UserPage dispalying-----");
		return "User";
	}
	
	@RequestMapping("/contactme")
	public String showcontactmePage()
	{
		System.out.println("--ContactUs Page dispalying-----");
		return "contactme";
	}
	
	/*@RequestMapping("/newregistration")
	public String shownewregistrationPage()
	{
		System.out.println("--NewRegistration  dispalying-----");
		return "newregistration";
	}*/
	
	@RequestMapping("/index")
	public String showindexPage()
	{
		System.out.println("--Login  Page dispalying 1 st time-----");
		return "index";
	}
	
	@RequestMapping("/logout1")
	public String showlogoutPage(HttpSession session)
	{
		System.out.println("--logout Page dispalying-----");
		boolean loggedin=(boolean)session.getAttribute("loggedin");
		if(loggedin)
		{
			loggedin=false;
			session.setAttribute("loggedin", loggedin);
		}
		return "main";
	}

	
	@RequestMapping("/main")
	public String showmain1Page()
	{
		System.out.println("--Main Page dispalying-----");
		return "main";
	}
	
	@RequestMapping("/failure")
	public String showfailurePage()
	{
		System.out.println("--failure Page dispalying-----");
		return "failure";
	}
	
	@RequestMapping("/SignInnavbar")
	public String setnewpasswordPage(HttpSession session,Model m, @RequestParam("Uname") String Uname,@RequestParam("password") String password)
	{
		System.out.println("-- dispalying-----");
		User user=userDao.getUser(Uname);
		user.setUpass(password);
		userDao.insertUpdateUser(user);
		System.out.println(user.getUpass());
		return "SignInnavbar";
	}
	
	@RequestMapping("/forgotpass")
	public String showforgotpassPage()
	{
		System.out.println("-- Page dispalying-----");
		return "forgotpass";
	}
}
