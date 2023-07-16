<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <meta charset="utf-8">
</head>
<body>
    <h2>Information about students:</h2><br><br>

    <table border="1">
        <thead>
            <tr>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Курс</th>
                <th>Факультет</th>
                <th>Почта</th>
                <th>Операции</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach>

        </c:forEach>
        </tbody>
    </table>
</body>
</html>
