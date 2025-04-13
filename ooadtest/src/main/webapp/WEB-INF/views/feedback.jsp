<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Give Feedback</title></head>
<body>
    <h2>Give Feedback on Menu Items</h2>

    <form action="/feedback/save" method="post">
        <label>Select Menu Item:</label><br/>
        <select name="menuId">
            <c:forEach var="item" items="${menuItems}">
                <option value="${item.menu_id}">${item.name}</option>
            </c:forEach>
        </select><br/><br/>

        <label>Your Feedback:</label><br/>
        <textarea name="feedbackText" rows="4" cols="40" required></textarea><br/><br/>

        <input type="submit" value="Submit Feedback" />
    </form>
</body>
</html>
