<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>tax-calculator</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="w3-container w3-center">
    <h3>TAX CALCULATOR</h3>
    <form:form method="post" action="updateCalculation" modelAttribute="updateCalculationData">
        User ID : <input type="text" name="user_id" id="user_id" value="${updateCalculationData.user_id}">
        <br><br>
        Basic Salary : <input type="text" name="basicSalary" id="basicSalary" value="${updateCalculationData.basicSalary}">
        <br><br>
        House Rent : <input type="text" name="houseRent" id="houseRent" value="${updateCalculationData.houseRent}">
        <br><br>
        Medical Allowance : <input type="text" name="medicalAllowance" id="medicalAllowance" value="${updateCalculationData.medicalAllowance}">
        <br><br>
        Conveyance : <input type="text" name="conveyance" id="conveyance" value="${updateCalculationData.conveyance}">
        <br><br>
        Festival Bonus : <input type="text" name="festivalBonus" id="festivalBonus" value="${updateCalculationData.festivalBonus}">
        <br><br>
        Taxable income: <input type="text" name="taxAbleIncome" id="taxAbleIncome" value="${updateCalculationData.taxAbleIncome}">
        <br><br>
        Tax liability : <input type="text" name="taxLiability" id="taxLiability" value="${updateCalculationData.taxLiability}">
        <br><br>
        Rebate : <input type="text" name="rebate" id="rebate" value="${updateCalculationData.rebate}">
        <br><br>
        Net tax : <input type="text" name="netTax" id="netTax" value="${updateCalculationData.netTax}">
        <br><br>
        <input type="submit" value="Update">
        <a href="deleteCalculation"><button>Delete</button></a>
    </form:form>
    <a href="dashboard"><input type="button" value="Dashboard"></a>
</div>

</body>
</html>