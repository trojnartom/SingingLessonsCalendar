<%--
  Created by IntelliJ IDEA.
  User: tomasztrojnar
  Date: 05/06/2022
  Time: 15:22
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
    <title>Lista wszystkich lekcji</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <link href="../../../css/stylesTable.css" rel="stylesheet"/>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
<jsp:include page="../static/header.jsp"></jsp:include>
<div id="layoutSidenav">
    <jsp:include page="../../views/static/leftNavAdmin.jsp"></jsp:include>
    <div id="layoutSidenav_content">
        <h2 style="margin-top: 10px; margin-left: 10px">Lista wszystkich lekcji</h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Data</th>
                <th scope="col">Godzina</th>
                <th scope="col">Uczeń</th>
                <th scope="col">Status</th>
                <th scope="col">Ocena</th>
                <th scope="col">Akcje</th>
            </tr>
            </thead>
            <c:forEach var="lesson" items="${lessons}">
                <tbody>
                <tr>
                    <td>${lesson.date}</td>
                    <td>${lesson.time}</td>
                    <td>${lesson.user.firstName} ${lesson.user.lastName}</td>
                    <td>${lesson.status}</td>
                    <td>${lesson.rating}</td>
                        <c:if test="${lesson.status.equals('Oczekuje na komentarz')}">
                    <td><a href="/panel/admin/comment"/>Skomentuj</td>
                    </c:if>
                    <c:if test="${lesson.status.equals('Zakończona')}">
                    <td><a href="/panel/admin/lesson"/>Szczegóły</td>
                    </c:if>
                    </td>
                </tbody>
            </c:forEach>
        </table>

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
