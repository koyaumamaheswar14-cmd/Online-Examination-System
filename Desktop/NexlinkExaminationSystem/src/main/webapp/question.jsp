<%@ page import="java.util.*, com.nexlink.dao.QuestionDAO, com.nexlink.model.Question" %>

<%
    // 🔒 SESSION SAFETY CHECK
    if (session.getAttribute("examId") == null ||
        session.getAttribute("currentSection") == null) {

        response.sendRedirect("dashboard.jsp");
        return;
    }

    Integer examId = (Integer) session.getAttribute("examId");
    String currentSection = (String) session.getAttribute("currentSection");

    Integer currentIndex = (Integer) session.getAttribute("currentIndex");
    if (currentIndex == null) {
        currentIndex = 0;
        session.setAttribute("currentIndex", 0);
    }

    QuestionDAO dao = new QuestionDAO();
    List<Question> questions = dao.getQuestionsBySection(examId, currentSection);

    if (questions == null || questions.isEmpty()) {
        out.print("<h3>No questions found for section: " + currentSection + "</h3>");
        return;
    }

    if (currentIndex >= questions.size()) {
        response.sendRedirect("nextQuestion");
        return;
    }

    Question q = questions.get(currentIndex);
%>

<h2>Section: <%= currentSection %></h2>
<h3>Question <%= currentIndex + 1 %> of <%= questions.size() %></h3>

<form method="post" action="nextQuestion">

    <p><b><%= q.getQuestion() %></b></p>

    <label><input type="radio" name="userAnswer" value="A" required> <%= q.getOptionA() %></label><br>
    <label><input type="radio" name="userAnswer" value="B"> <%= q.getOptionB() %></label><br>
    <label><input type="radio" name="userAnswer" value="C"> <%= q.getOptionC() %></label><br>
    <label><input type="radio" name="userAnswer" value="D"> <%= q.getOptionD() %></label><br><br>

    <input type="hidden" name="questionId" value="<%= q.getId() %>">

    <button type="submit">Next</button>

</form>
