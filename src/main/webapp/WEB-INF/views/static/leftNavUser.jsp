<%--
  Created by IntelliJ IDEA.
  User: tomasztrojnar
  Date: 01/06/2022
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <div class="sb-sidenav-menu-heading">Panel użytkownika</div>
                <a class="nav-link" href="index.html">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    Zarezerwuj lekcję
                </a>
            </div>
        </div>
        <div class="sb-sidenav-footer">
            <div class="small">Zalogowany użytkownik:</div>
            Tomasz Trojnar
<%--            tutaj trzeba pobrać nazwę użytkownika--%>
        </div>
    </nav>
</div>
