<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Login</title></head>
<body>
    <h2>User Login</h2>
    <form action="/home" method="post">
        Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>

    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>

    <br>
    <a href="/user/add">Don't have an account? Register here</a>
</body>
</html>
