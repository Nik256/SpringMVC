<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <style>
    table {
      border-collapse: collapse;
    }

    table, td, th {
      border: 1px solid black;
    }
    </style>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><a href='/product/${product.id}'>Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

     <c:url value="/products" var="prev">
        <c:param name="page" value="${page - 1}"/>
     </c:url>
     <c:if test="${page > 0}">
            <a href="<c:out value="${prev}" />">Prev</a>
     </c:if>

     <c:url value="/products" var="next">
        <c:param name="page" value="${page + 1}"/>
     </c:url>
     <c:if test="${page + 1 < maxPages}">
             <a href='<c:out value="${next}" />'>Next</a>
     </c:if>
    <h3><a href='/product'>Create product</a></h3>
    <a href='/home'>Home</a>
</div>
</body>
</html>