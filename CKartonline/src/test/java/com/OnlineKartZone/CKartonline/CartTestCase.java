package com.OnlineKartZone.CKartonline;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;
import com.OnlineKartZone.CKartonline.Dao.CartDao;
import com.OnlineKartZone.CKartonline.Model.Cart;

public class CartTestCase 
{
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.OnlineKartZone.CKartonline");
		context.refresh();
		CartDao cartDao=(CartDao) context.getBean("cartDao");
		Date date=new Date();
		Cart cart=new Cart();
		cart.setCartid(1001);
		cart.setProdid(1);
		cart.setProdname("SouthIndianSilk");
		cart.setProdprc(500);
		cart.setProdqty(5);
		cart.setStatus("N");
		cart.setUname("AnujaM");
		cart.setCartdate(date);
		cartDao.insertUpdateCart(cart);
		System.out.println("inserted cart");
		
		/*Cart cart=cartDao.getCart(1);
		System.out.println("cartid"+cart.getCartid());
		System.out.println("prodid"+cart.getProdid());
		System.out.println("prodname"+cart.getProdname());
		System.out.println("prodprc"+cart.getProdprc());
		System.out.println("prod qty"+cart.getProdqty());
		System.out.println("cart status"+cart.getStatus());
		System.out.println("cartdate"+cart.getCartdate());
		System.out.println("cart uname"+cart.getUname());*/
		
		//Deletion TestCase
		/*Cart cart=CartDao.getCart(1);
		cartDao.deleteCart(cart);
		System.out.println("The Cart Deleted");
		*/
		//Update the Cart
		/*Cart cart=cartDao.getCart(1);
		cart.setProdprc(900);
		cartDao.insertUpdateCart(cart);
		System.out.println("The Cart Updated");*/
		
		/*List<Cart> list=cartDao.getCartDetails("swarupa");
		
		for(Cart cart:list)
		{
			System.out.println(cart.getCartid()+":"+cart.getProdid()+":"+cart.getProdname()+":"+cart.getProdprc());
		}
		
		*/
		
	}

}
