package com.OnlineKartZone.CKartonline.Model;
import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table
public class Product<MultipartFile> implements Serializable
{
	@Id
	@GeneratedValue
	int prodid;
	@Transient
	MultipartFile pimage;
	String prodname,proddesc,imgpath;
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	int prodqty,prodprc,catid,supid;
	
	
	public MultipartFile getPimage() {
		return pimage;
	}
	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
	public int getProdqty() {
		return prodqty;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getSupid() {
		return supid;
	}
	public void setSupid(int supid) {
		this.supid = supid;
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
	
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	
}
