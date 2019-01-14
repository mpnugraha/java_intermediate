SELECT * FROM Customers WHERE City='Irvine'
----------------------------------------------------------------------------------------------------------------------------------------------
SELECT c.* 
FROM Customers c
	LEFT JOIN Orders o on c.CustomerID=o.CustomerID
	LEFT JOIN Employees e on o.EmployeeID=e.EmployeeID
WHERE e.FirstName='Adam' and e.LastName='Barr'
----------------------------------------------------------------------------------------------------------------------------------------------
SELECT p.*
FROM Products p
	LEFT JOIN Order_Details od on p.ProductID=od.ProductID
	LEFT JOIN Orders o on od.OrderID=o.OrderID
	LEFT JOIN Customers c on c.CustomerID=o.CustomerID
WHERE c.CompanyName='Contoso, Ltd'
----------------------------------------------------------------------------------------------------------------------------------------------
SELECT o.*
FROM Orders o
	LEFT JOIN Shipping_Methods sm on o.ShippingMethodID=sm.ShippingMethodID
WHERE sm.ShippingMethod='UPS Ground'
----------------------------------------------------------------------------------------------------------------------------------------------
SELECT o.OrderID, o.OrderDate, sum((od.Quantity*od.UnitPrice)-(od.Quantity*od.UnitPrice)*od.Discount) as price, 
	sum((od.Quantity*od.UnitPrice)-(od.Quantity*od.UnitPrice)*od.Discount)+IFNULL(o.FreightCharge,0)+IFNULL(o.Taxes,0) as total_price
FROM Orders o
	LEFT JOIN Order_Details od on o.OrderID=od.OrderID
GROUP BY o.OrderID