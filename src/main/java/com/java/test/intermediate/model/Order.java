package com.java.test.intermediate.model;

import java.util.Date;

public class Order {
	
	private int orderID;
	private String customer;
	private String employee;
	private Date orderDate;
	private String purchaseOrderNumber;
	private Date shipDate;
	private String shippingMethod;
	private int freightCharge;
	private int taxes;
	private String paymentReceived;
	private String comment;
		
	public Order (int orderID, String customer, String employee, Date orderDate, 
			String purchaseOrderNumber, Date shipDate, String shippingMethod,
			int freightCharge, int taxes, String paymentReceived, String comment) {
		 this.orderID=orderID;
		 this.customer=customer;
		 this.employee=employee;
		 this.orderDate=orderDate;
		 this.purchaseOrderNumber=purchaseOrderNumber;
		 this.shipDate=shipDate;
		 this.shippingMethod=shippingMethod;
		 this.freightCharge=freightCharge;
		 this.taxes=taxes;
		 this.paymentReceived=paymentReceived;
		 this.comment=comment;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public Date getShipDate() {
		return shipDate;
	}
	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public int getFreightCharge() {
		return freightCharge;
	}
	public void setFreightCharge(int freightCharge) {
		this.freightCharge = freightCharge;
	}
	public int getTaxes() {
		return taxes;
	}
	public void setTaxes(int taxes) {
		this.taxes = taxes;
	}
	public String getPaymentReceived() {
		return paymentReceived;
	}
	public void setPaymentReceived(String paymentReceived) {
		this.paymentReceived = paymentReceived;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
    
    

}
