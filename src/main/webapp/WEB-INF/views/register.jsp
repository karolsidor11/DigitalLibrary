<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 21.12.2018
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Panel rejestracji użytkownika</title>
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
<body style="background-color: lavender">
<h2 align="center" style="color: darkblue; font-size: 30px ;font-weight: normal">Zarejestruj się w Cyfrowej
    Bibliotece</h2>

<div id="panel" align="center">

    <sf:form method="post" modelAttribute="user">
        <fieldset th:align="center" style="width: 25%; height: 70%; ">
            <legend style="align-content: center; border-width: 2px;">Rejestracja</legend>
            <h3 style="text-align: center">Dane osobowe </h3>
            <div align="center">
                Wprowadź imię: &nbsp&nbsp <sf:input path="name" title="Imię" maxlength="15"/><br><br>
                Wprowadź email :<sf:input path="email" title="Email" maxlength="40"/> <br>
            </div>

            <h3 style="text-align: center"> Dane konta </h3>

            <div align="center">
                Wprowadź login : <sf:input path="login" title="Login" maxlength="15"/><br><br>
                Wprowadź hasło : <sf:password path="password" title="Hasło" maxlength="20"/> <br><br>
                Potwierdź hasło: &nbsp; <input type="password" maxlength="20"><br>
                <br>
                <div id="lower">
                    <input class="btn-primary" type="submit" value="Zarejestruj się">
                </div>
                <br><br>
                <div style="color: red; font-size: 16px; font-weight:normal">
                        ${errors}
                </div>
            </div>
        </fieldset>

        <%--<h3 style="text-align: center">Dane osobowe </h3>--%>
        <%--<div align="center">--%>
        <%--Wprowadź imię: &nbsp&nbsp <sf:input path="name" title="Imię" maxlength="15"/><br><br>--%>
        <%--Wprowadź email :<sf:input path="email" title="Email" maxlength="40"/> <br>--%>
        <%--</div>--%>

        <%--<h3 style="text-align: center"> Dane konta </h3>--%>

        <%--<div align="center">--%>
        <%--Wprowadź login : <sf:input path="login" title="Login" maxlength="15"/><br><br>--%>
        <%--Wprowadź hasło : <sf:input path="password" title="Hasło" maxlength="20"/> <br><br>--%>
        <%--Potwierdź hasło: <input type="password" maxlength="20"><br>--%>
        <%--<br>--%>
        <%--<div id="lower">--%>
        <%--<input class="btn-primary" type="submit" value="Zarejestruj się">--%>
        <%--</div>--%>
        <%--<br><br><br><br>--%>
        <%--<div style="color: red; font-size: 25px">--%>
        <%--${errors}--%>
        <%--</div>--%>
        <%--</div>--%>

    </sf:form>
</div>
</body>
</html>
