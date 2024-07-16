package com.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingService {
	public void bookTickets(int showId, int numTickets) throws SQLException {
		try (Connection conn = DatabaseConnection.getConnection()) {
			String sql = "insert into bookings (show_id, num_tickets, status) values (?,?,'Booked')";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, showId);
				stmt.setInt(2, numTickets);
				stmt.executeUpdate();
			}
		}
	}

	public void cancelBooking(int bookingId) throws SQLException {
		try (Connection conn = DatabaseConnection.getConnection()) {
			String sql = "update bookings set status = 'Cancelled' where booking_id=?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, bookingId);
				stmt.executeUpdate();
			}
		}
	}

	public int getNUmberOfTickets(int bookingId) throws SQLException {
		try (Connection conn = DatabaseConnection.getConnection()) {
			String sql = "select num_tickets from bookings where booking_id=?";
			try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, bookingId);
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						return rs.getInt("num_tickets");
					}
				}
			}
		}
		return 0;
	}
}
