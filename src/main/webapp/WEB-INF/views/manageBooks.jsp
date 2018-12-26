<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 23.12.2018
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzanie książkami</title>
    <style>
        .btn-primary {
            color: #fff;
            background-color: #007bff;
            border-color: #007bff;
            text-align: center;
            width: 150px;
            height: 38px;
            border-radius: 5px
        }
    </style>
</head>
<body>
<h1 align="center" style="color: darkblue">Witaj w panelu zarządznia książkami </h1>

<div id="panel">

    <div align="center">
        <form method="post">
            <label for="title">Wprowadź tytuł:</label><br>
            <input type="text" id="title" name="title"><br>
            <label for="author">Wprowadź autora:</label><br>
            <input type="text" id="author" name="author"><br>
            <label for="pages">Wprowadź ilość stron:</label><br>
            <input type="text" id="pages" name="pages"><br>
            <label for="isbn">Wprowadź numer ISBN:</label><br>
            <input type="text" id="isbn" name="isbn"><br>

            <input type="submit" class="btn-primary" formaction="/newBook" value="Zatwierdź"
                   style="width: 150px;height: 38px;display: block">
        </form>
    </div>
</div>

</body>
</html>
