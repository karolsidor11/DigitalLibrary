<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Użytkownik
  Date: 12.11.2018
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Panel logowania użytkownika</title>
    <link rel="stylesheet" href="resources/css/style.css" type="text/css">
</head>
<body>

<div id="loginForm" align="center">
    <br><br>
    <h2 style="color: darkblue" align="center">Zaloguj się do swojego konta</h2><br>


    <form:form name="login" method="post">

        Wprowadź login : <input type="text" name="login" placeholder="Login"><br><br>
        Wprowadź hasło: <input type="password" name="password" placeholder="Hasło"><br><br>
        <input type="submit" value="Zaloguj " formaction="loginProcess" style="width: 100px; height: 30px;">
        <br>

    </form:form>
</div>

<div align="center" style="color: red; font-weight: bold">
    ${error}
</div>

<footer class="footer">
    <%@include file="templates/footer.jsp" %>
</footer>

</body>
</html>
