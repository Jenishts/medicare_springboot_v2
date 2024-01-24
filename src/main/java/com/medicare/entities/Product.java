package com.medicare.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	
	@NotBlank(message = "Enter valid Name")
	private String name;
	
	@NotBlank(message = "Enter valid brand")
	private String brand;
	
	@NotBlank(message = "Enter valid category")
	private String category;
	
	@NotBlank(message = "Enter valid description")
	private String description;
	
	@NotBlank(message = "Enter valid salt")
	private String keyword;
	
	@NotNull(message = "available cannot be null")
	private int totalAvailable;
	
	@NotNull(message = "price cannot be null")
	private Double price;
	
	@NotNull(message = "isAvailable cannot be null")
	private boolean isAvailable;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private ProductImage productImage;
	
	public Product() {
		super();
	}
	public Product(Long pid, String name, String brand, String category,String description, String keyword, int totalAvailable, Double price,
			boolean isAvailable, ProductImage productImage) {
		super();
		this.pid = pid;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.description = description;
		this.keyword = keyword;
		this.totalAvailable = totalAvailable;
		this.price = price;
		this.isAvailable = isAvailable;
		this.productImage = productImage;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String salt) {
		this.keyword = salt;
	}
	public int getTotalAvailable() {
		return totalAvailable;
	}
	public void setTotalAvailable(int totalAvailable) {
		this.totalAvailable = totalAvailable;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public ProductImage getProductImage() {
		return productImage;
	}
	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
