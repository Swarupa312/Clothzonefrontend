package com.OnlineKartZone.CKartonline.Model;
import java.io.Serializable;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table
public class User 
{
	
	@Id
	@NotEmpty
	@Length(min=5,max=10)
	String uname;
	boolean enabled=true;
	@NotEmpty
	String cname;
	@NotEmpty
	String uaddr;
	String urole;
	@NotEmpty
	@Length(min=5,max=10)
	String upass;

	@NotEmpty
	@Email
	String uemail;
	
	@NotEmpty
	@Length(min=10,max=10)
	String umobile;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUmobile() {
		return umobile;
	}

	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}

	public String getUrole() {
		return urole;
	}

	public void setUrole(String urole) {
		this.urole = urole;
	}

	public String getUaddr() {
		return uaddr;
	}

		

	

	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}

	

}
