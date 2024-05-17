package Dao;

import entities.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/movie_theatre";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            System.out.println("Connection established: " + con);
        } catch (SQLException e) {
            System.out.println("Message.. " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Message.. " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
    // Method to insert a reservation into the database
    public static void insertReservation(Reservation reservation) {
        try (
                // Establish a connection
                Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                // Create a prepared statement
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO reservation (movieId, userId, numberOfSeats, reservationDate) VALUES (?, ?, ?, ?)"
                );
        ) {
            // Set parameters
            preparedStatement.setInt(1, reservation.getMovieId());
            preparedStatement.setInt(2, reservation.getUserId());
            preparedStatement.setInt(3, reservation.getNumberOfSeats());
            preparedStatement.setObject(4, reservation.getReservationDate());

            // Execute the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception (e.g., log it or show error message to user)
        }
    }

    // Method to retrieve reservations by userId
    public List<Reservation> getReservationsByUserId(int userId) {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservation WHERE userId = ?";

        try (PreparedStatement statement = ReservationDAO.getConnection().prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Create Reservation object from ResultSet
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getInt("reservationId"));
                reservation.setMovieId(resultSet.getInt("movieId"));
                reservation.setUserId(resultSet.getInt("userId"));
                reservation.setNumberOfSeats(resultSet.getInt("numberOfSeats"));
                reservation.setReservationDate(resultSet.getDate("reservationDate").toLocalDate());

                // Add Reservation object to list
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }

        return reservations;
    }

    // Method to delete a reservation by reservationId
    public boolean deleteReservation(int reservationId) {
        String query = "DELETE FROM reservation WHERE reservationId = ?";

        try (PreparedStatement statement = ReservationDAO.getConnection().prepareStatement(query)) {
            statement.setInt(1, reservationId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
            return false;
        }
    }

    // Method to update the number of seats for a reservation
    public boolean updateSeats(int reservationId, int numSeats) {
        String query = "UPDATE reservation SET numberOfSeats = ? WHERE reservationId = ?";

        try (PreparedStatement statement = ReservationDAO.getConnection().prepareStatement(query)) {
            statement.setInt(1, numSeats);
            statement.setInt(2, reservationId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
            return false;
        }
    }
}