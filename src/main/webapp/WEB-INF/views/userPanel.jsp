<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 12.11.2018
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Witaj ${user.name}</title>
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
<h2 class="h2">Witaj ${user.name} w Cyfrowej Bibliotece</h2>

<h3> Twoje hasło to : ${user.login.password}</h3
<h3> ${user.adres}</h3>
<h3> ${user.login}</h3>
<h3> ${user.lastName}</h3>

<h2>Lista dostępnych książek :</h2>

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
            <td>${book.ISBN}</td>
            <td>${book.author}</td>
            <td>${book.pages}</td>
            <td>${book.title}</td>
        </tr>

    </c:forEach>
</table>

<footer class="footer">
    <%@include file="templates/footer.jsp" %>
</footer>

</body>
</html>
