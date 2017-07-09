package com.CKartFrontEnd.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.OnlineKartZone.CKartonline.Dao.*;
import com.OnlineKartZone.CKartonline.Model.*;
@Controller
public class Categorycontroller 
{
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/Category")
	public String showCategoryPage(Model m)
	{
		System.out.println("---Category Page Displaying-----");
		List<Category> list=categoryDao.getCategoryDetails();
		m.addAttribute("catdetail",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "Category";
	}
	
	@RequestMapping(value="/AddCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("catname") String catname,@RequestParam("catdesc") String catdesc,Model m)
	{
		System.out.println("---Add Category Starting-----");
		
		System.out.println(catname+":::"+catdesc);
		
		Category category=new Category();
		category.setCatname(catname);
		category.setCatdesc(catdesc);
		  
		categoryDao.insertUpdateCategory(category);
		
		List<Category> list=categoryDao.getCategoryDetails();
		m.addAttribute("catdetail",list);
		boolean flag=false;
		m.addAttribute("flag",flag);
		System.out.println("---Category Added----");
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{catid}")
	public String deleteCategory(@PathVariable("catid") int catid,Model m)
	{
		System.out.println("---Category Deleted----");
		Category category=categoryDao.getCategory(catid);
		categoryDao.deleteCategory(category);
		
		List<Category> list=categoryDao.getCategoryDetails();
		m.addAttribute("catdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "Category";
	}
	
	@RequestMapping(value="/updateCategory/{catid}")
	public String getUpdateCategory(@PathVariable("catid") int catid,Model m)
	{
		System.out.println("--- Getting Category Object to be Updated ---");
		
		Category category=categoryDao.getCategory(catid);
		m.addAttribute("category",category);
		
		List<Category> list=categoryDao.getCategoryDetails();
		m.addAttribute("catdetail",list);
		
		boolean flag=true;
		m.addAttribute("flag",flag);
		
		return "Category";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("catid") int catid,@RequestParam("catname") String catname,@RequestParam("catdesc") String catdesc,Model m)
	{
		System.out.println("--Updating the Category----");

		Category category=new Category();
		category.setCatid(catid);
		category.setCatname(catname);
		category.setCatdesc(catdesc);
		
		categoryDao.insertUpdateCategory(category);
		
		List<Category> list=categoryDao.getCategoryDetails();
		m.addAttribute("catdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "Category";
	}
}