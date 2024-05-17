import Dao.ReservationDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateReservation")
public class UpdateReservation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ReservationDAO reservationDAO;

    public void init() {
        reservationDAO = new ReservationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve reservationId and numSeats parameters from the request
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        int numSeats = Integer.parseInt(request.getParameter("numSeats"));

        // Update the seat count for the reservation using ReservationDAO
        boolean updated = reservationDAO.updateSeats(reservationId, numSeats);

        if (updated) {
            // If update is successful, redirect to ViewReservations servlet to refresh the reservations list
            response.sendRedirect("seatUpdateSuccess.jsp");
        } else {
            // If update fails, handle accordingly (e.g., display error message)
            response.getWriter().println("Failed to update reservation.");
        }
    }
}
