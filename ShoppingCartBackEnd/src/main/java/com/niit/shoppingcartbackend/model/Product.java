package com.niit.shoppingbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="product")

public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prod_id;
	
	@NotNull(message="Product Name should not be empty")
	private String prod_name;
	
	@Min(1)
	private int prod_price;
	@Min(1)
	private int quantity;
	
	@Transient
	private MultipartFile img;
	
	@ManyToOne
	@JoinColumn(name="cat_id",insertable=false,updatable=false)
	private Category category;
	private int cat_id;
	
	@ManyToOne
	@JoinColumn(name="sup_id",insertable=false,updatable=false)
	private Supplier supplier;
	private int sup_id;
	
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public int getSup_id() {
		return sup_id;
	}
	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}
	
	
	
	

}
