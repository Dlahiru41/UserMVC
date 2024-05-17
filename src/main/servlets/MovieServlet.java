import Dao.MovieDAO;
import Dao.ReservationDAO;
import entities.Movie;
import entities.Reservation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch movie data from the database (you need to implement this logic)
        List<Movie> movies = MovieDAO.getAllMovies(); // Assuming MovieDAO is a class to interact with the database

        // Set movie data as an attribute in the request object
        request.setAttribute("movies", movies);
        for(Movie movie: movies) {
            System.out.println(movie.getName());
        }

        // Forward the request to the JSP page
        request.getRequestDispatcher("booking.jsp").forward(request, response);
    }


}
