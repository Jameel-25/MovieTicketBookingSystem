  **Movie Ticket Booking System**

   Overview
The Movie Ticket Booking System is a comprehensive core Java project that simulates the functionalities of a movie ticket booking platform. This project involves various core Java concepts such as JDBC (Java Database Connectivity), multi-threading, string handling, and the collection framework. It is designed to interact with an Oracle database to manage movies, show timings, and bookings.

   Features
- Booking Tickets: Allows users to book tickets for a movie show.
- Canceling Tickets: Provides functionality to cancel booked tickets.
- Adding Movies and Show Timings: Enables adding new movies and show timings to the system.
- Viewing Show Timings: Displays show timings for selected movies.
- Multi-threading: Handles concurrent booking and cancellation operations efficiently.
- String Handling: Manages and processes string data related to movies and show timings.
- Collections Framework: Utilizes various collection classes for efficient data management.

   Technologies Used
- Java: Core Java concepts including multi-threading, strings, and collections.
- JDBC: For database connectivity and operations.
- Oracle Database: To store and manage movie, show timings, and booking data.
- Eclipse IDE: For development and testing.

   Database Schema
    Movies Table
sql
CREATE TABLE Movies (
    movie_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    title VARCHAR2(255) NOT NULL,
    duration NUMBER NOT NULL
);


    ShowTimings Table
sql
CREATE TABLE ShowTimings (
    show_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    movie_id NUMBER,
    show_time TIMESTAMP,
    CONSTRAINT fk_movie
        FOREIGN KEY (movie_id)
        REFERENCES Movies(movie_id)
);


    Bookings Table
sql
CREATE TABLE Bookings (
    booking_id NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    show_id NUMBER,
    num_tickets NUMBER,
    status VARCHAR2(50),
    CONSTRAINT fk_show
        FOREIGN KEY (show_id)
        REFERENCES ShowTimings(show_id)
);


   Project Structure

MovieTicketBookingSystem/
├── src/
│   ├── com/
│   │   ├── moviebooking/
│   │   │   ├── DatabaseConnection.java
│   │   │   ├── MovieService.java
│   │   │   ├── ShowTimingService.java
│   │   │   ├── BookingService.java
│   │   │   └── Main.java
├── lib/
│   └── ojdbc8.jar (Oracle JDBC Driver)
├── README.md


   Setup Instructions
1. Clone the repository:
   bash
   git clone https://github.com/Jameel-25/MovieTicketBookingSystem.git
   cd MovieTicketBookingSystem
   

2. Install Oracle Database: Ensure Oracle Database is installed and running.

3. Create Database and Tables:
   - Open Oracle SQL Developer or any SQL client.
   - Execute the SQL scripts provided in the Database Schema section to create the necessary tables.

4. Configure the Database Connection:
   - Open DatabaseConnection.java.
   - Update the URL, USER, and PASSWORD fields with your Oracle database details.

5. Add Oracle JDBC Driver:
   - Download the Oracle JDBC driver (ojdbc8.jar) if not already present.
   - Add it to the lib/ directory.
   - Add the JAR to your project's build path in Eclipse.

6. Run the Project:
   - Open Eclipse IDE.
   - Import the project.
   - Run the Main.java class as a Java Application.

   Usage
- Add Movies: Use the MovieService to add new movies.
- Add Show Timings: Use the ShowTimingService to add show timings for movies.
- Book Tickets: Use the BookingService to book tickets for a specific show.
- Cancel Tickets: Use the BookingService to cancel bookings.
- View Show Timings: Retrieve and display show timings for movies.
