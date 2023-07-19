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
                <th>Name</th>
                <th>Surname</th>
                <th>Course</th>
                <th>Faculty</th>
                <th>Email</th>
                <th>Operations</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${students}">

            <c:url var="update_student_button" value="/update-student-details">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <c:url var="delete_student_button" value="/delete-student">
                <c:param name="id" value="${student.id}"/>
            </c:url>

            <tr>
                <td>${student.name}</td>
                <td>${student.surname}</td>
                <td>${student.course}</td>
                <td>${student.faculty.name}</td>
                <td>${student.email}</td>
                <td>
                    <input type="button" value="Update" onclick="window.location.href='${update_student_button}'">
                    <input type="button" value="Delete" onclick="window.location.href='${delete_student_button}'">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <input type="button" value="Add" onclick="window.location.href='add-student'">

    <br><br><br>

    <h2>Information about faculties:</h2><br><br>
    <table border="1" id="faculties_table">
        <thead>
            <tr>
                <th>Title</th>
                <th>Number of students</th>
                <th>Operations</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="faculty" items="${faculties}">


                <c:url var="update_faculty_button" value="/update-faculty-details">
                    <c:param name="id" value="${faculty.id}"/>
                </c:url>

                <c:url var="delete_faculty_button" value="/delete-faculty">
                    <c:param name="id" value="${faculty.id}"/>
                </c:url>

                <tr>
                    <td>${faculty.name}</td>
                    <td>${faculty.numberOfStudents}</td>
                    <td>
                        <input type="button" value="Update" onclick="window.location.href='${update_faculty_button}'">
                        <input type="button" value="Delete" onclick="window.location.href='${delete_faculty_button}'">
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <input type="button" value="Add" onclick="window.location.href='add-faculty'">
</body>
</html>
