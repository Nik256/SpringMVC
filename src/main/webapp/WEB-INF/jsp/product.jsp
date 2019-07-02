<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product</title>
</head>
<body>
<div>
    <h3>Product</h3>
    <c:if test="${empty product}">
    <form action="/create-product" method="post"></c:if>
    <c:if test="${not empty product}">
        <form action="/edit-product" method="post"></c:if>
        <c:if test="${not empty product}"><input type="hidden" value="${product.id}" name="id" value="hiddenValue"></c:if>
            <div>
                <label for="name">Name: </label>
                <input type="text" value="${product.name}" name="name" required>
            </div>
            <div>
                <label for="description">Description: </label>
                <input type="text" value="${product.description}" name="description" required>
            </div>
            <button type="submit">Save</button>
    </form>
    <c:if test="${not empty product}"><h3><a href="/delete-product/${product.id}">Delete</a></h3></c:if>
    <h3><a href='/products'>Cancel</a></h3>
    <a href='/home'>Home</a>
</div>
</body>
</html>