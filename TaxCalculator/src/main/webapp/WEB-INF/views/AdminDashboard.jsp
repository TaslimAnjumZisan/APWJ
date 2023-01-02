<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>Welcome Admin</h1>
    <p>Select operations  </p>
</div>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="/tax_calculator_system_war_exploded/">HomePage</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="addUser">Add User</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="amount">Tax Amounts</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="dashboard">Dashboard</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="tax_calculator_system_war_exploded/logout">Log Out</a>
            </li>
        </ul>
    </div>
</nav>
</div>
<h2>Update or Delete Calculation</h2>
<form method="post" action="updateDeleteCalculation">
    Enter id to Edit : <input type="text" name="calidForUpDel" id="calidForUpDel" placeholder="Enter ID">
    <input type="submit" name="edit" value="Edit">
</form>
<h2>All User Data</h2>
<table border="1">
    <thead>
    <tr>
        <th>Calculation Id</th>
        <th>User's ID</th>
        <th>Date</th>
        <th>Basic Salary</th>
        <th>House rent</th>
        <th>Medical Allowance</th>
        <th>Conveyance</th>
        <th>Festival bonus</th>
        <th>Taxable Income</th>
        <th>Tax Liability</th>
        <th>Rebate</th>
        <th>Net Tax</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allUser}" var="au">
        <tr>
            <td>${au.id}</td>
            <td>${au.user_id}</td>
            <td>${au.date}</td>
            <td>${au.basicSalary}</td>
            <td>${au.houseRent}</td>
            <td>${au.medicalAllowance}</td>
            <td>${au.conveyance}</td>
            <td>${au.festivalBonus}</td>
            <td>${au.taxAbleIncome}</td>
            <td>${au.taxLiability}</td>
            <td>${au.rebate}</td>
            <td>${au.netTax}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
