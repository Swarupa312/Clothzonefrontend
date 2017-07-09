package com.CKartFrontEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.OnlineKartZone.CKartonline.Dao.SupplierDao;

import com.OnlineKartZone.CKartonline.Model.Supplier;

@Controller
public class Suppliercontroller 
{
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/supplier")
	public String showsupplier(Model m)
	{
		System.out.println("Displaying Supplier page");
		List<Supplier> list=supplierDao.getSupplierDetails();
		m.addAttribute("supdetail", list);
		boolean flag=false;
		m.addAttribute("flag", flag);
		
		return "supplier";
	}
	
	@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
	public String addsupplier(@RequestParam("sname") String sname,@RequestParam("saddr")String saddr,Model m)
	{
		System.out.println(sname+"::"+saddr);
		Supplier supplier=new Supplier();
		supplier.setSname(sname);
		supplier.setSaddr(saddr);
		
		supplierDao.insertUpdateSupplier(supplier);
		
		List<Supplier> list=supplierDao.getSupplierDetails();
		m.addAttribute("supdetail", list);
		boolean flag=false;
		m.addAttribute("flag", flag);
		System.out.println("supplier added");
		return "supplier";
		
	}
	@RequestMapping("/deleteSupplier/{supid}")
	public String deletesupplier(@PathVariable("supid") int supid,Model m)
	{
		System.out.println("---Supplier Deleted----");
		Supplier supplier=supplierDao.getSupplier(supid);
		supplierDao.deleteSupplier(supplier);
		
		List<Supplier> list=supplierDao.getSupplierDetails();
		m.addAttribute("supdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "supplier";
		
		
	}
	
	@RequestMapping(value="/updateSupplier/{supid}")
	public String getUpdatesupplier(@PathVariable("supid") int supid,Model m)
	{
		System.out.println("--- Getting supplier Object to be Updated ---");
		
		Supplier supplier=supplierDao.getSupplier(supid);
		m.addAttribute("supplier",supplier);
		
		List<Supplier> list=supplierDao.getSupplierDetails();
		m.addAttribute("supdetail",list);
		
		boolean flag=true;
		m.addAttribute("flag",flag);
		
		return "supplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updatesupplier(@RequestParam("supid") int supid,@RequestParam("sname") String sname,@RequestParam("saddr") String saddr,Model m)
	{
		System.out.println("--Updating the supplier----");

		Supplier supplier=new Supplier();
		supplier.setSupid(supid);
		supplier.setSname(sname);
		supplier.setSaddr(saddr);
		
		supplierDao.insertUpdateSupplier(supplier);
		
		List<Supplier> list=supplierDao.getSupplierDetails();
		m.addAttribute("supdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "supplier";
	}
}


