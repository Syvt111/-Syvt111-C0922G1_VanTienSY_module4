<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<fieldset style="width: 400px">
    <legend>Calculator</legend>
    <form method="post" action="/calculator">
       <table>
           <tr>
               <td>First operand</td>
               <td><input type="text"  name="firstOperand"></td>
           </tr>
           <tr>
               <td>Operator:</td>
               <td>
                  <select name="operator">
                      <option value="+">Addition</option>
                      <option value="-">Subtraction</option>
                      <option value="*">Multiplication</option>
                      <option value="/">Division</option>
                  </select>
               </td>
           </tr>
           <tr>
               <td>Second operand</td>
               <td><input type="text"  name="secondOperand"></td>
           </tr>
           <tr>
               <td></td>
               <td><button type="submit" value="calculator">calculate</button></td>
           </tr>
       </table>
    </form>
</fieldset>

</body>
</html>