<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 02.01.2019
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzanie biblioteką </title>
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
<div>
    <a href="<c:url  value="/userPage" />">
        <button class="btn-primary" style="background-color: green; border-radius: 5px">Wstecz</button>
    </a>
    <h1 style="text-align: center;color: darkblue">
        Zarządzanie Cyfrową Biblioteką
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
         style=" float:left;width: 25%;height: 85%; border-right-style: outset;border-color: blueviolet; border-width: 2px">
        <h2 align="center" style="color:darkblue;">Dodaj / Modyfikuj książkę </h2>

        <div align="center">
            <form method="post">
                <fieldset style="width: 75%; height: 65%; align-content: center ">
                    <%--<legend style="align-content: center; border-width: 2px;">Dodawanie książki</legend>--%>
                    <label for="title">Wprowadź tytuł:</label><br>
                    <input type="text" id="title" name="title"><br>
                    <label for="author">Wprowadź autora:</label><br>
                    <input type="text" id="author" name="author"><br>
                    <label for="pages">Wprowadź ilość stron:</label><br>
                    <input type="text" id="pages" name="pages"><br>
                    <label for="isbn">Wprowadź numer ISBN:</label><br>
                    <input type="text" id="isbn" name="isbn"><br><br>

                    <input type="submit" class="btn-primary" formaction="<c:url value="/insertBook"/> " value="Dodaj"
                           style="width: 150px;height: 35px;display: block">&nbsp;&nbsp;
                    <input type="submit" class="btn-primary" formaction="<c:url value="/modifyBook"/> "
                           value="Modyfikuj"
                           style="width: 150px;height: 35px;display: block">
                </fieldset>
                <br><br>
                <div style="color:red; font-size: 15px;">
                    ${error}
                </div>

            </form>
        </div>

    </div>

    <%--GŁOWNE OKO --%>
    <div align="center" style="float: left;width: 48%">
        <h2 align="center" style="color: darkblue">Lista dostępnych książek</h2>

        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Tytuł</td>
                <td>Autor</td>
                <td>Ilość stron</td>
                <td>ISBN</td>
                <td>Zaznacz</td>
            </tr>

            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td><a href="<c:url value="/getBook"/> " name="${book.title}">${book.title}</a></td>
                    <td>${book.author}</td>
                    <td>${book.pages}</td>
                    <td>${book.isbn}</td>
                    <td><input type="checkbox"></td>
                </tr>

            </c:forEach>

            </tr>

        </table>

    </div>

    <%--Usuwanie książki --%>
    <div align="center"
         style=" float:left;width: 25%;height: 85%; border-left-style: outset;border-color: blueviolet; border-width: 2px">
        <h2 style="color: darkblue">Usuń książkę</h2>

        <form method="post" action="<c:url value="/deleteBook"/> ">

            <h4 style="text-align: center">Wprowadź id książki </h4>

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
