<%--
  Created by IntelliJ IDEA.
  User: tomasztrojnar
  Date: 27/05/2022
  Time: 23:11
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
<jsp:include page="../static/header.jsp"></jsp:include>
<div id="layoutSidenav">
    <jsp:include page="../../views/static/leftNavUser.jsp"></jsp:include>
    <div id="layoutSidenav_content" >
        <div style="margin-left: 20px; margin-top: 20px; margin-right: 40%; font-size: x-large">
            <h2 style="margin-top: 10px; margin-left: 10px; margin-bottom: 2%">Edytuj swoje dane</h2>
            <form:form method="post" action="/panel/user/edit" modelAttribute="user">
                Imię: <form:input path="firstName" value="${user.firstName}"/>
                <form:errors path="firstName"/>  </br>
                Nazwisko: <form:input path="lastName" value="${user.lastName}"/>
                <form:errors path="lastName"/>  </br>
                Numer telefonu: <form:input path="phoneNumber" value="${user.phoneNumber}"/>
                <form:errors path="phoneNumber"/>  </br>
                Password: <form:password path="password" value="${user.password}"/>
                <form:errors path="password"/>  </br>
                <form:hidden path="id" value="${user.id}"/>
                <form:hidden path="email" value="${user.email}"/>
                <form:hidden path="role" value="${user.role}"/>
                <input type="submit" value="Zapisz"/>
            </form:form>
            <div id="passwordHelpBlock" class="form-text">
            Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
            </div>
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