<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h2>All Users</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Role</th><th>Actions</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>
                    <a href="/user/edit/${user.id}">Edit</a> |
                    <a href="/user/delete/${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="/user/add">Add New User</a>
</body>
</html>
