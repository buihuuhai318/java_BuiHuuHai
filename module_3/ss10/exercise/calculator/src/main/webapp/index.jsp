<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form action="/result" method="post">
    <label for="">First Operand: <input type="text" name="firstOperand"></label><br>
    <label for="">Operator: <select name="operator">
        <option value="+">cong</option>
        <option value="-">tru</option>
        <option value="*">nhan</option>
        <option value="/">chia</option>
    </select></label><br>
    <label for="">Second Operand <input type="text" name="secondOperand"></label><br>
    <input type="submit" value="Calculator">
</form>

</body>
</html>