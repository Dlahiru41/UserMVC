import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/ValidateLoginServlet")
public class ValidateLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int userId = -1;

        try (
                Connection connection = LoginServlet.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE userName = ? AND password = ?");
        ) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // User found, get the user ID
                userId = resultSet.getInt("userId");
                // Forward to booking.jsp and pass user ID as an attribute
                request.setAttribute("userId", userId);
                // User found, redirect to home page or another secured page
                response.sendRedirect("MovieServlet?userId=" + userId);
            } else {
                // User not found, display login page again with error message
                request.setAttribute("errorMessage", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection or query errors
        }
    }
}
