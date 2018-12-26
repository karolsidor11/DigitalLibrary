<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 21.12.2018
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Panel logowania użytkownika</title>
    <%--<link rel="stylesheet" href="resources/css/arkusz.css" type="text/css">--%>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/arkusz.css" />" rel="stylesheet" type="text/css">
    <style>
        .btn-primary {color: #fff;background-color: #007bff;border-color: #007bff;border-radius: 5px}
    </style>
</head>
<body style="background-color: lavender">

<div align="center">
    <br><br>
    <h2 style=" color: darkblue ;text-align: center; font-size: 30px">Zaloguj się do swojego konta</h2><br>

    <div align="center">
        <form method="post">
            <label for="username">Nazwa użytkownika:</label><br>
            <input type="text" id="username" name="login"><br>
            <label for="password">Hasło:</label><br>
            <input type="password" id="password" name="password"><br><br>

            <input type="submit" class="btn-primary" formaction="loginProcess" value="Zaloguj się"
                   style="width: 150px;height: 38px;display: block">
        </form>
    </div>
</div>
<br>
<div align="center" style="color: red; font-size: medium">
    ${errors}
</div>

</body>
</html>
