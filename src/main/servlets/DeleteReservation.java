import Dao.ReservationDAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteReservation")
public class DeleteReservation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ReservationDAO reservationDAO;

    public void init() {
        reservationDAO = new ReservationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve reservationId parameter from the request
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));

        // Delete the reservation using ReservationDAO
        boolean deleted = reservationDAO.deleteReservation(reservationId);

        if (deleted) {
            // If deletion is successful, redirect to ViewReservations servlet to refresh the reservations list
            response.sendRedirect("deleteSuccess.jsp");

        } else {
            // If deletion fails, handle accordingly (e.g., display error message)
            response.getWriter().println("Failed to delete reservation.");
        }
    }
}
