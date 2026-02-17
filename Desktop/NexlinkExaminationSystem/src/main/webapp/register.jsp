<!DOCTYPE html>
<html>
<head><link rel="stylesheet" href="css/style.css">
<title>Register</title></head>
<body>

<h2>Register</h2>

<% if (request.getParameter("exists") != null) { %>
<p style="color:red;">Email already exists!</p>
<% } %>

<% if (request.getParameter("error") != null) { %>
<p style="color:red;">Registration failed!</p>
<% } %>

<form action="register" method="post">
    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <button type="submit">Sign Up</button>
</form>

<p>Already have account? <a href="login.jsp">Login</a></p>

</body>
</html>
