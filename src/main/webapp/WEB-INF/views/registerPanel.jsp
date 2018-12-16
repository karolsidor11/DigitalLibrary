<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 12.11.2018
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Witaj ${user.name}</title>
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>
<h1 align="center" style="color: darkblue"> Dziękujemy za rejestrację na naszym portalu</h1><br>

<h2 align="center" style="color: black"> Potwierdź swoje dane </h2>

<form:form>
    <div align="center">

        Imię: ${user.name}<br><br>
        Nazwisko : ${user.lastName}<br><br>
        Miejscowość : ${user.adres}<br><br>
        Email : ${user.email}<br><br>

        Dane logowania:<br><br>

        Login : ${user.login}<br><br>
        Hasło : ${user.password}<br><br>

        <input type="submit" value="Potwierdzam" formaction="confirm"> &nbsp&nbsp&nbsp
        <input type="submit" value="Wprowadź zmiany" formaction="register">
    </div>

</form:form>


<footer class="footer">
    <%@include file="templates/footer.jsp" %>
</footer>
</body>
</html>
