<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Main Menu</title>
    <link rel="stylesheet" href="style/index.css">
</head>
<body>
<h2>Choose a game</h2>
<div class="game-selection">
    <div class="MoS">
        <h3>The mystery of the Abandoned Mansion</h3>
        <div class="game-card" onclick="play('/TheMysteryOfTheAbandonedMansion')">
            <img src="photo/mansion.jpeg" alt="The Mystery Of The Abandoned Mansion">
            <div class="overlay">
                <div class="text">Играть</div>
            </div>
        </div>
    </div>
    <script>
        function play(link){
            <%session.setAttribute("state", "welcome");%>
            window.location.href = link;
        }
    </script>
</div>
</body>
</html>
