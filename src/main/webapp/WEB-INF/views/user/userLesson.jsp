<%--
  Created by IntelliJ IDEA.
  User: tomasztrojnar
  Date: 07/06/2022
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Edytuj dane</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="../../../css/stylesTable.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<jsp:include page="../../views/static/header.jsp"></jsp:include>
<div id="layoutSidenav">
    <jsp:include page="../../views/static/leftNavUser.jsp"></jsp:include>
    <div id="layoutSidenav_content">

        <h2 style="margin-top: 10px; margin-left: 10px; margin-bottom: 2%">Szczegóły lekcji</h2>
        <p>Data lekcji: ${lesson.date}</p>
        <p>Godzina lekcji: ${lesson.time}</p>
        <form:form method="post" action="/panel/user/lesson/${lesson.id}" modelAttribute="lesson">
            Ocena lekcji: <form:input path="rating" value="${lesson.rating}" type="number" min="1" max="10" step="1"/>
            <form:hidden path="id" value="${lesson.id}"/>
            <form:hidden path="comments" value="${lesson.comments}"/>
            <form:hidden path="date" value="${lesson.date}"/>
            <form:hidden path="status" value="${lesson.status}"/>
            <form:hidden path="time" value="${lesson.time}"/>
            <form:hidden path="user" value="${user.id}"/>
            <input type="submit" value="Oceń"> </br>
        </form:form>
        <p>Komentarz:</p> </br>
        <p>${lesson.comments}</p>

        <jsp:include page="../../views/static/footer.jsp"></jsp:include>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="../../../js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="../../../js/datatables-simple-demo.js"></script>
</body>
</html>
