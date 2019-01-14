package com.java.test.intermediate.model;

public class OrderDetail {
	
	private int orderDetailID;
    private int orderID;
    private String product;
    private int quantity;
    private double unitPrice;
    private double discount;
    private double totalPrice;
    
    public OrderDetail (String product, int quantity, double unitPrice, 
    		double discount, double totalPrice) {
    	this.product = product;
    	this.quantity = quantity;
    	this.unitPrice = unitPrice;
    	this.discount = discount;
    	this.totalPrice = totalPrice;
    }
    
	public int getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
    
	
    
    
    

}
