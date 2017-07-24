package com.CKartFrontEnd.controller;

import javax.servlet.http.HttpSession;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;


import com.OnlineKartZone.CKartonline.Model.Cart;
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
	
	public OrderConfirm initflow()
	{
		return new OrderConfirm();
	}
	
public String orderdetails()
	{
		

		System.out.println("displaying checkout page");
		String username="chai";
		List<Cart> cartlist=cartDao.getCartDetails(username);
		boolean flag=true;
		String status;
		int subtotal=0;
		for(Cart cart:cartlist)
		{
			int prodqty=productDao.reduceprod(cart.getProdid(),cart.getProdqty());	//reduce the quantity in product
			System.out.println(prodqty);
			if(prodqty>=0)
			{
				Product product=productDao.getProduct(cart.getProdid());		
				product.setProdqty(prodqty);
				productDao.insertUpdateProduct(product);								//set the quantity in product
				flag=true;
			}
			else
			{
				System.out.println("place order else");
				flag=false;
			}
			subtotal=subtotal+(cart.getProdprc()*cart.getProdqty());
			
		}
			
			if(flag)
			{
				User user=userDao.getUser(username);
				String shippingaddress=user.getUaddr();
				
				status="success";
			}
			else
			{
				List<Cart>list=cartDao.getCartDetails(username);
				status="failure";
			
			}
			
			return status;
		}
		
}

