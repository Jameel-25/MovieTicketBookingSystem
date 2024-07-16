package com.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
	public void addMovie(String title, int duration) throws SQLException {
		try (Connection conn = DatabaseConnection.getConnection()) {
			String sql = "insert into movies (title, duration) values (?,?)";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, title);
				stmt.setInt(2, duration);
				stmt.executeUpdate();
			}
		}
	}

	public List<String> getAllMovies() throws SQLException {
		List<String> movies = new ArrayList<>();
		try (Connection conn = DatabaseConnection.getConnection()) {
			String sql = "select * from movies";
			try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					movies.add(rs.getString("title"));
				}
			}
		}
		return movies;
	}
}
