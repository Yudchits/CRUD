<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная</title>
    <meta charset="utf-8">
</head>
<body>
    <h2>Information about students:</h2><br><br>

    <table border="1" id="students_table">
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
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.name}</td>
                <td>${student.surname}</td>
                <td>${student.course}</td>
                <td>${student.faculty.name}</td>
                <td>${student.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <input type="button" value="Добавить" onclick="window.location.href='add-student'">

    <br><br><br>

    <h2>Information about faculties:</h2><br><br>
    <table border="1" id="faculties_table">
        <thead>
            <tr>
                <th>Название</th>
                <th>Кол-во студентов</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="faculty" items="${faculties}">
                <tr>
                    <td>${faculty.name}</td>
                    <td>${faculty.numberOfStudents}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <input type="button" value="Добавить" onclick="window.location.href='add-faculty'">
</body>
</html>
