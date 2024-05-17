import Dao.ReservationDAO;
import entities.Reservation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/SaveReservation")
public class SaveReservation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form data
        int userId = Integer.parseInt(request.getParameter("userId")); // New parameter
        int movieId = Integer.parseInt(request.getParameter("movieId"));
        int numSeats = Integer.parseInt(request.getParameter("numSeats"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));

        // Create a Reservation object
        Reservation reservation = new Reservation(movieId,userId, numSeats, date);

        // Insert reservation into the database
        ReservationDAO.insertReservation(reservation);

        // Redirect to a confirmation page
        response.sendRedirect("confirmation.jsp");
    }
}
