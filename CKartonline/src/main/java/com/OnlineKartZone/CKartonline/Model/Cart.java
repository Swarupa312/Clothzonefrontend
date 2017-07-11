package com.OnlineKartZone.CKartonline.Model;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Cart
{
	@Id
	@GeneratedValue
	int cartitemid;
	int cartid,prodid,prodqty,prodprc;
	String prodname,status,uname;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@GeneratedValue
	Date cartdate;
	public int getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public int getProdqty() {
		return prodqty;
	}
	public void setProdqty(int prodqty) {
		this.prodqty = prodqty;
	}
	public int getProdprc() {
		return prodprc;
	}
	public void setProdprc(int prodprc) {
		this.prodprc = prodprc;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCartdate() {
		return cartdate;
	}
	public void setCartdate(Date cartdate) {
		this.cartdate = cartdate;
	}
	
	

}
