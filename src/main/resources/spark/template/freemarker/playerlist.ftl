<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div class="page">

    <h1>Web Checkers</h1>

    <div class="navigation">
        <a href="/">my home</a>
    </div>


<#if playerList??>
    <div class="body">
        <p>Choose Your Opponent:</p>
        <ul>
            <#list playerList as player>
                <#if player == username>
                <a href="/requestGame?opponentName=${player}&username=${username}">
                    <li>${player}</li>
                </a>
                </#if>
            </#list>
        </ul>
    </div>
</#if>

</div>
</body>
</html>