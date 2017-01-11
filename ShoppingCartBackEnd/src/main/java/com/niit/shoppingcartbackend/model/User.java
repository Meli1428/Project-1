package com.niit.shoppingcartbackend.model;

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
@Table //if the table name and the domain object name is same
@Component //user instance   //do not user User u=new User()

public class User {
	
	
	@Id //
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	
	@NotNull(message="Name should not be empty")
	private String username;
	
	@NotNull(message="Password should be 5 to 6 characters")
	private String password;
	
	@Transient /*not to store to DB*/
	private String confirmpassword;
	
	//enabled refers if user is enabled or not
	private String enabled;
	
	@NotNull(message="Enter valid email")
	private String emailid;
	
	@NotNull(message="Enter valid number")
	private String phno;
	
	private String role;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public String getEnabled() {
		return enabled;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
}
