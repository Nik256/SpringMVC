<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<div>
    <p><h1>HOME</h1></p>
    <p>Hello <b>${username}</b> with authorities <b>${authorities}</b><p>
    <h3><a href="/products">Products</a></h3>
     <h3><a href="/search">Search</a></h3>
    <c:if test="${not empty admin}"><h3><a href="/users">Users</a></h3></c:if>
    <br>
    <a href="/logout">Logout</a>
</div>
</body>
</html>