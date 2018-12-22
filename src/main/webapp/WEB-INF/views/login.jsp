<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 21.12.2018
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel logowania użytkownika</title>
    <link rel="stylesheet" href="resources/css/arkusz.css" type="text/css">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body style="background-color: lavender">

<div id="loginForm" align="center">
    <br><br>
    <h2 style=" color: darkblue ;text-align: center; font-size: 30px">Zaloguj się do swojego konta</h2><br>


    <div id="panel">
        <form method="post">
            <label for="username">Nazwa użytkownika:</label>
            <input type="text" id="username" name="login">
            <label for="password">Hasło:</label>
            <input type="password" id="password" name="password">
            <div id="lower">
                <input type="checkbox"><label class="check">Zapamiętaj mnie!</label>
                <input class="btn btn-primary" type="submit" formaction="loginProcess"
                       style="height: 38px; width: 150px; position: center" value="Zaloguj się">
            </div>
        </form>
    </div>

</div>

</body>
</html>
