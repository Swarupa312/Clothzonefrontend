package com.CKartFrontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class Admincontroller 
{
 @RequestMapping("/admin")
 public String showadmin()
 {
	 
	 return "admin";
 }
 
}
