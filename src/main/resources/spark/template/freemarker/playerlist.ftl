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


<#if username??>
    <#if usernames??>
        <p>Choose your Opponent</p>
        <ul>
            <#list usernames as playerInGame>
                <#if playerInGame != username>
                    <li>
                        <a href="/requestGame?contendor=${playerInGame}">
                        ${playerInGame}
                        </a>
                    </li>
                </#if>
            </#list>
        </ul>
    </#if>
</#if>
</div>

</div>
</body>
</html>