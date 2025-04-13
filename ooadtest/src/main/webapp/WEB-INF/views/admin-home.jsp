<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Admin Home - Manage Menu</title></head>
<body>
    <h2>Welcome to the Admin Home Page</h2>
    <h3>Manage Menu Items</h3>

    <table border="1">
        <tr>
            <th>Name</th><th>Category</th><th>Price</th><th>Description</th><th>Actions</th>
        </tr>
        <c:forEach var="item" items="${menuItems}">
            <tr>
                <td>${item.name}</td>
                <td>${item.category}</td>
                <td>${item.price}</td>
                <td>${item.description}</td>
                <td>
                    <!-- Edit and Delete Menu Items -->
                    <a href="/admin/menu/edit/${item.menu_id}">Edit</a> | 
                    <a href="/admin/menu/delete/${item.menu_id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <!-- Button to Add New Menu Item -->
    <a href="/admin/menu/add"><button>Add New Menu Item</button></a>

    <br/><br/>
    <a href="/admin/logout">Logout</a>  <!-- Link to logout -->
</body>
</html>
