
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<fieldset>
    <legend>Calculator</legend>
    <form action="/calculator" method="post">
        <input type="number"  name="number1">
        <input type="number"  name="number2">
        <br>
        <br><hr>
        <input type="submit" name="calculator" value="+" >
        <input type="submit" name="calculator" value="-" >
        <input type="submit" name="calculator" value="*" >
        <input type="submit" name="calculator" value="/" >
    </form>
    <p>Result: ${result}</p>
</fieldset>
</body>
</html>