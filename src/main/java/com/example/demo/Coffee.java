package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coffee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String coffeename;
	private String flavour;
	private String quantity;
	private String caffeinecontent;
	private String price;
	private String discount;
	@Column(length=1000000)
	private byte[] image;
	
	
	public Coffee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coffee(int id, String coffeename, String flavour, String quantity, String caffeinecontent, String price, String discount,
			byte[] image) {
		super();
		this.id = id;
		this.coffeename = coffeename;
		this.flavour = flavour;
		this.quantity = quantity;
		this.caffeinecontent = caffeinecontent;
		this.price = price;
		this. discount =  discount;
		this.image = image;
	}
	public Coffee(String  coffeename, String flavour, String quantity, String caffeinecontent, String price, String  discount,
			byte[] image) {
		super();
		this.coffeename = coffeename;
		this.flavour = flavour;
		this.quantity = quantity;
		this.caffeinecontent = caffeinecontent;
		this.price = price;
		this. discount = discount;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoffeeName() {
		return coffeename;
	}
	public void setCoffeeName(String  coffeename) {
		this.coffeename =  coffeename;
	}
	public String getFlavour() {
		return flavour;
	}
	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCaffeineContent() {
		return caffeinecontent;
	}
	public void setCaffeineContent(String caffeinecontent) {
		this.caffeinecontent = caffeinecontent;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return  discount;
	}
	public void setDiscount(String  discount) {
		this. discount=  discount;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Coffee [id=" + id + ", coffeename=" + coffeename + ", flavour=" + flavour + ", quantity=" + quantity
				+ ", caffeinecontent=" + caffeinecontent + ", price=" + price + ", discount=" + discount + "]";
	}
	
	
	
	
	
}
