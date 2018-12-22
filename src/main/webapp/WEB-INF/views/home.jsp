<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link rel="stylesheet" href=" resources/css/style.css" type="text/css">
    <link rel="stylesheet" href=" resources/css/bootstrap.min.css" type="text/css">
</head>

<body style="background-color: lavender">
<h1 style="color: darkblue" align="center">Witamy w Cyfrowej Bibliotece </h1>

<div align="center" style="font-size: medium">
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et<br>
    dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex<br>
    ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat <br>
    nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim <br>
    id est laborum."
</div>
<br>

<section style="text-align: center">

    <a class="link" href="<c:url value="/login" />">
        <button class="btn btn-primary" style="width: 150px">
            Logowanie
        </button>
    </a>

    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

    <a class="link" href="<c:url value="/register" />">
        <button class="btn btn-primary" style="width: 150px">
            Rejestracja
        </button>
    </a>

</section>

<br><br>

<div align="center">
    <img src="../../resources/images/spring.jpg" width="188" height="269"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <img src="../../resources/images/hibernate.jpg" width="188" height="269">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <img src="../../resources/images/git.jpg" width="188" height="269">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <img src="../../resources/images/java.jpg" width="188" height="269">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <img src="../../resources/images/junit.jpg" width="188" height="269">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <img src="../../resources/images/maven.jpg" width="188" height="269">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
</div>
<br><br>


</body>
</html>