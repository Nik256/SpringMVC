<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<div>
    <p><h1>HOME</h1></p>
    <p>Hello <sec:authorize access="isAuthenticated()">
    <b><sec:authentication property="name"/></b> with authorities
    <b><sec:authentication property="authorities"/></b></sec:authorize><p>
    <h3><a href="/products">Products</a></h3>
     <h3><a href="/search">Search</a></h3>
    <sec:authorize access="hasAuthority('ADMIN')"><h3><a href="/users">Users</a></h3></sec:authorize>
    <br>
    <a href="/logout">Logout</a>
</div>
</body>
</html>