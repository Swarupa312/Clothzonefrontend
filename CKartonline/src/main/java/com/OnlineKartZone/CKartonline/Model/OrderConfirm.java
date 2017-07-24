package com.OnlineKartZone.CKartonline.Model;
import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class OrderConfirm  implements Serializable
{
	@Id
	@GeneratedValue
	int billid;
	int orderid,cartid,grandtotal;
	public int getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(int grandtotal) {
		this.grandtotal = grandtotal;
	}
	String uname,shipmentaddress,status,paymode;
	public int getBillid() {
		return billid;
	}
	public void setBillid(int billid) {
		this.billid = billid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getShipmentaddress() {
		return shipmentaddress;
	}
	public void setShipmentaddress(String shipmentaddress) {
		this.shipmentaddress = shipmentaddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymode() {
		return paymode;
	}
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	

}
