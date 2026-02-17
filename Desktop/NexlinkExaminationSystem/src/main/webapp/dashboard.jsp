<%@ page contentType="text/html;charset=UTF-8" %>

<%
    if (session.getAttribute("userName") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String name = (String) session.getAttribute("userName");
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">

    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f3f6fb;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 60%;
            margin: 80px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            color: #333;
        }
        button {
            padding: 12px 20px;
            border: none;
            background: #1976d2;
            color: white;
            font-size: 16px;
            border-radius: 8px;
            cursor: pointer;
        }
        button:hover {
            background: #0d47a1;
        }
        .logout {
            margin-top: 20px;
            background: #d32f2f;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>Welcome, <%= name %> 👋</h2>
    <p>You can start your exam from below.</p>

    <a href="examinfo.jsp">
        <button>Go to Exam Info</button>
    </a>

    <br><br>
     <a href="finish.jsp">
        <button class="Results">Results</button>
    </a>
    <a href="logout.jsp">
        <button class="logout">Logout</button>
    </a>
</div>

</body>
</html>
