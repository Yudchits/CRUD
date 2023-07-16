<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Добавление/Обновление</title>
</head>
<body>
  <br>
  <h3>Добавление/обновление данных студента:</h3><br><br>

  <form:form action="save-update-student" modelAttribute="student">

    <form:hidden path="id"/>

    <label id="name">
      Имя: <form:input path="name" id="name"/>
      <form:errors path="name"/>
    </label><br><br>

    <label id="surname">
      Фамилия: <form:input path="surname" id="surname"/>
      <form:errors path="surname"/>
    </label><br><br>

    <label id="course">
      Курс: <form:input path="course" id="course"/>
      <form:errors path="course"/>
    </label><br><br>

    <label id="faculty">
      Факультет: <form:input path="faculty.name" id="faculty"/>
      <form:errors path="faculty"/>
    </label><br><br>

    <label id="email">
      Почта: <form:input path="email" id="email"/>
      <form:errors path="email"/>
    </label><br><br>

    <input type="submit" value="Ок">
  </form:form>
</body>
</html>
