<%--
  Created by IntelliJ IDEA.
  User: Zishan
  Date: 10/18/2022
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form method="post" action="calculate">
    <label for="firstnumber">First number:</label>
    <input type="text" name="firstnumber" id="firstnumber"/>

    <br><br>

    <label for="operator">Operator:</label>
    <input type="text" name="operator" id="operator"/>

    <br><br>

    <label for="lastnumber">Last number:</label>
    <input type="text" name="lastnumber" id="lastnumber"/>

    <br><br>

    <input type="submit" value="Calculate">
</form>
<h1>Welcome, ${firstnum} ${operator} ${lastnum}= ${sum}
</h1>

</body>
</html>

