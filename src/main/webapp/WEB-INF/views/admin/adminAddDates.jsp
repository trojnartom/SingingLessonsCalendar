<%--
  Created by IntelliJ IDEA.
  User: tomasztrojnar
  Date: 06/06/2022
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Dodaj terminy</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <link href="../../../css/stylesTable.css" rel="stylesheet"/>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<jsp:include page="../../views/static/header.jsp"></jsp:include>
<div id="layoutSidenav">
    <jsp:include page="../../views/static/leftNavAdmin.jsp"></jsp:include>
    <div id="layoutSidenav_content">

        <h2 style="margin-top: 10px; margin-left: 10px; margin-bottom: 10px">Dodawanie nowych terminów</h2>
        <div style="margin-left: 10px">
            <form:form modelAttribute="lesson" method="post">
                <ftm:formatDate value="${lesson.date}" var="myDate" pattern="yyyy-MM-dd"/>
                <form:input path="date" type="date" value="${myDate}" required="true"/>
                <form:input type="time" path="time" value="${lesson.time}" required="true"/> </br>
                <form:hidden path="status" value="Utworzona"/>
                <input type="submit" value="Utwórz termin">
            </form:form>
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
