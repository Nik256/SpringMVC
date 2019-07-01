<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.description}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href='/home'>Home</a>
</div>
</body>
</html>