package com.CKartFrontEnd.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class Pagecontroller
{
	@RequestMapping("/")
	public String showMainPage(HttpSession session)
	{
		
		boolean loggedin=false;
		session.setAttribute("loggedin",loggedin);
		System.out.println("--Main Page dispalying-----");
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
	
	@RequestMapping("/logout")
	public String showlogoutPage(HttpSession session)
	{
		System.out.println("--logout Page dispalying-----");
		boolean log=(boolean)session.getAttribute("loggedin");
		if(log)
		{
			log=false;
			session.setAttribute("loggedin", log);
		}
		return "logout";
	}

	
	@RequestMapping("/main")
	public String showmain1Page()
	{
		System.out.println("--Main Page dispalying-----");
		return "main";
	}
}
