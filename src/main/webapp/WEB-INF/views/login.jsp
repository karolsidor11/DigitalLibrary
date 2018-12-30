<%--&lt;%&ndash;--%>
<%--Created by IntelliJ IDEA.--%>
<%--User: Użytkownik--%>
<%--Date: 29.12.2018--%>
<%--Time: 10:46--%>
<%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>


<html xmlns:th="http://www.thymeleaf.org">
<head th:include="layout :: head(title=~{::title},links=~{})">
    <title>Panel logowania</title>
    <style>
        .btn-primary {
            color: #fff;
            background-color: #007bff;
            border-color: #007bff;
            border-radius: 5px
        }
    </style>
</head>
<body th:include="layout :: body" th:with="content=~{::content}" style="background-color: lavender">

<div align="center " style="color: red; font-size: 15px;">
   ${logout}
</div>

<h2 align="center" style="color: darkblue; font-size: 30px ;font-weight: normal">Zaloguj się do swojego konta </h2>
<div th:fragment="content" align="center">
    <form name="f" th:action="@{/login}" method="post">
        <fieldset th:align="center" style="width: 25%; height: 50%; ">
            <legend style="align-content: center; border-width: 2px;">Logowanie</legend>
            <br>
            <div align="center" style="color: darkblue;font-size: 25px"> Formularz logowania</div>
            <br><br>

            <label for="username">Nazwa użytkownika: </label><br>
            <input type="text" id="username" placeholder="Login" name="username"/><br><br>
            <label for="password">Hasło: </label><br>
            <input type="password" id="password" placeholder="Hasło" name="password"/><br><br>
            <div class="form-actions">
                <button type="submit" class="btn-primary" style="width: 150px; height: 35px; border-radius: 5px">
                    Zaloguj się
                </button>
            </div>
            <br><br>
            <div style="color:red; font-size: 15px;"> ${error} </div>

            <div th:if="${param.error}" class="alert alert-error">
                <%--Nieprawidłowa nazwa użytkownika lub hasło.--%>
            </div>
            <div th:if="${param.logout}" class="alert alert-success">
                <%--Zostałeś wylogowany.--%>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>


