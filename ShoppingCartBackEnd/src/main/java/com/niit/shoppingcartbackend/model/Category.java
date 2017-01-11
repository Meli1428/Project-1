package com.niit.shoppingcartbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="category")

public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cat_id;
	@NotNull(message="name should not be empty")
	private String catname;
	@NotNull(message="description cannot be blank")
	private String catdescription;
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getCatdescription() {
		return catdescription;
	}
	public void setCatdescription(String catdescription) {
		this.catdescription = catdescription;
	}
	



}
