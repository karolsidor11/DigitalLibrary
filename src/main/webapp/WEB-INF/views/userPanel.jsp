<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

    Witaj ${users}
    <%--Witaj <security:authentication property="${users}"/>--%>

    <p th:text=""></p>
</h1>


<%--PANEL I --%>
<section style="height: 8% ; border-bottom-style: outset ; border-bottom-color: blueviolet;border-bottom-width: 2px">

    <p style="position: absolute;left: 50px; float: left;font-weight: bold; font-size: 20px">Aktualna data
        :  <%=new java.util.Date().toLocaleString()%>
    </p><br>
    <a href="<c:url value="/logout" /> " style="position: absolute;right: 50px;margin-bottom: 1px">
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

        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a class="link" href="<c:url value="/findBook" />">
                <button class="btn-primary"
                        style="width: 150px ;border-radius: 5px; background-color: grey; border-color: grey">
                    Modyfikuje książkę
                </button>
            </a><br><br>
        </security:authorize>

        <security:authorize access="hasRole('ROLE_ADMIN')">
            <a class="link" title="Funkcja dostępna dla Administratora">
                <button disabled class="btn-primary"
                        style="width: 150px ;border-radius: 5px ;background-color: grey; border-color: grey">
                    Usuń książkę
                </button>
            </a>
        </security:authorize>
        <br><br><br><br><br><br><br>
        <a class="link" href="<c:url value="/" />">
            <button class="btn-primary"
                    style="width: 150px ;height: 35px;border-radius: 5px;background-color:green;border-color: green">
                POWRÓT DO STRONY GŁÓWNEJ
            </button>
        </a>
    </div>


    <%--GŁOWNE OKO --%>
    <div align="center" style="float: left; width: 64%">
        <h3 align="center">Wyszukaj książkę </h3>
        <form method="post" action="/findBook">
            <input type="text" name="title" placeholder="Podaj tytuł książki"
                   style="width: 240px; height: 45px; text-align: center ; font-size:18px ;border-radius: 5px"><br><br>
            <input type="submit" class="btn-primary" style="width: 150px;border-radius: 5px" value="Wyszukaj">

        </form>

        <c:if test="${books!=null}">
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
        </c:if>
        <br><br>

        <div align="center" style="text-align: center; color: red; font-size: 20px; ">
            ${info}
        </div>
    </div>


    <div align="center"
         style=" float:left;width: 17%;height: 85%; border-left-style: outset;border-color: blueviolet; border-width: 2px">
        <h3>Zarządznie profilem</h3>

        <a href="/allBooks">
            <button class="btn-primary"
                    style="width: 150px ;height: 35px;border-radius: 5px;background-color:green;border-color: green">
                Wyświetl dostępne książki
            </button>
        </a>
        <br><br><br><br><br>
        <div align="center">
            <h4 style=" text-align: center">Komunikaty administracyjne : </h4>
            <h4 style="color: red; text-align: center">${info}</h4>
        </div>
    </div>

</section>

</body>
</html>