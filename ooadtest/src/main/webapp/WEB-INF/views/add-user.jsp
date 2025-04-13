<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <h2>Add New User</h2>
    <form action="save" method="post">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Save">
    </form>
    <a href="/user">Back to Users</a>
</body>
</html>
