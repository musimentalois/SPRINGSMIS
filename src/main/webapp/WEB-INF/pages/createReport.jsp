<%--
  Created by IntelliJ IDEA.
  User: loic
  Date: 6/15/2023
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Grade</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.grade}</td>
        </tr>
    </c:forEach>
</table>
<hr>
<h2>Add Student</h2>
<form method="post" action="/student">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br><br>
    <label for="grade">Grade:</label>
    <input type="text" id="grade" name="grade"><br><br>
    <input type="submit" value="Add Student">
</form>
</body>
</html>
