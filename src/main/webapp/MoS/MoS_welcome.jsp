<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/style/MoS_welcome.css">
    <title>Mansion of Secrets</title>
</head>
<body>
<div class="container">
    <h1>The Mystery of the Abandoned Mansion</h1>
    <p>
        Many years ago, on the outskirts of a small town, there stood a majestic mansion belonging to the wealthy and influential Devereaux family. The family lived in luxury and fame, but one fateful night, the entire family vanished without a trace. The mansion was left deserted, and its splendor gradually turned into ruins. The town began to be enveloped in rumors and legends about a curse placed on the house and its surroundings.
    </p>
    <p>
        The town's residents claim that at night, strange sounds and lights come from the mansion, as if the house itself is trying to tell its dark story. Rumors say that within the mansion's walls are hidden the immense riches of the Devereaux family, as well as ancient artifacts possessing incredible power. But anyone who tried to enter the mansion either never returned or came back with strange stories and in a state of shock.
    </p>
    <p>
        You, a young and ambitious paranormal investigator, have always been fascinated by mysteries and enigmas. Upon learning about the Devereaux mansion, you decide to go there to uncover its secret and perhaps find the hidden treasures. Equipped with the necessary gear and full of courage, you set off for the abandoned mansion.
    </p>
    <p>
        You stand at its gates, looking at the overgrown shrubs and partially collapsed walls, feeling a chill run down your spine. Now you must make a choice that will determine your fate. Will you be able to uncover the mystery of the vanished Devereaux family and escape this eerie place alive, or will you become one of the many legends surrounding this enigmatic mansion?
    </p>
    <button class="start-button" onclick="startGame()">Start Game</button>
</div>
<script>
    function startGame() {
        <%
        session.setAttribute("state", "playing");
        session.setAttribute("knowledge", "false");
        ;%>
        window.location.href = "/TheMysteryOfTheAbandonedMansion?callBack=start";
    }
</script>
</body>
</html>
