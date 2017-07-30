package com.CKartFrontEnd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import com.OnlineKartZone.CKartonline.Dao.CartDao;
import com.OnlineKartZone.CKartonline.Dao.OrderConfirmDao;
import com.OnlineKartZone.CKartonline.Dao.ProductDao;
import com.OnlineKartZone.CKartonline.Dao.UserDao;
import com.OnlineKartZone.CKartonline.Model.Cart;
import com.OnlineKartZone.CKartonline.Model.OrderConfirm;
import com.OnlineKartZone.CKartonline.Model.Product;
import com.OnlineKartZone.CKartonline.Model.User;
@Component
public class OrderHandler 

{
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrderConfirmDao orderconfirmDao;
	
	@Autowired
	HttpSession session;
	
	public OrderConfirm initflow()
	{
		return new OrderConfirm();
	}
	

	public void orderdetails(RequestContext context)
	{  
		System.out.println("displaying checkout page"+session.getAttribute("username"));
		 String username=(String) session.getAttribute("username");
		 System.out.println(username);
		 User user=userDao.getUser(username);
		 String shippingaddress=user.getUaddr();
		List<Cart> cartlist=cartDao.getCartDetails(username);
		
		
		int subtotal=0;
		for(Cart cart:cartlist)
		{
			int prodqty=productDao.reduceprod(cart.getProdid(),cart.getProdqty());	//reduce the quantity in product
			System.out.println(prodqty);
			if(prodqty>=0)															//it will check if it is in stock or not
			{
				Product product=productDao.getProduct(cart.getProdid());		
				product.setProdqty(prodqty);
				productDao.insertUpdateProduct(product);								//set the quantity in product
				
			}
			subtotal=subtotal+(cart.getProdprc()*cart.getProdqty());
			
		}
		context.getFlowScope().put("shippingaddress", shippingaddress);
		context.getFlowScope().put("cartlist",cartlist);
		context.getFlowScope().put("subtotal",subtotal);
		
			
	}
	
	
			
}











