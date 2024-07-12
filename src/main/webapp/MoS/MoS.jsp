<%@ page import="java.util.Map" %>
<%@ page import="com.project_web_quest.model.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Question question = (Question) session.getAttribute("question");
%>
<html>
<head>
    <link rel="stylesheet" href="style/MoS.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/typed.js/2.0.6/typed.min.js"></script>
    <script src ="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <title>MoS</title>
</head>
<body>
<div class="quiz-container">
    <div class="question">
        <span class="typed-text"></span></p>
    </div>
    <% for(Map.Entry<String, String> entry:  question.getAnswers().entrySet()){%>
    <button class="answer-button" type="button" onclick="nextQuestion('<%=entry.getKey()%>')"><%= entry.getValue()%></button>
    <% } %>
    <script>
        function nextQuestion(callback) {
            window.location.href = "/TheMysteryOfTheAbandonedMansion?callBack=" + callback;
        }
        jQuery(document).ready(function(){
            var text = '<%=question.getQuestion()%>';
            var typed = new Typed(".typed-text", {
                strings: [text],
                typeSpeed: 40,
                loop: false,
                smartBackspace: false
            });
        });
    </script>
</div>
</body>
</html>
