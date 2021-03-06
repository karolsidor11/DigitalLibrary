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
<body bgcolor="#e6e6fa">

<%--NAGÓŁÓEWK--%>
<h1 style="text-align: center;color: darkblue">
    Panel Administratora
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
         style=" float:left;width: 17%;height: 85%; border-right-style: outset;border-color: blueviolet; border-width: 2px">
        <h3 align="center">Zarządznie użytkownikami </h3>


        <a class="link" href="<c:url value="/manageUsers" />">
            <button class="btn-primary" style="width: 150px ;border-radius: 5px; margin: 20px">
                Dodaj użytkownika
            </button>
        </a><br>
        <a class="link" href="<c:url value="/manageUsers" />">
            <button class="btn-primary" style="width: 150px ;border-radius: 5px">
                Modyfikuj użytkownika
            </button>
        </a><br>
        <a class="link" href="<c:url value="/manageUsers"/>">
            <button class="btn-primary" style="width: 150px ;border-radius: 5px; margin: 20px">
                Wyszukaj użytkownika
            </button>
        </a><br>
        <a class="link" href="<c:url value="/manageUsers"/>">
            <button class="btn-primary"
                    style="width: 150px ;border-radius: 5px; ">
                Usuń użytkownika
            </button>
        </a><br><br>
        <a class="link" title="Funkcja dostępna dla Administratora">
            <button class="btn-primary"
                    style="width: 150px ;border-radius: 5px ;">
                Lista użytkowników
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
    <div align="center" style="float: left;width: 64%">
        <h2 align="center">Zarządznie biblioteką </h2>

        <%--WYSZUKIWANIE KSIAŻKI--%>
        <input type="text" name="book" placeholder="Wyszukaj książkę"
               style="width: 240px; height: 45px; text-align: center ; font-size:18px ;border-radius: 5px"><br><br>
        <a class="link" href="<c:url value="/findBook" />">
            <button class="btn-primary" style="width: 150px ; height: 30px; ;border-radius: 5px">
                Wyszukaj
            </button>
        </a><br><br><br>

        <%--  FUNKCJE PODSTAWOWE--%>
        <a class="link" href="<c:url value="/findBook" />" style="margin-left: 15px">
            <button class="btn-primary"
                    style="width: 150px ;height: 35px;border-radius: 5px;background-color:green;border-color: green">
                Dodaj książkę
            </button>
        </a>
        <a class="link" href="<c:url value="/findBook" />" style="margin-left: 15px">
            <button class="btn-primary"
                    style="width: 150px ;height: 35px;border-radius: 5px;background-color:green;border-color: green">
                Modyfikuj książkę
            </button>
        </a>
        <a class="link" href="<c:url value="/findBook" />" style="margin-left: 15px">
            <button class="btn-primary"
                    style="width: 150px ;height: 35px;border-radius: 5px;background-color:green;border-color: green">
                Usuń książkę
            </button>
        </a><br>

        <%--LISTA DOSTĘPNYCH KSIAŻEK --%>
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
    </div>


    <%--ZARZADZENIE  PROFILEM --%>
    <div align="center"
         style=" float:left;width: 17%;height: 85%; border-left-style: outset;border-color: blueviolet; border-width: 2px">
        <h3>Zarządznie profilem</h3>

        <a class="link" href="<c:url value="/updateAccount" />">
            <button class="btn-primary" style="width: 150px ;border-radius: 5px">
                Modyfikuj konto
            </button>
        </a><br><br>

        <a class="link" href="<c:url value="/updateAccount" />">
            <button class="btn-primary" style="width: 150px ;border-radius: 5px">
                Dodaj administratora
            </button>
        </a><br><br><br><br><br>
        <div align="center">
            <h4 style=" text-align: center">Komunikaty administracyjne : </h4>
            <h4 style="color: red; text-align: center">${info}</h4>
        </div>
    </div>


</section>

</body>
</html>

