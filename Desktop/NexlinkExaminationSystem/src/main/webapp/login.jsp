<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">

<title>Login</title></head>
<body>

<h2>Login</h2>

<% if (request.getParameter("registered") != null) { %>
<p style="color:green;">Registration successful! Please login.</p>
<% } %>

<% if (request.getParameter("error") != null) { %>
<p style="color:red;">Invalid email or password.</p>
<% } %>

<form action="login" method="post">
    Email: <input type="email" name="email" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <button type="submit">Login</button>
</form>

<p>No account? <a href="register.jsp">Register</a></p>

</body>
</html>
