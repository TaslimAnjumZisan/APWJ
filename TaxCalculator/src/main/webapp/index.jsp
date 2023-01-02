<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>TaxCalculator</title>
    <meta charset="utf-8">

</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>CALCULATE YOUR TAX EASILY</h1>
    <p>Create Profile To Save Your Entries</p>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="/spring_webmvc_war_exploded/">HomePage</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="signup">SignUp</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="user/dashboard">User Dashboard</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="admin/dashboard">Admin Dashboard</a>
            </li>
        </ul>
    </div>
</nav>
</div>

</body>
</html>
