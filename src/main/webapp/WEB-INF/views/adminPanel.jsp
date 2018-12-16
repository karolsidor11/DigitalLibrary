<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 12.11.2018
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel administratora</title>
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
<h1 align="center" style="color: darkblue">Witamy w panelu administratora </h1>

<h2>Lista dostępnych książek : </h2>

<table border="1px">
    <tr>
        <td>ID</td>
        <td>Tytuł</td>
        <td>Autor</td>
        <td>Ilość stron</td>
        <td>ISBN</td>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.pages}</td>
            <td>${book.ISBN}</td>

        </tr>
    </c:forEach>
</table>

<h2>Lista użytkowników :</h2>

<table border="1px">
    <tr>
        <td>ID</td>
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>Email</td>
        <td>Adres</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.adres}</td>
        </tr>
    </c:forEach>
</table>
<br><br>

<form:form action="console" method="get">
    <button> Baza danych</button>
</form:form>

<footer class="footer">
    <%@include file="templates/footer.jsp" %>
</footer>
</body>
</html>
