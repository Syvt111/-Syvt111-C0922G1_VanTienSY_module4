<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
    <link rel="stylesheet" type="text/css" href="">
</head>

<body>
<h2>Product Discount Calculator</h2>
<form method="post" action="/calculate-discount">
    <div class="input" >
    <label>Product Description</label><br/>
    <input type="text" name="Product_Description" placeholder="Product Description"/><br/>
    <label>List Price</label><br/>
    <input type="text" name="List_Price" placeholder="List Price"/><br/>
    <label>Discount Percent</label><br/>
    <input type="text" name="Discount_Percent" placeholder="Discount Percent"/><br/>
    </div>
    <button class="button" type="submit" id="submit" value="Calculate Discount">Calculate Discount</button>

</form>
</body>
</html>