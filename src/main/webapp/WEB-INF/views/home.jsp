<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Restaurant Menu</title>
    <script>
        function showPopup(message) {
            alert(message);
        }
    </script>
</head>
<body>
    <h2>Welcome to the Restaurant</h2>

    <table border="1">
        <tr>
            <th>Name</th><th>Category</th><th>Price</th><th>Description</th><th>Action</th>
        </tr>
        <c:forEach var="item" items="${menuItems}">
            <tr>
                <td>${item.name}</td>
                <td>${item.category}</td>
                <td>${item.price}</td>
                <td>${item.description}</td>
                <td>
                    <form action="/cart/add/${item.menu_id}" method="post" onsubmit="showPopup('Added to cart')">
                        <input type="submit" value="Add to Cart" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/><br/>

    <!-- Replaced Place Order with View Cart -->
    <form action="/cart/view" method="get">
        <input type="submit" value="View Cart" />
    </form>

    <br/>
    <a href="/reservation">Make a Reservation</a><br/>
    <a href="/feedback">Give Feedback</a>
</body>
</html>
