<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 12.01.2019
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzanie zamówieniami </title>

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
<div>
    <a href="<c:url  value="/userPage" />">
        <button class="btn-primary" style="background-color: green; border-radius: 5px">Wstecz</button>
    </a>
    <h1 style="text-align: center;color: darkblue">
        Zarządzanie zamówieniami
    </h1>
</div>


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

    <%--DODAJ/ MODYFIKUJ KSIĄŻKE --%>
    <div align="center"
         style=" float:left;width: 42%;height: 100%; border-right-style: outset;border-color: blueviolet; border-width: 2px">
        <h2 align="center" style="color:darkblue;">Zamów książkę </h2>

        <div align="center">
            <c:if test="${books!=null}">

                <table border="1px">
                    <tr>
                        <td>Id</td>
                        <td>Tytuł</td>
                        <td>Autor</td>
                        <td>Ilość stron</td>
                        <td>ISBN</td>
                        <td>Zaznacz książkę</td>
                    </tr>

                    <c:forEach items="${books}" var="book">

                        <tr>
                            <td>${book.id}</td>
                            <td>${book.title}</td>
                            <td>${book.author}</td>
                            <td>${book.pages}</td>
                            <td>${book.isbn}</td>
                            <td>
                                <form method="post" action="/addOrder">
                                    <input type="hidden" name="book" value="${book.title}">
                                    <input class="btn-primary" type="submit" value="Wypożycz">
                                </form>
                            </td>
                        </tr>

                    </c:forEach>
                    </tr>
                </table>
            </c:if>

        </div>

    </div>

    <%--GŁOWNE OKO --%>
    <div align="center" style="float: left;width: 42%">
        <h2 align="center" style="color: darkblue">Lista zamówionych książek</h2>

        <c:if test="${order==null}">
            ${info}
        </c:if>

        <c:if test="${order!=null}">
            <table border="1px">
                <tr>
                    <td>Id</td>
                    <td>Tytuł</td>
                    <td>Autor</td>
                    <td>Ilość stron</td>
                    <td>ISBN</td>

                </tr>

                <c:forEach items="${order}" var="book">
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


    </div>

    <%--Usuwanie książki --%>
    <div align="center"
         style=" float:left;width: 12%;height: 100%; border-left-style: outset;border-color: blueviolet; border-width: 2px">
        <h2 style="color: darkblue">Usuń zamówienie</h2>

        <form method="post" action="<c:url value="/deleteOrder"/> ">

            <input type="text" name="id" align="center" placeholder="Wprowadź ID"><br><br>
            <input class="btn-primary" type="submit" value="Zatwierdź">

        </form>
        <br><br><br><br>
        <div>
            <h4> Komunikaty:</h4>
            <p style="color: red">${info} </p>
        </div>

    </div>

</section>


</body>
</html>
