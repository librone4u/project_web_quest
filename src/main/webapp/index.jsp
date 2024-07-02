<%@ page import="com.project_web_quest.games_base_question.GamesBase" %>
<%@ page import="com.project_web_quest.model.GameDescription" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    GamesBase base = GamesBase.getInstance();
    List<GameDescription> list = base.getGameList();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Main Menu</title>
    <link rel="stylesheet" href="style/index.css">
</head>
<body>
<h2>Choose a game</h2>
<div class="game-selection">
    <%for(GameDescription game: list){%>
    <div class="game-element" id="<%=game.getGameShortName()%>">
        <h3><%=game.getGameFullName()%></h3>
        <div class="game-card"
                <%if(game.isAccess()){%>
                 onclick="play('<%=game.getGameLinkServlet()%>')"
                <%}%>>
            <img src="<%=game.getGameLinkPhoto()%>" alt="<%=game.getGameFullName()%>">
            <div class="overlay">
                <div class="text"><%=game.isReadyForPlay()%></div>
            </div>
        </div>
    </div>
    <%}%>
    <script>
        function play(link){
            <%session.setAttribute("state", "welcome");%>
            window.location.href = link;
        }
    </script>
</div>
</body>
</html>
