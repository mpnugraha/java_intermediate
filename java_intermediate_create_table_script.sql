CREATE TABLE Customers (
	CustomerID INT PRIMARY KEY,
	CompanyName VARCHAR(50),
	FirstName VARCHAR(30),
	LastName VARCHAR(50),
	BillingAddress VARCHAR(255),
	City VARCHAR(50),
	StateOrProvince VARCHAR(20),
	ZIPCode VARCHAR(20),
	Email VARCHAR(75),
	CompanyWebsite VARCHAR(200),
	PhoneNumber VARCHAR(30),
	FaxNumber VARCHAR(30),
	ShipAddress VARCHAR(255),
	ShipCity VARCHAR(50),
	ShipStateOrProvince VARCHAR(50),
	ShipZIPCode VARCHAR(20),
	ShipPhoneNumber VARCHAR(30)
)

CREATE TABLE Employees (
	EmployeeID INT PRIMARY KEY,
	FirstName VARCHAR(50),
	LastName VARCHAR(50),
	Title VARCHAR(50),
	WorkPhone VARCHAR(30)
)

CREATE TABLE Shipping_Methods (
	ShippingMethodID INT PRIMARY KEY,
	ShippingMethod VARCHAR(20)
)

CREATE TABLE Products (
	ProductID INT PRIMARY KEY,
	ProductName VARCHAR(50),
	UnitPrice DOUBLE,
	InStock CHAR(1)
)

CREATE TABLE Orders (
	OrderID INT PRIMARY KEY,
	CustomerID INT,
	EmployeeID INT,
	OrderDate DATE,
	PurchaseOrderNumber VARCHAR(30),
	ShipDate DATE,
	ShippingMethodID INT,
	FreightCharge INT,
	Taxes INT,
	PaymentReceived CHAR(1),
	Comment VARCHAR(150),
	FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
	FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID),
	FOREIGN KEY (ShippingMethodID) REFERENCES Shipping_Methods(ShippingMethodID)
)

CREATE TABLE Order_Details (
	OrderDetailID INT PRIMARY KEY,
	OrderID INT,
	ProductID INT,
	Quantity INT,
	UnitPrice DOUBLE,
	Discount DOUBLE,
	FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
	FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
)