<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>User Login</h2>

    <form action="/login" method="post">
        <label for="email">Email:</label><br/>
        <input type="email" id="email" name="email" required/><br/><br/>

        <label for="password">Password:</label><br/>
        <input type="password" id="password" name="password" required/><br/><br/>

        <input type="submit" value="Login" />
    </form>

    <br/>
    <span style="color:red">${error}</span>  <!-- Login error -->

    <hr/>
    <p>Don't have an account? <a href="/user/add">Register</a></p>
    <p><a href="/admin-login">Login as Admin</a></p>
</body>
</html>
