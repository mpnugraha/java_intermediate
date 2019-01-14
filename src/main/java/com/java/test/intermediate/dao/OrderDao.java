package com.java.test.intermediate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java.test.intermediate.model.Order;
import com.java.test.intermediate.model.OrderDetail;

@Repository
public class OrderDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Find all users, thanks Java 8, you can create a custom RowMapper like this :
	public List<Order> findAll() {
		String qry = "SELECT o.OrderID, c.CompanyName, CONCAT(e.LastName, \", \", e.FirstName) as Employee, o.OrderDate, o.PurchaseOrderNumber, " + 
				"	o.ShipDate, sm.ShippingMethod, o.FreightCharge, o.Taxes, o.PaymentReceived, o.Comment " + 
				"FROM ORDERS o " + 
				"	LEFT JOIN Customers c on c.CustomerID=o.CustomerID " + 
				"	LEFT JOIN Employees e on o.EmployeeID=e.EmployeeID " + 
				"	LEFT JOIN Shipping_Methods sm on o.ShippingMethodID=sm.ShippingMethodID " ;
		List<Order> result = jdbcTemplate.query(qry,
				(rs, rowNum) -> new Order(rs.getInt("OrderID"), rs.getString("CompanyName"), rs.getString("Employee"),
						rs.getDate("OrderDate"), rs.getString("PurchaseOrderNumber"), rs.getDate("ShipDate"),
						rs.getString("ShippingMethod"), rs.getInt("FreightCharge"), rs.getInt("Taxes"),
						rs.getString("PaymentReceived"), rs.getString("Comment")));

		return result;

	}
	
	public List<Order> findById(int id) {
		String qry = "SELECT o.OrderID, c.CompanyName, CONCAT(e.LastName, \", \", e.FirstName) as Employee, o.OrderDate, o.PurchaseOrderNumber, " + 
				"	o.ShipDate, sm.ShippingMethod, o.FreightCharge, o.Taxes, o.PaymentReceived, o.Comment " + 
				"FROM ORDERS o " + 
				"	LEFT JOIN Customers c on c.CustomerID=o.CustomerID " + 
				"	LEFT JOIN Employees e on o.EmployeeID=e.EmployeeID " + 
				"	LEFT JOIN Shipping_Methods sm on o.ShippingMethodID=sm.ShippingMethodID " + 
				"WHERE OrderID = ";
		List<Order> result = jdbcTemplate.query(qry + id,
				(rs, rowNum) -> new Order(rs.getInt("OrderID"), rs.getString("CompanyName"), rs.getString("Employee"),
						rs.getDate("OrderDate"), rs.getString("PurchaseOrderNumber"), rs.getDate("ShipDate"),
						rs.getString("ShippingMethod"), rs.getInt("FreightCharge"), rs.getInt("Taxes"),
						rs.getString("PaymentReceived"), rs.getString("Comment")));

		return result;

	}

	public List<Integer> findId() {
		List<Integer> result = jdbcTemplate.query("SELECT OrderID FROM ORDERS ORDER BY OrderID asc", 
			new RowMapper<Integer>() {
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getInt(1);
				}
			});

		return result;

	}
	
	public List<OrderDetail> findOrderDetailByOrderId(int id) {
		String qry = "SELECT p.ProductName, od.Quantity, od.UnitPrice, od.Discount, od.Quantity*od.UnitPrice*(1-od.Discount) as Price " + 
				"FROM Order_Details od " + 
				"	LEFT JOIN Orders o on od.OrderID=o.OrderID " + 
				"	LEFT JOIN Products p on p.ProductID=od.ProductID " + 
				"WHERE o.OrderID = ";
		List<OrderDetail> result = jdbcTemplate.query(qry + id,
				(rs, rowNum) -> new OrderDetail(rs.getString("ProductName"), rs.getInt("Quantity"), 
						rs.getDouble("UnitPrice"), rs.getDouble("Discount"), rs.getDouble("Price")));

		return result;
	}
	
	public Double countOrderSubtotal (int id) {
		String qry = "SELECT sum((od.Quantity*od.UnitPrice)-(od.Quantity*od.UnitPrice)*od.Discount) as price " + 
				"FROM Orders o " + 
				"	LEFT JOIN Order_Details od on o.OrderID=od.OrderID " + 
				"WHERE o.OrderID = ";
		List<Double> result = jdbcTemplate.query(qry+id, 
				new RowMapper<Double>() {
					public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getDouble(1);
					}
				});

		return result.get(0);
	}
	
	public Double countOrderTotal (int id) {
		String qry = "SELECT sum((od.Quantity*od.UnitPrice)-(od.Quantity*od.UnitPrice)*od.Discount)+IFNULL(o.FreightCharge,0)+IFNULL(o.Taxes,0) as total_price " + 
				"FROM Orders o " + 
				"	LEFT JOIN Order_Details od on o.OrderID=od.OrderID " + 
				"WHERE o.OrderID = ";
		List<Double> result = jdbcTemplate.query(qry+id, 
				new RowMapper<Double>() {
					public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getDouble(1);
					}
				});

		return result.get(0);
	}

}
