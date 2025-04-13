<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Make a Reservation</title></head>
<body>
    <h2>Make a Reservation</h2>

    <form action="/reservation/save" method="post">
        <label for="table_number">Table Number:</label>
        <input type="number" name="tableNumber" required /><br/><br/>

        <label>Select Menu Items:</label><br/>
        <c:forEach var="item" items="${menuItems}">
            <input type="checkbox" name="menuIds" value="${item.menu_id}" />
            ${item.name} - ${item.category} <br/>
        </c:forEach>

        <br/>
        <input type="submit" value="Reserve" />
    </form>
</body>
</html>
