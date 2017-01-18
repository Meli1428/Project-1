package com.niit.shoppingbackend.model;

import javax.persistence.Entity;

//map to specific database entity(Table)
//Which table we have to map
//Create Singleton instance/object

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Entity
@Table


public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int userid;
	@NotNull(message="Name should not be empty")
	private String username;
	
	@NotNull(message="Enter valid password")	
	private String password;
	@Transient
	@NotNull(message="Enter valid password")		
	private String confirmpassword;
	
	@NotNull(message="Enter valid id")		
	private String emailid;
	
	@NotNull(message="Enter valid phone number")		
	private String phno;
	private String enabled;
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
