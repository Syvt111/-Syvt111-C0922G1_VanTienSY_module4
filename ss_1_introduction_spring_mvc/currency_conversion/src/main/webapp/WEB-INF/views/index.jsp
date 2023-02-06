<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Conversion</title>
</head>
<body>
<h1><%= "Currency Conversion" %>
</h1>
<form action="/convert" method="post">
    <input type="number" name="value" placeholder="Enter value (USD)">
    <p>1 USD = 23000 VND </p>
    <p>${result}</p>
    <button type="submit">Convert</button>
</form>

</body>
</html>