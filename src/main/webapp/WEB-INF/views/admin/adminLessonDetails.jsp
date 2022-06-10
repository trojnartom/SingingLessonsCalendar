<%--
  Created by IntelliJ IDEA.
  User: tomasztrojnar
  Date: 10/06/2022
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Panel admina</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <link href="../../../css/stylesTable.css" rel="stylesheet"/>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<jsp:include page="../../views/static/header.jsp"></jsp:include>
<div id="layoutSidenav">
    <jsp:include page="../../views/static/leftNavAdmin.jsp"></jsp:include>
    <div id="layoutSidenav_content">

        <h2 style="margin-top: 10px; margin-left: 10px">Szczegóły lekcji</h2>
        <div style="margin-left: 5px">
            <a><b>Data lekcji:</b> ${lesson.date}</a> </br>
            <a><b>Godzina lekcji:</b> ${lesson.time}</a> </br>
            <a><b>Uczeń:</b> ${user.firstName} ${user.lastName}</a></br>
            <c:if test="${user.phoneNumber != null}">
                <a><b>Telefon:</b> ${user.phoneNumber}</a></br>
            </c:if>
            <c:if test="${user.phoneNumber == null}">
                <a><b>Telefon:</b> Nie podano</a></br>
            </c:if>

            <c:if test="${lesson.rating >= 1}">
                <a><b>Ocena:</b> ${lesson.rating}</a> </br>
            </c:if>
            <c:if test="${lesson.rating == null}">
                <a><b>Ocena:</b> Brak oceny</a> </br>
            </c:if>

            <a><b>Komentarz do lekcji:</b> </a> </br>
            <a>${lesson.comments}</a>
        </div>

        <jsp:include page="../../views/static/footer.jsp"></jsp:include>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="../../../js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="../../../js/datatables-simple-demo.js"></script>
</body>
</html>
