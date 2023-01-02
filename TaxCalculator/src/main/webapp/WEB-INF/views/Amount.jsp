<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>UpdateVar</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div class="container">
    <h2>Tax variables</h2>
    <h4>Update tax variables</h4>
    <form:form action="updateAmount" modelAttribute="taxAmountUpdate">
        Govt. House Rent: <input type="number" step="any" name="houseRent" value=${taxAmountUpdate.houseRent}> <br>
        Medical Allowance: <input type="number" step="any" name="medicalAllowance" value=${taxAmountUpdate.medicalAllowance}> <br>
        Conveyance: <input type="number" step="any" name="conveyance" value=${taxAmountUpdate.conveyance}> <br>
        Festive Bonus: <input type="number" step="any" name="festiveBonus" value=${taxAmountUpdate.festiveBonus}> <br>
        Max not taxable amount for male: <input type="number" step="any" name="malePayable" value=${taxAmountUpdate.malePayable}> <br>
        Max not taxable amount for female/seniors: <input type="number" step="any" name="femalePayable" value=${taxAmountUpdate.femalePayable}> <br>
        <button type="submit" class="btn btn-primary">Update</button>
    </form:form>
</div>
<a href="dashboard"><input type="button" value="Dashboard"></a>
</body>
</html>
