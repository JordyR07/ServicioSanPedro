package com.sanpedro.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
	public static Connection getConexion() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/clinica", "root", "mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}
