package com.OnlineKartZone.CKartonline;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.*;

import com.OnlineKartZone.CKartonline.Dao.OrderConfirmDao;
import com.OnlineKartZone.CKartonline.Model.*;
public class OrderConfirmTestCase 

{

	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.OnlineKartZone.CKartonline");
		
		context.refresh();
		
		
		OrderConfirmDao orderconfirmDao=(OrderConfirmDao)context.getBean("orderconfirmDao");
		
		
		OrderConfirm orderconfirm=new OrderConfirm();
		
		orderconfirm.setOrderid(2001);				//int orderid,cartid;
														//String uname,shipmentaddress,status,paymode;
		orderconfirm.setCartid(1001);
		orderconfirm.setUname("AnujaM");
		orderconfirm.setShipmentaddress("Pune");
		orderconfirm.setStatus("Y");
		orderconfirm.setPaymode("Cashondelivery");
		orderconfirm.setGrandtotal(2000);
		

		orderconfirmDao.insertUpdateOrder(orderconfirm);		
		System.out.println("order Inserted");	
	
	/*List<OrderConfirm> list1=orderconfirmDao.getOrderDetails("AnuajaM");
	for(OrderConfirm orderconfirm:list1)
	{
		System.out.println(orderconfirm.getBillid()+":"+orderconfirm.getCartid()+":"+orderconfirm.getOrderid()+":"+orderconfirm.getPaymode()+":"+orderconfirm.getShipmentaddress()+":"+orderconfirm.getStatus()+":"+orderconfirm.getUname()+":"+orderconfirm.getGrandtotal);
	}*/
	
}	
}


	

