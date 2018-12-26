<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 21.12.2018
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Witaj w panelu administratora</title>
</head>
<body>
<h1 style="color: darkblue; text-align: center">Witaj w panelu administratora</h1>

<h2>
    Lista uzytkowników
</h2>

<a class="link" href="<c:url value="/addBook" />">
    <button class="btn btn-primary" style="width: 150px">
        Logowanie
    </button>
</a>


<table border="1px">
    <tr>
        <td>Id</td>
        <td>Imię</td>
        <td>Email</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>

<h3 style="color: red">
    ${info}
</h3>

</body>
</html>

