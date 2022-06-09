<%--
  Created by IntelliJ IDEA.
  User: tomasztrojnar
  Date: 08/06/2022
  Time: 20:44
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

        <h2 style="margin-top: 10px; margin-left: 10px">Anulowanie lekcji</h2>
        <div style="margin-left: 5px">
        <a>Data lekcji: ${lesson.date}</a> </br>
        <a>Godzina lekcji: ${lesson.time}</a> </br>
        <a>Czy na pewno chcesz anulować?</a> </br>
        <form:form method="post" action="/panel/user/cancel/${user.id}/${lesson.id}" modelAttribute="lesson">
            <form:hidden path="id"/>
            <form:hidden path="date"/>
            <form:hidden path="time"/>
            <form:hidden path="status"/>
            <input type="submit" value="TAK">
            <button href="/panel/user/list/${user.id}">NIE</button>
        </form:form>


        </div>
        <jsp:include page="../../views/static/footer.jsp"></jsp:include>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="../../../js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="../../../js/datatables-simple-demo.js"></script>
</body>
</html>
