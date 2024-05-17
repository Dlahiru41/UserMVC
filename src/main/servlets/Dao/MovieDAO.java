package Dao;

import entities.Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/movie_theatre";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    private static Connection con;

    // SQL queries
    private static final String SELECT_ALL_MOVIES = "SELECT * FROM movies";

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
    // Method to retrieve all movies from the database
    public static List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        try (
                // Establish a connection
                Connection connection = MovieDAO.getConnection();
                // Create a statement
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES);
                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            // Iterate over the result set and create Movie objects
            while (resultSet.next()) {
                int id = resultSet.getInt("movieId");
                String name = resultSet.getString("movieName");
                int length = resultSet.getInt("movieLength");

                // Create a Movie object and add it to the list
                Movie movie = new Movie(id, name, length);
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception (e.g., log it or throw a custom exception)
        }

        return movies;
    }
}

