<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@page language="java" pageEncoding="UTF-8" %>


<html>
<head>
    <title>Cyfrowa Bibliteka-Strona glówna</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">


</head>
<body>
<h1 style="color: darkblue" align="center">Witamy w Cyfrowej Bibliotece </h1>

<div align="center" style="font-size: medium">
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et<br>
    dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex<br>
    ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat <br>
    nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim <br>
    id est laborum."
</div>
<br><br>

<section style="text-align: center">

    <a class="link" href="<c:url value="/login" />">
        <button style="width: 100px;height: 30px;">Logowanie</button>
    </a>

    &nbsp&nbsp&nbsp&nbsp&nbsp

    <a class="link" href="<c:url value="/register" />">
        <button style="width: 100px;height: 30px;">Rejestracja</button>
    </a>

</section>

<br>

<div align="center">
    <img src="../../resources/images/spring.jpg" width="188" height="269"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <img src="../../resources/images/hibernate.jpg" width="188" height="269">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <img src="../../resources/images/git.jpg" width="188" height="269">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <img src="../../resources/images/java.jpg" width="188" height="269">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <img src="../../resources/images/junit.jpg" width="188" height="269">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <img src="../../resources/images/maven.jpg" width="188" height="269">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
</div>
<br><br>


<div class="footer">
    <%@include file="templates/footer.jsp" %>
</div>

</body>
</html>