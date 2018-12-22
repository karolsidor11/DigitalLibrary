<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 22.12.2018
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Witaj w panelu użytkownika</title>
</head>
<body>
<h1>
    Witaj w panelu uzytkowanika
    ${user.name}
</h1>
<h2>Lista dostępnych książek</h2>

<table border="1px">
    <tr>
        <td>Id</td>
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
            <td>${book.isbn}</td>
        </tr>

    </c:forEach>


    </tr>


</table>

</body>
</html>
