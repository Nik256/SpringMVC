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
            <th>Password</th>
            <th>Roles</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.roles}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href='/home'>Home</a>
</div>
</body>
</html>