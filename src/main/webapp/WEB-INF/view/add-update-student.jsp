<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Add/Update</title>
    <style type="text/css">
      .details {
        padding-left: 40%;
        padding-top: 10%;
        font-size: 150%;
      }

      .button1 {
        width: 50px;
        height: 30px;
      }
    </style>
</head>
<body>

<div class="details">
    <h2>Student details:</h2><br>

    <form:form action="save-update-student" modelAttribute="student">

        <form:hidden path="id"/>

        <label id="name">
            Name: <form:input path="name" id="name"/>
            <form:errors path="name"/>
        </label><br><br>

        <label id="surname">
            Surname: <form:input path="surname" id="surname"/>
            <form:errors path="surname"/>
        </label><br><br>

        <label id="course">
            Course: <form:input path="course" id="course"/>
            <form:errors path="course"/>
        </label><br><br>

        <label id="faculty">
            Faculty: <form:input path="faculty.name" id="faculty"/>
            <form:errors path="faculty"/>
        </label><br><br>

        <label id="email">
            Email: <form:input path="email" id="email"/>
            <form:errors path="email"/>
        </label><br><br>

        <input type="submit" value="Save" class="button1">
    </form:form>
</div>
</body>
</html>
