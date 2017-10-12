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




    <div class="body">
    <#if message??>
        <div id="message" class="${messageType}">${message}</div>
    </#if>
    <#if currentPlayer==true>
        <h3>Available Players</h3>
        <form action="/game">
            <ul>
                <#list onlinePlayers?eval as row>
                    <#if row.name != playerName && row.isAvailabale == true>
                        <input type="checkbox" value="${row.name}"name="opponent">
                        <label for="opponent">${row.name}</label>



                        <br>
                    </#if>
                </#list>
            </ul>
            <button type="submit">Start</button>
        </form>

    <#else>
        <p>Welcome to the world of online Checkers.</p>
    </#if>
    </div>

</div>
</body>
</html>
