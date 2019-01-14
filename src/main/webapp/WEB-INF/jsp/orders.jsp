<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<%@page import="com.java.test.intermediate.model.Order"%>

<html lang="en">
<head>

<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
	href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	 
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<link href="/datatables/css/jquery.datatables.min.css" rel="stylesheet" />
<link href="/datatables/css/jquery.datatables_themeroller.css" rel="stylesheet" />
<link href="/fontawesome/css/font-awesome.css" rel="stylesheet" type="text/css"/>


</head>
<body>
<!--
	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="${contextPath}/hello">Home</a></li>
					<li class="active"><a href="#">Orders</a></li>
				</ul>
			</div>
		</div>
	</nav>
-->
	
	<div class="container col-md-8 col-md-offset-2 header">

		<div class="starter-template">
			<h2>Manage Orders</h2>
		</div>
		
		<div class="col-md-6">
			<div>
				<label class="col-md-6">Customer :</label>	
				<input class="col-md-6" type="text" name="customer" value="${list[0].getCustomer()}">
			</div>
			<div>
				<label class="col-md-6">Employee :</label> 
				<input class="col-md-6"  type="text" name="employee" value="${list[0].getEmployee()}">
			</div>
			<div>
				<label class="col-md-6">Shipping method : </label>
				<input class="col-md-6"  type="text" name="shippingMethod" value="${list[0].getShippingMethod()}">
			</div>
		</div>
		
		<div class="col-md-6">
			<div>
				<label class="col-md-6">Order ID :	</label> 
				<input class="col-md-6"  type="text" name="orderId" value="${list[0].getOrderID()}">
			</div>
			<div>
				<label class="col-md-6">Order Date : </label> 
				<input class="col-md-6"  type="text" name="orderDate" value="${list[0].getOrderDate()}">
			</div>
			<div>
				<label class="col-md-6">PO Number : </label> 
				<input class="col-md-6"  type="text" name="poNumber" value="${list[0].getPurchaseOrderNumber()}">
			</div>
		</div>
		<div class="col-md-12">
			<div>
				<label class="col-md-4">Comment :</label> 
				<textarea rows="4" style="width:100%"></textarea>
			</div>
		</div>

		<div style="margin-top:10px; margin-bottom:10px">
			<table id="review1" class="display table"
				style="width: 100%; cellspacing: 0;">
				<thead>
					<tr>
						<th>Product</th>
						<th>Quantity </th>
						<th>Unit Price </th>
						<th>Discount</th>
						<th>Extended Price</th>
					</tr>
				</thead>
				<tbody>					
					<c:forEach begin="0" end="${fn:length(listOrderDetail)-1}" var="index">
					   <tr>
					      <td><c:out value="${listOrderDetail[index].getProduct()}"/></td>
					      <td><c:out value="${listOrderDetail[index].getQuantity()}"/></td>
					      <td><c:out value="${listOrderDetail[index].getUnitPrice()}"/></td>
					      <td><c:out value="${listOrderDetail[index].getDiscount()}"/></td>
					      <td><c:out value="${listOrderDetail[index].getTotalPrice()}"/></td>
					   </tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
		
		<div class="col-md-6">
			<div>
				<label class="col-md-6">Ship Date :	</label> 
				<input class="col-md-6"  type="text" name="shipDate" value="${list[0].getShipDate()}">
			</div>
		</div>
		
		<div class="col-md-6">		
			<div>
				<label class="col-md-6">Order Sub Total :</label> 
				<input class="col-md-6"  type="text" name="orderST" value="${orderSubTotal}">
			</div>	
			<div>
				<label class="col-md-6">Taxes : </label> 
				<input class="col-md-6"  type="text" name="tax" value="${list[0].getTaxes()}">
			</div>
			<div>
				<label class="col-md-6">Shipping & Handling : </label> 
				<input class="col-md-6"  type="text" name="sh" value="${list[0].getFreightCharge()}">
			</div>
			<div>
				<label class="col-md-6">Order Total :	</label> 
				<input class="col-md-6"  type="text" name="orderST" value="${orderTotal}">
			</div>
		</div>
		
		<button class="row-action btn m-b-xs" onclick="firstId()"><<</button>
		<button class="row-action btn m-b-xs" onclick="prevId()"><</button>
		<button class="row-action btn m-b-xs" onclick="nextId()">></button>
		<button class="row-action btn m-b-xs" onclick="lastId()">>></button>

	</div>

	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script type="text/javascript"	src="../webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
    <script src="/datatables/js/jquery.datatables.min.js"></script>
    
	<script>
		$(document).ready(function() {
			console.log("document ready");
			$('#review1').DataTable({searching: false, paging: false, info: false});
		});
		
		function prevId()
		{			
			console.log("nextId");
			location.href='${contextPath}/orders/'+${prevId};			
		} 
		
		function nextId()
		{			
			console.log("nextId");
			location.href='${contextPath}/orders/'+${nextId};			
		} 
		
		function firstId()
		{			
			console.log("nextId");
			location.href='${contextPath}/orders/'+${firstId};			
		} 
		
		function lastId()
		{			
			console.log("nextId");
			location.href='${contextPath}/orders/'+${lastId};			
		} 
		
		
		
		
	</script>

</body>

</html>