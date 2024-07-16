package com.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ShowTimingService {
	public void addShowTiming(int movieId, Time showTime) throws SQLException {
		try (Connection conn = DatabaseConnection.getConnection()) {
			String sql = "insert into showtimings (movie_id, show_time)values(?,?)";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, movieId);
				stmt.setTime(2, showTime);
				stmt.executeUpdate();
			}
		}
	}

	public List<String> getShowTimings(int movieId) throws SQLException {
		List<String> showTimings = new ArrayList<>();
		try (Connection conn = DatabaseConnection.getConnection()) {
			String sql = "select * from showtimings where movie_id=?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, movieId);
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						showTimings.add(rs.getTime("show_time").toString());
					}
				}
			}
		}
		return showTimings;
	}
}
