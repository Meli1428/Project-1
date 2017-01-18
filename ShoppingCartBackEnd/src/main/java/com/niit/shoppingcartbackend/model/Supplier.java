package com.niit.shoppingbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="supplier")

public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sup_id;
	@NotNull(message="name should not be empty")
	private String supname;
	@NotNull(message="description cannot be blank")
	private String supdescription;
	private String supaddress;
	public String getSupaddress() {
		return supaddress;
	}
	public void setSupaddress(String supaddress) {
		this.supaddress = supaddress;
	}
	public int getSup_id() {
		return sup_id;
	}
	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getSupdescription() {
		return supdescription;
	}
	public void setSupdescription(String supdescription) {
		this.supdescription = supdescription;
	}

}
