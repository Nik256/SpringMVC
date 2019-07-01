<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <form action="/login" method="post">
        <label><b>login</b></label>
        <input type="text" name="login" required>

        <label><b>password</b></label>
        <input type="password" name="password" required>
        <button type="submit">login</button>
    </form>
</div>
</body>
</html>