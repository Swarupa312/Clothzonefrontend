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
import com.OnlineKartZone.CKartonline.Model.Cart;
import com.OnlineKartZone.CKartonline.Model.OrderConfirm;
import com.OnlineKartZone.CKartonline.Model.Product;

@Controller
public class OrderConfirmcontroller 
{
	@Autowired
	CartDao cartDao;
	
	@Autowired
	OrderConfirmDao orderconfirmDao;
	
	@RequestMapping(value="/placeorder")
	public String confirmOrder(HttpSession session, Model m)
	{
		System.out.println("displaying checkout page");
		String username=(String)session.getAttribute("username");
		List<Cart> cartlist=cartDao.getCartDetails(username);
		int subtotal=0;
		for(Cart cart:cartlist)
		{
			subtotal=subtotal+(cart.getProdprc()*cart.getProdqty());
			
		}
		System.out.println(subtotal);
		m.addAttribute("subtotal", subtotal);
		m.addAttribute("cartitems", cartlist);
		return "orderconfirm";
	}
	
	@RequestMapping(value="/bill")
	public String billpayment(@RequestParam("paymode") String paymode,@RequestParam("shipmentaddress") String shipmentaddress,HttpSession session, Model m)
	{
		System.out.println("bill page displaying");
		OrderConfirm orderconfirm=new OrderConfirm();
		String username=(String)session.getAttribute("username");
		/*orderconfirm.setOrderid(2001);*/
		/*orderconfirm.setCartid(1001);*/
		orderconfirm.setOrderid(orderconfirmDao.getorderid(username));
		orderconfirm.setCartid(cartDao.getCartid(username));
		orderconfirm.setPaymode(paymode);
		orderconfirm.setShipmentaddress(shipmentaddress);
		orderconfirm.setStatus("Y");
		orderconfirm.setUname(username);
		orderconfirm.setGrandtotal(4000);
		orderconfirmDao.insertUpdateOrder(orderconfirm);
		List<OrderConfirm> list1=orderconfirmDao.getOrderDetails(username);
		m.addAttribute("orderlist", list1);
		List<Cart> cartlist=cartDao.getCartDetails(username);
		m.addAttribute("cartitems", cartlist);
		return "bill";
		
	}

}
