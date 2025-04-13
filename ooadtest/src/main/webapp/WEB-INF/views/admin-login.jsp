<html>
<head>
    <title>Admin Login</title>
</head>
<body>
    <h2>Admin Login</h2>

    <form action="/admin-login" method="post">
        <label for="password">Enter Admin Password:</label><br/>
        <input type="password" name="password" required /><br/><br/>

        <input type="submit" value="Login as Admin" />
    </form>

    <br/>
    <span style="color:red">${error}</span>  <!-- Admin login error -->
</body>
</html>
