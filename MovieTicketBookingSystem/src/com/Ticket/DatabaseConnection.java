package com.Ticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USER = "c##emp";
	private static final String PASSWORD = "123";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
