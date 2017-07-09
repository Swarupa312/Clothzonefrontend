/*package com.CKartFrontEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.OnlineKartZone.CKartonline.*;
import com.OnlineKartZone.CKartonline.Dao.ProductDao;
import com.OnlineKartZone.CKartonline.Dao.UserDao;
import com.OnlineKartZone.CKartonline.Model.Category;
import com.OnlineKartZone.CKartonline.Model.Product;
import com.OnlineKartZone.CKartonline.Model.User;
@Controller
public class Logincontroller 
{
	@Autowired
	UserDao userDao;
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginprocess(@RequestParam("uname") String uname,@RequestParam("upass") String upass)
	{
		System.out.println("matching....");
		
		List<User>ulist=userDao.getUserDetails();
		for(User user:ulist)
		{
			if(user.getUname().equals(uname) && user.getUpass().equals(upass))
			{
				List<Product> prodlist=productDao.getProductDetails();
				m.addAttribute("prodlist", prodlist);
				return "User";
				
			}
		}
		return "main";
	
	}
}
	
		
		
		

*/