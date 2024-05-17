
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <style>
    /* General Styles */
    body {
      font-family: 'Montserrat', sans-serif;
      background: linear-gradient(to right, #fbc2eb, #a6c1ee);
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    h1 {
      color: #fff;
      text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
      text-align: center;
      margin-bottom: 30px;
    }

    /* Form Styles */
    form {
      background-color: rgba(255, 255, 255, 0.8);
      padding: 40px;
      border-radius: 10px;
      box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
    }

    label {
      display: block;
      color: #333;
      font-weight: bold;
      margin-bottom: 10px;
    }

    input[type="text"],
    input[type="password"] {
      width: 100%;
      padding: 10px;
      border: none;
      border-radius: 5px;
      background-color: rgba(255, 255, 255, 0.8);
      margin-bottom: 20px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
    }

    input[type="submit"] {
      width: 100%;
      padding: 10px;
      border: none;
      border-radius: 5px;
      background: linear-gradient(to right, #ff9a9e, #fad0c4);
      color: #fff;
      font-weight: bold;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
      background: linear-gradient(to right, #fad0c4, #ff9a9e);
    }
  </style>
</head>
<body>
<h1>Login</h1>
<form action="ValidateLoginServlet" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required><br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br>
  <input type="submit" value="Login">
</form>
</body>
</html>

