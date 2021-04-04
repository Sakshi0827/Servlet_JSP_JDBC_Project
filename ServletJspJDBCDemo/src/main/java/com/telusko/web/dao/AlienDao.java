package com.telusko.web.dao;

import java.sql.*;
import java.sql.DriverManager;

import com.telusko.web.model.Alien;

public class AlienDao {
	
	String url = "jdbc:mysql://localhost:3306/test";
	String username = "root";
	String password = "root";
	
	public Alien getAlien(int aid) {
		
		Alien a = new Alien();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from alien where aid = " + aid);
			if(rs.next()) {
				a.setAid(rs.getInt("aid"));
				a.setAname(rs.getString("aname"));
				a.setTech(rs.getString("tech"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
	}
}
