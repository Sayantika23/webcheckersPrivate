<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class = "page">

    <h1>Web Checkers </h1>

    <div class = "navigation">
        <div class = "body">
            <p>Welcome to the world of online Checkers. </p>
            <h3>Enter the game</h3>
        <#if message??>
            <div id = "message" class = "${messageType}">${message}</div>
        </#if>
            <form action = "/SignIn" method = "post">
                <input type ="text" placeholder="Enter your name" name ="username">
                <button type="submit"> Start Game!</button>
            </form>
        </div>

    </div>
</body>
</html>