<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
    <meta charset="utf-8">

    <style type="text/css">

        p {
            font-size: 300%;
            padding-top: 5%;
            text-align: center;
        }

        table {
            border-radius: 10px;
            background: #add8e6;
            border: 1px solid #000;
        }

        th, td {
            border: 0;
            text-align: center;
        }

        input {
            width: 70px;
            height: 30px;
        }

        .students {
            position: absolute;
            left: 15%;
            top: 30%;
        }

        .students table {
            width: 530px;
        }

        .faculties {
            position: absolute;
            left: 55%;
            top: 30%;
        }

        .faculties table {
            width: 390px;
        }

    </style>
</head>
<body>

<p>The greatest crud service</p>

<div class="students">
    <h2>Students:</h2>

    <table id="students_table">
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
</div>

<div class="faculties">

    <h2>Faculties:</h2>

    <table id="faculties_table">
        <thead>
        <tr>
            <th>Name</th>
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
</div>
</body>
</html>
