<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add/Update</title>
</head>
<body>
    <h2>Faculty details:</h2>
    <br><br><br>

    <form:form action="save-update-faculty" modelAttribute="faculty">
        <label id="name">
            Name: <form:input path="name" id="name"/>
            <form:errors path="name"/>
        </label>
        <br><br>

        <label id="number_of_students">
            Number of students: <form:input path="numberOfStudents" id="number_of_students"/>
            <form:errors path="numberOfStudents"/>
        </label>
        <br><br>

        <input type="submit" value="Ok">
    </form:form>
</body>
</html>
