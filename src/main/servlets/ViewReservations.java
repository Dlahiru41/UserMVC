import Dao.ReservationDAO;
import entities.Reservation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewReservations")
public class ViewReservations extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve userId parameter from the request
        int userId = Integer.parseInt(request.getParameter("userId"));

        // Retrieve reservations for the user from the database using ReservationDAO
        ReservationDAO reservationDAO = new ReservationDAO();
        List<Reservation> reservations = reservationDAO.getReservationsByUserId(userId);

        // Set the reservations as an attribute in the request
        request.setAttribute("reservations", reservations);

        // Forward the request to a JSP page to display the reservations
        request.getRequestDispatcher("reservations.jsp").forward(request, response);
    }
}

