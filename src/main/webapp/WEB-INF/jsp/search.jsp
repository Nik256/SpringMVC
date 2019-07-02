<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search</title>
</head>
<body>
<div>
    <h3>Product search by name</h3>
    <form action="/search" method="post">
            <input type="text" name="name" required>
            <button type="submit">Search</button>
    </form>
    <a href='/home'>Home</a>
</div>
</body>
</html>