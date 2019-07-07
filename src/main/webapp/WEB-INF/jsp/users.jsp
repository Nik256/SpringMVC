<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/ajax.js"></script>
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
    <table id="newTable">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Password</th>
            <th>Roles</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.role}"/></td>
                <td style="color:red" id="ajax">Delete</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href='/home'>Home</a>
</div>
</body>
</html>