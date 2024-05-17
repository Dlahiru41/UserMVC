<%@ page import="entities.Reservation" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>View Reservations</title>
  <style>
    /* General Styles */
    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f9f9f9;
      color: #333;
      margin: 0;
      padding: 0;
    }

    h1 {
      text-align: center;
      color: #2c3e50;
      margin: 30px 0;
    }

    /* Table Styles */
    table {
      border-collapse: collapse;
      width: 90%;
      margin: 0 auto;
      box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
      background-color: #fff;
    }

    th, td {
      padding: 12px 15px;
      text-align: left;
    }

    th {
      background-color: #2c3e50;
      color: #fff;
      font-weight: normal;
    }

    tr:nth-child(even) {
      background-color: #f2f2f2;
    }

    tr:hover {
      background-color: #e9e9e9;
    }

    /* Form Styles */
    form {
      display: inline-block;
    }

    input[type="number"] {
      width: 60px;
      padding: 5px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .update-btn, .delete-btn {
      background-color: #2c3e50;
      color: #fff;
      border: none;
      padding: 6px 12px;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 14px;
      margin: 4px 2px;
      cursor: pointer;
      border-radius: 4px;
    }

    .update-btn:hover {
      background-color: #1abc9c;
    }

    .delete-btn:hover {
      background-color: #e74c3c;
    }
  </style>
</head>
<body>
<h1>View Reservations</h1>
<table>
  <thead>
  <tr>
    <th>Movie ID</th>
    <th>User ID</th>
    <th>Number of Seats</th>
    <th>Reservation Date</th>
    <th>Update Seats</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <%
    // Retrieve reservations attribute from the request
    List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations");
    if (reservations != null) {
      for (Reservation reservation : reservations) {
  %>
  <tr>
    <td><%= reservation.getMovieId() %></td>
    <td><%= reservation.getUserId() %></td>
    <td><%= reservation.getNumberOfSeats() %></td>
    <td><%= reservation.getReservationDate() %></td>
    <td>
      <form action="UpdateReservation" method="post">
        <input type="hidden" name="reservationId" value="<%= reservation.getReservationId() %>">
        <input type="number" name="numSeats" min="1" required>
        <button type="submit" class="update-btn">Update</button>
      </form>
    </td>
    <td>
      <form action="DeleteReservation" method="post">
        <input type="hidden" name="reservationId" value="<%= reservation.getReservationId() %>">
        <button type="submit" class="delete-btn">Delete</button>
      </form>
    </td>
  </tr>
  <%
    }
  } else {
  %>
  <tr>
    <td colspan="5">No reservations found.</td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>

</html>
