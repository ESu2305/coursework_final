package com.sddevops.cwf_maven.eclipse;

public class Catalogue {

	protected String item;
	protected String name;
	protected double price;
	protected int quantity;
	protected String image;
	
	/**
	 * @param item
	 * @param name
	 * @param price
	 * @param quantity
	 * @param image
	 */

	public Catalogue(String item, String name, double price, int quantity, String image) {
		super();
		this.item = item;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
