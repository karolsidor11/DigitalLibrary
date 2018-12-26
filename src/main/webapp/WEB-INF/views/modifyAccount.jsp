<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 26.12.2018
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modyfikacja konta użytkownika</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/resources/css/arkusz.css" />" rel="stylesheet" type="text/css">
    <style>
        .btn-primary {
            color: #fff;
            background-color: #007bff;
            border-color: #007bff;
            text-align: center;
            width: 150px;
            height: 38px;
            border-radius: 5px
        }
    </style>
</head>
<body>

<br>
<h2 align="center" style="color: darkblue; font-size: 30px ;font-weight: normal">Wprowadź zmiany w Twoim koncie</h2>
<br>

<div id="panel">
    <form method="post">

        <h3 style="text-align: center">Dane osobowe </h3>

        <div align="center">
            Wprowadź imię: &nbsp&nbsp <input type="text" name="name" placeholder="Imię"><br><br>
            Wprowadź email : <input type="text" name="email" placeholder="Email"><br>
        </div>
        <br>
        <h3 style="text-align: center"> Dane konta </h3>

        <div align="center">
            Wprowadź login : <input type="text" name="login" placeholder="Login "><br><br>
            Wprowadź hasło : <input type="password" name="password" placeholder="Hasło"><br><br>
            Potwierdź hasło : &nbsp <input type="password" placeholder="Powtórz hasło"><br>
            <br>
            <div id="lower">
                <input class="btn-primary" type="submit" formaction="/updateAccount" value="Zatwierdź zmiany">
            </div>

        </div>
    </form>
</div>
<br>
<div align="center" style="color: red;font-size: medium">
    ${errors}
</div>


</body>
</html>
