<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
    <h2>Edit User</h2>
    <form action="/user/update" method="post">
        <input type="hidden" name="id" value="${user.id}">
        Name: <input type="text" name="name" value="${user.name}" required><br>
        Email: <input type="email" name="email" value="${user.email}" required><br>
        Password: <input type="password" name="password" value="${user.password}" required><br>
        <input type="submit" value="Update">
    </form>
    <a href="/user">Back to Users</a>
</body>
</html>
