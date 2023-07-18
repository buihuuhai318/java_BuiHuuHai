<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>

    <form action="/display-discount" method="post">
        <label>description: </label><br>
        <input type="text" name="description"><br><br>
        <label>price: </label><br>
        <input type="text" name="price"><br><br>
        <label>discount</label><br>
        <input type="text" name="discount"><br><br>
        <input type="submit" id="submit">
    </form>

</body>
</html>