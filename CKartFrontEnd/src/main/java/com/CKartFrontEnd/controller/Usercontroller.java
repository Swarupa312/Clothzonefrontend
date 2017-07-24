package com.CKartFrontEnd.controller;
import java.util.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.OnlineKartZone.CKartonline.Dao.*;
import com.OnlineKartZone.CKartonline.Model.*;


@Controller

public class Usercontroller 
{
	@Autowired
	UserDao userDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;
	
	
	
	@RequestMapping("/newregistration")
	public String shownewregistrationPage(Model m)
	{
		m.addAttribute("user",new User());
		System.out.println("--NewRegistration  dispalying-----");
		
		return "newregistration";
	}
	
	/*@RequestMapping(value="/user",method=RequestMethod.POST)
	public String adduserprocess( @RequestParam("uaddr") String uaddr ,@RequestParam("uname") String uname ,@RequestParam("cname") String cname,@RequestParam("uemail") String uemail,@RequestParam("umobile") String umobile,@RequestParam("upass") String upass,  Model m,  BindingResult result)
	{
		System.out.println("---Add User Starting-----");
		
		
 
        
		
		User user=new User();
		user.setUaddr(uaddr);
		user.setUname(uname);
		user.setCname(cname);
		user.setUemail(uemail);
		user.setUmobile(umobile);
		user.setUpass(upass);
		user.setUrole("ROLE_USER");
		user.setEnabled(true);
		  
		userDao.insertUpdateUser(user);
		
		List<User> list=userDao.getUserDetails();
		m.addAttribute("userdetail",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		System.out.println("---User Added----");
		return "newregistration";
		
	}*/
	
	
	@RequestMapping(value="/AddUser",method=RequestMethod.POST)
	public String adduserprocess(@ModelAttribute("user" )@Valid User user,BindingResult result)
	{
		System.out.println("---Add User Starting-----");
		System.out.println(""+result.getErrorCount());
		if(result.hasErrors())
		{
			return"newregistration";
		}
		
		else
		{
			System.out.println("Valid user");
		}
		userDao.insertUpdateUser(user);

		/*List<User> list=userDao.getUserDetails();
		m.addAttribute("userdetail",list);
		boolean flag=false;
		m.addAttribute("flag",flag);*/
		
		System.out.println("---User Added----");
		return "index";
		
		
	}
	
	@RequestMapping("/login_success")
	public String loginsuccess(HttpSession session,Model m)
	{
		System.out.println("login  successfully");
		/*boolean loggedin=true;*/
		boolean loggedin=(boolean)session.getAttribute("loggedin");
		loggedin=true;
		session.setAttribute("loggedin",loggedin);
  
		String username= SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("username",username);
		
   		System.out.println(username);
   	

	@SuppressWarnings("unchecked")
	Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
  for(GrantedAuthority role:authorities)
	{
	  System.out.println("Role: "+role.getAuthority()+" username "+username);
	  String srole=role.getAuthority();
	  session.setAttribute("srole",srole);
	if(role.getAuthority().equals("ROLE_ADMIN"))
	{
		
		return "admin";
	
	}
	else
	{
		List<Category> list=categoryDao.getCategoryDetails();
		m.addAttribute("catdetail",list);
		return "User";
		/*return "showproduct";*/
	}
	}
  	return "index";

	}
	
	
	
	
	
	
	
	
	
	
	

	}
	
	
	


