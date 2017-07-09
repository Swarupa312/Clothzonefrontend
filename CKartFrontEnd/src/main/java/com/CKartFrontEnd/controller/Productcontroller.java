package com.CKartFrontEnd.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.OnlineKartZone.CKartonline.Dao.*;
import com.OnlineKartZone.CKartonline.Model.*;
@Controller
public class Productcontroller {
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/showproduct")
	public String showproductPage(Model m)
	{
		System.out.println("--product page dispalying time-----");
		List<Product> prodlist=productDao.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		
		
		return "showproduct";
	}
	
	@RequestMapping(value="/description/{prodid}")
	public String productdesc(@PathVariable("prodid") int prodid,Model m)
	{
		System.out.println("displaying decription page");
		Product product=productDao.getProduct(prodid);
		m.addAttribute("prodinfo",product);
	
		return"description";
	}
	
	@RequestMapping(value="/categorywise/{catid}")
	public String productdcategory(@PathVariable("catid") int catid,Model m)
	{
		System.out.println("categorywise");
		List<Product> proinfo=productDao.getproductbyCatid(catid);
		
		m.addAttribute("prodlist",proinfo);
		
		return"categorywise";
	}
	
	@RequestMapping("/product")
	public String showProduct(Model m)
	{
		Product product=new Product();
		m.addAttribute("product",product);
		m.addAttribute("catlist", this.getCatlist());
		m.addAttribute("suplist", this.getSuplist());
		List<Product> prodlist=productDao.getProductDetails();
		m.addAttribute("prodlist", prodlist);
		boolean flag=false;
		m.addAttribute("flag",flag);
		return "product";
	}
	
	@RequestMapping(value="/AddProduct",method=RequestMethod.POST)
	public String insertproduct(@ModelAttribute("product") Product product,Model m,@RequestParam("pimage") MultipartFile filedet)
	{
		System.out.println("Product inserted");
		
		
		System.out.println("image uploading");
		String path="C:\\Users\\owner\\New folder\\CKartFrontEnd\\src\\main\\webapp\\resources\\prodimage\\";
		String idpath=productDao.getProdid()+".jpg";
		
		System.out.println(productDao.getProdid());
		
		String infopath=path+idpath;
		
		System.out.println(infopath);
		File f=new File(infopath);
		if (!filedet.isEmpty())
		{
			System.out.println("started");
			try
			{
				byte b[]=filedet.getBytes();
			FileOutputStream fos=new FileOutputStream(f);
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			bos.write(b);
			System.out.println("ended");
			bos.close();
			fos.close();
			String imgpath="resources/Prodimage/"+idpath;
			product.setImgpath(imgpath);
			productDao.insertUpdateProduct(product);
			
			}
	
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
		
		
		
		List<Product> prodlist=productDao.getProductDetails();
		m.addAttribute("prodlist", prodlist);
		boolean flag=false;
		m.addAttribute("flag",flag);
		System.out.println("uploaded");
		return "redirect:/product";
		
	}
	
	@RequestMapping(value="/updateProduct/{prodid}")
	public String updateProduct(@PathVariable("prodid") int prodid,Model m)
	{
		Product product=productDao.getProduct(prodid);
		m.addAttribute("product", product);
		m.addAttribute("catlist", this.getCatlist());
		m.addAttribute("suplist", this.getSuplist());
		List<Product> prodlist=productDao.getProductDetails();
		m.addAttribute("prodlist", prodlist);
		boolean flag=true;
		m.addAttribute("flag",flag);
		
		return "product";
		
	}
	
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String getupdateproduct(@PathVariable("prodid") int prodid,Model m)
	{
		Product product=productDao.getProduct(prodid);
		m.addAttribute("product", product);
		m.addAttribute("catlist", this.getCatlist());
		m.addAttribute("suplist", this.getSuplist());
		List<Product> prodlist=productDao.getProductDetails();
		m.addAttribute("prodlist", prodlist);
		boolean flag=false;
		m.addAttribute("flag",flag);
		return "product";
	}
	
	@RequestMapping(value="/deleteProduct/{prodid}")
	public String deleteProduct(@PathVariable("prodid") int prodid,Model m)
	{
		
		Product product=productDao.getProduct(prodid);
		productDao.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute("product", product1);
		m.addAttribute("catlist",this.getCatlist());
		m.addAttribute("suplist", this.getSuplist());
		List<Product> prodlist=productDao.getProductDetails();
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "product";
		
	}
	
	public LinkedHashMap<Integer,String> getCatlist()
	{
		List<Category> list=categoryDao.getCategoryDetails();
		
		LinkedHashMap<Integer,String> catlist=new LinkedHashMap<Integer,String>();
		
		for(Category cat:list)
		{
			catlist.put(cat.getCatid(),cat.getCatname());
		}
		
		return catlist;
	}

	public LinkedHashMap<Integer,String> getSuplist()
	{
		List<Supplier> list1=supplierDao.getSupplierDetails();
		LinkedHashMap<Integer, String> suplist=new LinkedHashMap<Integer,String>();
		for(Supplier sup:list1)
		{
			suplist.put(sup.getSupid(),sup.getSname());
		}
		return suplist;
		
	}
	
}
