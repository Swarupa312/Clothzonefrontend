package com.CKartFrontEnd.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.OnlineKartZone.CKartonline.Dao.CartDao;
import com.OnlineKartZone.CKartonline.Dao.ProductDao;
import com.OnlineKartZone.CKartonline.Model.Cart;
import com.OnlineKartZone.CKartonline.Model.Product;
@Controller
public class Cartcontroller
{

	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/cart")
	public String showcartPage(HttpSession session,Model m)
	{
		System.out.println("--Cart Page dispalying-----");
		String username=(String)session.getAttribute("username");
		List<Cart>list=cartDao.getCartDetails(username);
		m.addAttribute("cartlist",list);
		return "cart";
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value="addcart/{prodid}",method=RequestMethod.GET)
	public String getcartpage(@PathVariable("prodid") int prodid,@RequestParam("prodqty") int prodqty,HttpSession session,Model m)
	{
		
		String username=(String)session.getAttribute("username");
		System.out.println("cart page displaying");
		Cart cart1=cartDao.checkprodid(username, prodid);
		if(cart1!=null)					//checking product exist or not
		{
			System.out.println("fucntion IN");
			prodqty=cartDao.increamentqty(prodqty, username, prodid);	//inceament quantity of that product
			System.out.println(cart1.getProdqty()); 
			cart1.setProdqty(prodqty);
			System.out.println(cart1.getProdqty());
			cartDao.insertUpdateCart(cart1);								//insert that updation
			 
		}
		else
		{	
		System.out.println("Entering in else");
		Cart cart=new Cart();
		cart.setProdid(prodid);
		cart.setStatus("N");
		Date date=new Date();
		cart.setCartdate(date);
		cart.setUname(username);
		System.out.println("doing");
		/*cart.setCartid(1002);*/
		cart.setCartid(cartDao.getCartid(username));
		Product product=productDao.getProduct(prodid);
		cart.setProdname(product.getProdname());
		cart.setProdprc(product.getProdprc());
		cart.setProdqty(prodqty);
		cartDao.insertUpdateCart(cart);
		}
		List<Cart> list=cartDao.getCartDetails(username);
	
		m.addAttribute("cartlist", list);
		return"cart";
		
	}
	@RequestMapping(value="updatecart/{cartitemid}",method=RequestMethod.GET)			//update
	public String getupdatecart(@PathVariable("cartitemid") int cartitemid,@RequestParam("prodqty") int prodqty,Model m,HttpSession session)
	{
		Cart cart=cartDao.getCart(cartitemid);
		int stock=productDao.getProduct(cart.getProdid()).getProdqty();
		
		if(stock<prodqty)
		{
			System.out.println("Out Of stock!!!!!");
			
		}
		else
		{
			
			cart.setProdqty(prodqty);
			cartDao.updatecart(cart);
			String username=(String)session.getAttribute("username");
			
			List<Cart>list=cartDao.getCartDetails(username);
			m.addAttribute("cartlist",list);
			
			
		}	
		return"redirect:/cart";
	}
	
	@RequestMapping(value="/deletedcart/{cartitemid}")				//delete
	public String getdeletecart(@PathVariable("cartitemid") int cartitemid,Model m,HttpSession session)
	{
		Cart cart=cartDao.getCart(cartitemid);
		
		cartDao.deleteCart(cart);
		String username=(String)session.getAttribute("username");
		
		List<Cart>list=cartDao.getCartDetails(username);
		m.addAttribute("cartlist",list);
		return "redirect:/cart";
		
	}
	
	
	
}
