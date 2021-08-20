package com.ashiq.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {
public static void main(String[] args) {
Connection con=null;
ResultSet rs=null;
Statement st=null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3300/ashiq1", "root", "root");
	st=con.createStatement();
	rs=st.executeQuery("select * from emp1");
	System.out.println("Eno\tEname\tEsal\tEadd");
	while(rs.next()) {
		System.out.print(rs.getInt(1)+"\t");
		System.out.print(rs.getString(2)+"\t");
		System.out.print(rs.getFloat(3)+"\t");
		System.out.print(rs.getString(4));
		System.out.println("\n");
	}
	
	
} catch (Exception e) {
	e.printStackTrace();
}
finally {
	try {
		rs.close();
		st.close();
		con.close();
		
	} catch (Exception e) {
	e.printStackTrace();
	}
}
}
}
