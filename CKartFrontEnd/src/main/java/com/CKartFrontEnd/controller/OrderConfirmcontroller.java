package com.CKartFrontEnd.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.OnlineKartZone.CKartonline.Dao.CartDao;
import com.OnlineKartZone.CKartonline.Dao.OrderConfirmDao;
import com.OnlineKartZone.CKartonline.Dao.ProductDao;
import com.OnlineKartZone.CKartonline.Dao.UserDao;
import com.OnlineKartZone.CKartonline.Model.Cart;
import com.OnlineKartZone.CKartonline.Model.OrderConfirm;
import com.OnlineKartZone.CKartonline.Model.Product;
import com.OnlineKartZone.CKartonline.Model.User;

@Controller
public class OrderConfirmcontroller 
{
	@Autowired
	CartDao cartDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	OrderConfirmDao orderconfirmDao;
	
	/*@RequestMapping(value="/placeorder")
	public String confirmOrder(HttpSession session, Model m)
	{
		System.out.println("displaying checkout page");
		String username=(String)session.getAttribute("username");
		List<Cart> cartlist=cartDao.getCartDetails(username);
		boolean flag=true;
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
		
		m.addAttribute("shippingaddress",shippingaddress);
		m.addAttribute("subtotal", subtotal);
		m.addAttribute("cartitems", cartlist);
		m.addAttribute("flag",flag);
		return "orderconfirm";
		}
		else
		{
			m.addAttribute("flag",flag);
			List<Cart>list=cartDao.getCartDetails(username);
			m.addAttribute("cartlist",list);
			return"cart";
		}
	}*/
	
	@RequestMapping(value="/bill")
	public String billpayment(@RequestParam("paymode") String paymode,@RequestParam("shipmentaddress") String shipmentaddress,@RequestParam("grandtotal") int grandtotal,HttpSession session, Model m)
	{
		System.out.println("bill page displaying");
		OrderConfirm orderconfirm=new OrderConfirm();
		String username=(String)session.getAttribute("username");
		/*orderconfirm.setOrderid(2001);*/
		/*orderconfirm.setCartid(1001);*/
		
		/*orderconfirm.setOrderid(5001);
		orderconfirm.setCartid(1003);*/
		orderconfirm.setOrderid(orderconfirmDao.getorderid());
		orderconfirm.setCartid(cartDao.getCartid(username));
		orderconfirm.setPaymode(paymode);
		orderconfirm.setShipmentaddress(shipmentaddress);
		orderconfirm.setStatus("Y");
		orderconfirm.setUname(username);
		orderconfirm.setGrandtotal(grandtotal);
		orderconfirmDao.insertUpdateOrder(orderconfirm);
		List<OrderConfirm> list1=orderconfirmDao.getOrderDetails(username,orderconfirm.getOrderid());
		m.addAttribute("orderlist", list1);
		List<Cart> cartlist=cartDao.getCartDetails(username);
		m.addAttribute("cartitems", cartlist);
		List<Cart>  list2=cartDao.getCartDetails(username);
		for(Cart cart:list2)
		{
			cartDao.deleteCart(cart);
		}
		
		return "bill";
		
	}

}
