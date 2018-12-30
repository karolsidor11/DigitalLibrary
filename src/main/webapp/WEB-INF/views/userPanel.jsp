<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 22.12.2018
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Panel użytkownika</title>
    <style>
        .btn-primary {
            color: #fff;
            background-color: #007bff;
            border-color: #007bff;
            width: 100px;
            height: 25px;
        }
    </style>

</head>
<body style="background-color: lavender">

<%--NAGÓŁÓEWK--%>
<h1 style="text-align: center;color: darkblue">

    Witaj <p th:text="${users}"></p>


</h1>

<%--PANEL I --%>
<section style="height: 8% ; border-bottom-style: outset ; border-bottom-color: blueviolet;border-bottom-width: 2px">

    <p style="position: absolute;left: 50px; float: left;font-weight: bold; font-size: 20px">Aktualna data
        :  <%=new java.util.Date().toLocaleString()%>
    </p><br>
    <a href="<c:url value="/perform_logout" /> " style="position: absolute;right: 50px;margin-bottom: 1px">
        <button class="btn-primary" style="width: 150px;border-radius: 5px">
            Wyloguj się
        </button>
    </a>
</section>

<%--PANEL GŁOWNY --%>
<section>

    <%--ZARZADZANIE KONTEM --%>
    <div align="center"
         style=" float:left;width: 18%;height: 85%; border-right-style: outset;border-color: blueviolet; border-width: 2px">
        <h3 align="center">Zarządznie kontem</h3>


        <a class="link" href="<c:url value="/updateAccount" />">
            <button class="btn-primary" style="width: 150px ;border-radius: 5px">
                Modyfikuj konto
            </button>
        </a><br><br>
        <a class="link" href="<c:url value="/deleteAccount" />">
            <button class="btn-primary" style="width: 150px ;border-radius: 5px">
                Usuń konto
            </button>
        </a><br><br>
        <a class="link" href="<c:url value="/addBooks"/>">
            <button class="btn-primary" style="width: 150px ;border-radius: 5px">
                Dodaj książkę
            </button>
        </a><br><br>
        <a class="link" href="<c:url value="/findBook" />">
            <button class="btn-primary"
                    style="width: 150px ;border-radius: 5px; background-color: grey; border-color: grey">
                Modyfikuje książkę
            </button>
        </a><br><br>
        <a class="link" title="Funkcja dostępna dla Administratora">
            <button disabled class="btn-primary"
                    style="width: 150px ;border-radius: 5px ;background-color: grey; border-color: grey">
                Usuń książkę
            </button>
        </a><br><br><br><br><br><br><br>
        <a class="link" href="<c:url value="/" />">
            <button class="btn-primary"
                    style="width: 150px ;height: 35px;border-radius: 5px;background-color:green;border-color: green">
                POWRÓT DO STRONY GŁÓWNEJ
            </button>
        </a>
    </div>


    <%--GŁOWNE OKO --%>
    <div align="center">
        <br>
        <input type="text" name="book" placeholder="Wyszukaj książkę"
               style="width: 240px; height: 45px; text-align: center ; font-size:18px ;border-radius: 5px"><br><br>
        <a class="link" href="<c:url value="/findBook" />">
            <button class="btn-primary" style="width: 150px ;border-radius: 5px">
                Wyszukaj
            </button>
        </a><br><br>
        <h2 align="center">Lista dostępnych książek</h2>

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

        <div align="center" style="text-align: center; color: red; font-size: 20px; ">
            ${info}
        </div>
    </div>

</section>

</body>
</html>