<%@ page import="com.project_web_quest.games.mansionOfSecrets.ConclusionBase" %>
<%@ page import="com.project_web_quest.model.Conclusion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ConclusionBase conclusionBase = ConclusionBase.getInstance();
    Conclusion conclusion = (Conclusion) conclusionBase.getElement(request.getParameter("callBack"));
%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style/MoS_conclusion.css">
    <title><%=conclusion.getName()%></title>
</head>
<body style="background-image: url('<%= conclusion.getBackGround() %>');">
<h1><%=conclusion.getName()%></h1>
<h3><%=conclusion.getFinalText()%></h3>
</body>
</html>
