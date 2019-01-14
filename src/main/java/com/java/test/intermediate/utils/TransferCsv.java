package com.java.test.intermediate.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;

@Repository
public class TransferCsv {
	@Autowired
	private static JdbcTemplate jdbcTemplate;
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3307/java_intermediate";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Connection conn = null;
	    Statement stmt = null;
	    Scanner scn = new Scanner(System.in);
	    
	    conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);

	    		
		File dir = new File("attachments_test_java");
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				System.out.println(child.getName());
				List<List<String>> records = new ArrayList<>();
				try (BufferedReader br = new BufferedReader(new FileReader("attachments_test_java\\"+child.getName()))) {
					String line;
					while ((line = br.readLine()) != null) {
						String[] values = line.split(";");
						records.add(Arrays.asList(values));
					}
				}				
				
				String header = String.join(", ", records.get(0));
				System.out.println(header);
				for (int i=1;i<records.size();i++) {
					String content = String.join(", ", records.get(i));
					System.out.println(content);
					String sql = "";
					PreparedStatement preparedStatement = null;
					
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
					
					switch (child.getName()) {
						case  "Employees.csv" :
							sql = "INSERT INTO Employees (" + header + ")" +
							        "VALUES (?, ?, ?, ?, ?)";
							preparedStatement = conn.prepareStatement(sql);
							preparedStatement.setInt(1, Integer.parseInt(records.get(i).get(0)));
							preparedStatement.setString(2, records.get(i).get(1));
							preparedStatement.setString(3, records.get(i).get(2));
							preparedStatement.setString(4, records.get(i).get(3));
							preparedStatement.setString(5, records.get(i).get(4));
							preparedStatement.executeUpdate(); 
							break;
						case  "ShippingMethods.csv" :
							sql = "INSERT INTO ShippingMethods (" + header + ")" +
							        "VALUES (?, ?)";
							preparedStatement = conn.prepareStatement(sql);
							preparedStatement.setInt(1, Integer.parseInt(records.get(i).get(0)));
							preparedStatement.setString(2, records.get(i).get(1));
							preparedStatement.executeUpdate(); 
							break;
						case  "Customers.csv" :
							sql = "INSERT INTO Customers (" + header + ")" +
							        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
							preparedStatement = conn.prepareStatement(sql);
							preparedStatement.setInt(1, Integer.parseInt(records.get(i).get(0)));
							preparedStatement.setString(2, records.get(i).get(1));
							preparedStatement.setString(3, records.get(i).get(2));
							preparedStatement.setString(4, records.get(i).get(3));
							preparedStatement.setString(5, records.get(i).get(4));
							preparedStatement.setString(6, records.get(i).get(5));
							preparedStatement.setString(7, records.get(i).get(6));
							preparedStatement.setString(8, records.get(i).get(7));
							preparedStatement.setString(9, records.get(i).get(8));
							preparedStatement.setString(10, records.get(i).get(9));
							preparedStatement.setString(11, records.get(i).get(10));
							preparedStatement.setString(12, records.get(i).get(11));
							preparedStatement.setString(13, records.get(i).get(12));
							preparedStatement.setString(14, records.get(i).get(13));
							preparedStatement.setString(15, records.get(i).get(14));
							preparedStatement.setString(16, records.get(i).get(15));
							preparedStatement.setString(17, records.get(i).get(16));
							preparedStatement.executeUpdate(); 
							break;
						case  "OrderDetails.csv" :
							sql = "INSERT INTO OrderDetails (" + header + ")" +
							        "VALUES (?, ?, ?, ?, ?, ?)";
							preparedStatement = conn.prepareStatement(sql);
							preparedStatement.setInt(1, Integer.parseInt(records.get(i).get(0)));
							preparedStatement.setInt(2, Integer.parseInt(records.get(i).get(1)));
							preparedStatement.setInt(3, Integer.parseInt(records.get(i).get(2)));
							preparedStatement.setInt(4, Integer.parseInt(records.get(i).get(3)));
							preparedStatement.setDouble(5, Double.parseDouble(records.get(i).get(4)));
							preparedStatement.setDouble(6, Double.parseDouble(records.get(i).get(5)));
							preparedStatement.executeUpdate(); 
							break;
						case  "Orders.csv" :
							sql = "INSERT INTO Orders (" + header + ")" +
							        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
							preparedStatement = conn.prepareStatement(sql);
							preparedStatement.setInt(1, Integer.parseInt(records.get(i).get(0)));
							preparedStatement.setInt(2, Integer.parseInt(records.get(i).get(1)));
							preparedStatement.setInt(3, Integer.parseInt(records.get(i).get(2)));
							preparedStatement.setString(4, records.get(i).get(3));
							preparedStatement.setString(5, records.get(i).get(4));
							preparedStatement.setString(6, records.get(i).get(5));
							preparedStatement.setInt(7, Integer.parseInt(records.get(i).get(6)));
							preparedStatement.setInt(8, Integer.parseInt(records.get(i).get(7)));
							preparedStatement.setInt(9, Integer.parseInt(records.get(i).get(8)));
							preparedStatement.setString(10, records.get(i).get(9));
							preparedStatement.setString(11, records.get(i).get(10));
							preparedStatement.executeUpdate(); 
							break;
						case  "Products.csv" :
							sql = "INSERT INTO Products (" + header + ")" +
							        "VALUES (?, ?, ?, ?)";
							preparedStatement = conn.prepareStatement(sql);
							preparedStatement.setInt(1, Integer.parseInt(records.get(i).get(0)));
							preparedStatement.setString(2, records.get(i).get(1));
							preparedStatement.setDouble(3, Double.parseDouble(records.get(i).get(2)));
							preparedStatement.setString(4, records.get(i).get(3));
							preparedStatement.executeUpdate(); 
							break;
					}
					
					
				}
				
			}
		}

		

		
	}
}
