<%@ page import="java.util.*, com.nexlink.dao.QuestionDAO, com.nexlink.model.Question" %>

<%
    Integer examId = (Integer) session.getAttribute("examId");
    String currentSection = (String) session.getAttribute("currentSection");
    Integer currentIndex = (Integer) session.getAttribute("currentIndex");

    if (examId == null || currentSection == null) {
        out.println("<h3>Error: Exam or Section not selected.</h3>");
        return;
    }

    if (currentIndex == null) {
        currentIndex = 0;
        session.setAttribute("currentIndex", 0);
    }

    QuestionDAO dao = new QuestionDAO();
    List<Question> questions = dao.getQuestionsBySection(examId, currentSection);

    if (questions.isEmpty()) {
        out.print("<h3>No questions found for section: " + currentSection + "</h3>");
        return;
    }

    if (currentIndex >= questions.size()) {
        out.print("<h2>SECTION COMPLETED</h2>");
        out.print("<a href='login.jsp'>Go Back</a>");
        return;
    }

    Question q = questions.get(currentIndex);
%>

<h2>Section: <%= currentSection %></h2>

<form method="post" action="nextQuestion">
    <p><b><%= q.getQuestion() %></b></p>

    <input type="radio" name="userAnswer" value="A" required> <%= q.getOptionA() %><br>
    <input type="radio" name="userAnswer" value="B"> <%= q.getOptionB() %><br>
    <input type="radio" name="userAnswer" value="C"> <%= q.getOptionC() %><br>
    <input type="radio" name="userAnswer" value="D"> <%= q.getOptionD() %><br><br>

    <input type="hidden" name="questionId" value="<%= q.getId() %>">

    <button type="submit">Next</button>
</form>
