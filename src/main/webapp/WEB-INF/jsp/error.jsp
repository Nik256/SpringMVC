<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Произошла ошибка</title>
</head>
<body>
<div>
    <p>Произошла ошибка:</p>
    <p style="color:red">${error}</p>
    <a href="/home">На главную</a>
</div>
</body>
</html>