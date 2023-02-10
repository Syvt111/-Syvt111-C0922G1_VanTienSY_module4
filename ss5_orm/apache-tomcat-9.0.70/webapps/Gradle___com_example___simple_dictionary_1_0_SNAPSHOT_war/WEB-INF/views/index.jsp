<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>simple_dictionary</title>
</head>
<body>
<h1><%= "Simple Dictionary" %>
</h1>

<form action="/translate" method="post">
    <input type="text" placeholder="Enter a word " name="word">
    <button type="submit">Translate</button>
    <p>Result: ${result}</p>
</form>

</body>
</html>