package com.Ticket;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		MovieService movieService = new MovieService();
		ShowTimingService showTimingService = new ShowTimingService();
		BookingService bookingService = new BookingService();

		try {
			// Adding movies
			movieService.addMovie("Inception", 148);
			movieService.addMovie("The Dark Knight", 152);

			// Getting all movies
			List<String> movies = movieService.getAllMovies();
			System.out.println("Movies:");
			for (String movie : movies) {
				System.out.println(movie);
			}

			// Adding show timings
			showTimingService.addShowTiming(1, Time.valueOf("14:30:00"));
			showTimingService.addShowTiming(1, Time.valueOf("18:00:00"));
			showTimingService.addShowTiming(2, Time.valueOf("15:30:00"));

			// Getting show timings for a movies
			List<String> showTimings = showTimingService.getShowTimings(1);
			System.out.println("Show Timings for Inception:");
			for (String timing : showTimings) {
				System.out.println(timing);
			}

			// Booking tickets
			bookingService.bookTickets(1, 2);
			bookingService.bookTickets(2, 3);

			// Canceling a booking
			bookingService.cancelBooking(1);

			// Getting number of tickets for a booking
			int numTickets = bookingService.getNUmberOfTickets(2);
			System.out.println("Number of tickets for booking 2: " + numTickets);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
