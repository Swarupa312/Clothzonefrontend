package com.OnlineKartZone.CKartonline;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;
import com.OnlineKartZone.CKartonline.Dao.CategoryDao;
import com.OnlineKartZone.CKartonline.Model.Category;
public class CategoryTestCase 
{

		public static void main(String arg[])
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			
			context.scan("com.OnlineKartZone.CKartonline");
			
			context.refresh();
			
			
			CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
			
			/*
			Category category=new Category();
			
			category.setCatname("Western");
			category.setCatdesc("It includes the westren style clothes");

			categoryDao.insertUpdateCategory(category);		
			System.out.println("Category Inserted");
			*/
			
			
			Category category=categoryDao.getCategory(1);
			System.out.println("Category Name:"+category.getCatname());
			System.out.println("Category Description:"+category.getCatdesc());
			
			//Deletion TestCase
			/*Category category=CategoryDao.getCategory(2);
			categoryDao.deleteCategory(category);
			System.out.println("The Category Deleted");
			*/
			
			/*List<Category> list=categoryDao.getCategoryDetails();
			
			for(Category category:list)
			{
				System.out.println(category.getCatid()+":"+category.getCatname()+":"+category.getCatdesc());
			}*/
			
			//Update the Category
			/*Category category=categoryDao.getCategory(1);
			category.setCatname("Western");
			categoryDao.insertUpdateCategory(category);
			System.out.println("The Category Updated");*/
			
		
		}
}