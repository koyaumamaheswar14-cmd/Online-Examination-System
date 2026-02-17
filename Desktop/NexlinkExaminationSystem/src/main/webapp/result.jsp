<%@ page import="com.nexlink.dao.ResultDAO, com.nexlink.model.ExamResult" %>

<%
    Integer userId = (session != null)
            ? (Integer) session.getAttribute("user_id")
            : null;

    if (userId == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    ResultDAO dao = new ResultDAO();
    ExamResult r = dao.getOverallResult(userId);

    if (r == null) {
        out.println("<h2>No result found</h2>");
        return;
    }
%>

<h2>Overall Exam Result</h2>
<p>Total: <%= r.getTotal() %></p>
<p>Correct: <%= r.getCorrect() %></p>
<p>Incorrect: <%= r.getIncorrect() %></p>
<p>Unanswered: <%= r.getUnanswered() %></p>
<p>Percentage: <%= String.format("%.2f", r.getPercentage()) %>%</p>
