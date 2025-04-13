<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Add Menu Item</title></head>
<body>
    <h2>Add New Menu Item</h2>

    <form action="/admin/menu/save" method="post">
        <label for="name">Name:</label><br/>
        <input type="text" id="name" name="name" required/><br/><br/>

        <label for="category">Category:</label><br/>
        <input type="text" id="category" name="category" required/><br/><br/>

        <label for="price">Price:</label><br/>
        <input type="number" id="price" name="price" step="0.01" required/><br/><br/>

        <label for="description">Description:</label><br/>
        <textarea id="description" name="description" required></textarea><br/><br/>

        <input type="submit" value="Save Menu Item" />
    </form>

    <br/>
    <a href="/admin">Back to Admin Home</a>
</body>
</html>
