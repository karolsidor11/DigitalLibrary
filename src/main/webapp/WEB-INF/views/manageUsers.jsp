<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 26.12.2018
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzanie użytkownikami</title>
    <style>
        .btn-primary {
            color: #fff;
            background-color: #007bff;
            border-color: #007bff;
            width: 100px;
            height: 25px;
        }

        h2 {
            color: darkblue;
        }
    </style>
</head>
<body bgcolor="#e6e6fa">

<%--NAGÓŁÓEWK--%>
<div>
    <a href="<c:url value="/userPage" />">
        <button class="btn-primary" style="background-color: green; border-radius: 5px">Wstecz</button>

    </a>
    <h1 style="text-align: center;color: darkblue">
        Zarządzanie użytkownikami
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

    <%--DODAJ/ MODYFIKUJ UŻYTKOWNIKA --%>
    <div align="center"
         style=" float:left;width: 25%;height: 85%; border-right-style: outset;border-color: blueviolet; border-width: 2px">
        <h2 align="center">Dodaj / Modyfikuj użytkownika </h2>

        <form method="post">

            <h4 style="text-align: center">Dane osobowe </h4>

            <div align="center">
                Wprowadź imię: &nbsp&nbsp <input type="text" name="name" placeholder="Imię"><br><br>
                Wprowadź email : <input type="text" name="email" placeholder="Email"><br>
            </div>
            <br>
            <h4 style="text-align: center"> Dane konta </h4>

            <div align="center">
                Wprowadź login : <input type="text" name="login" placeholder="Login "><br><br>
                Wprowadź hasło : <input type="password" name="password" placeholder="Hasło"><br><br>
                Potwierdź hasło : &nbsp <input type="password" placeholder="Powtórz hasło"><br>
                <br>
                <div id="lower">
                    <input class="btn-primary" type="submit" formaction="<c:url value="/addUser"/> " value="Dodaj">&nbsp&nbsp&nbsp
                    <input class="btn-primary" type="submit" formaction="<c:url value="modifyUser"/> "
                           value="Modyfikuj">
                </div>

            </div>
        </form>

    </div>


    <%--GŁOWNE OKO --%>
    <div align="center" style="float: left;width: 48%">
        <h2 align="center">Lista użytkowników</h2>

        <table border="1px">
            <tr>
                <td>Id</td>
                <td>Imie</td>
                <td>Email</td>
                <td>Login</td>
                <td>Hasło</td>
            </tr>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.login}</td>
                    <td>${user.password}</td>
                </tr>

            </c:forEach>

            </tr>

        </table>

    </div>

    <%--ZARZADZENIE  PROFILEM --%>
    <div align="center"
         style=" float:left;width: 25%;height: 85%; border-left-style: outset;border-color: blueviolet; border-width: 2px">
        <h2>Usuń / zablokuj użytkownika</h2>


        <form method="post" action="/deleteUser">

            <h4 style="text-align: center">Wprowadź id użytkownika </h4>

            <input type="text" name="id" align="center" placeholder="Wprowadź ID"><br><br>
            <input class="btn-primary" type="submit" value="Zatwierdź">

        </form>
        <br><br><br><br>
        <div>
            <h4>Komunikaty:</h4>
            <p style="color: red">${info} </p>
        </div>

    </div>

</section>

</body>
</html>
