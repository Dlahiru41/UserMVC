<%@ page import="entities.Movie" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie Seat Booking</title>
    <style>
        body {
            background: radial-gradient(circle, #ff9a9e, #fad0c4, #ffecd9);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333;
            text-shadow: 1px 1px 2px rgba(255, 255, 255, 0.5);
        }

        .view-reservations-btn {
            display: block;
            margin: 2rem auto;
            padding: 1rem 2rem;
            background-color: rgba(255, 255, 255, 0.5);
            border: none;
            border-radius: 0.5rem;
            color: #333;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 0.1rem;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .view-reservations-btn:hover {
            background-color: rgba(255, 255, 255, 0.8);
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 2rem;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 1rem;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
        }

        h1 {
            text-align: center;
            font-size: 3rem;
            margin-bottom: 2rem;
            text-transform: uppercase;
            letter-spacing: 0.5rem;
            color: #333;
            text-shadow: 2px 2px 4px rgba(255, 255, 255, 0.5);
        }

        label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: bold;
            color: #333;
            text-shadow: 1px 1px 2px rgba(255, 255, 255, 0.5);
        }

        select, input[type="number"], input[type="date"] {
            width: 100%;
            padding: 0.5rem;
            border: none;
            border-radius: 0.5rem;
            background-color: rgba(255, 255, 255, 0.5);
            color: #333;
            font-weight: bold;
            margin-bottom: 1rem;
        }

        input[type="submit"] {
            display: block;
            margin: 2rem auto 0;
            padding: 1rem 2rem;
            background-color: rgba(255, 255, 255, 0.5);
            border: none;
            border-radius: 0.5rem;
            color: #333;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 0.1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: rgba(255, 255, 255, 0.8);
        }

    </style>
</head>
<body>
<a href="ViewReservations?userId=<%= request.getParameter("userId") %>" class="view-reservations-btn">View Reservations</a>

<div class="container">
    <h1>Movie Seat Booking</h1>
    <form id="bookingForm" action="SaveReservation" method="post">
        <!-- Hidden input field to include userId -->
        <input type="hidden" id="userId" name="userId" value="<%= request.getParameter("userId") %>">

        <label for="movie">Select Movie:</label>
        <select id="movie" name="movieId">
            <%-- Dynamically populate options from movie data fetched from the servlet --%>
            <%
                List<Movie> movies = (List<Movie>) request.getAttribute("movies");
                if (movies != null) {
                    for (Movie movie : movies) {
            %>
            <option value="<%= movie.getId() %>"><%= movie.getName() %></option>
            <%
                    }
                }
            %>
        </select>
        <label for="numSeats">Number of Seats:</label>
        <input type="number" id="numSeats" name="numSeats" min="1" required>
        <label for="seatCategory">Seat Category:</label>
        <select id="seatCategory" name="seatCategory">
            <option value="OCR">OCR</option>
            <option value="Balcony">Balcony</option>
            <option value="Couple Box">Couple Box</option>
        </select>
        <label for="date">Select Date:</label>
        <input type="date" id="date" name="date" required>
        <input type="submit" value="Book Seats">
    </form>
</div>
</body>
</html>




