<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cities</title>
</head>
<body>
<h2>Cities List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
    <c:forEach var="city" items="${cities}">
            <tr><td>${city.name}</td>
            <td>${city.stateId}</td>
            <td>
            <td>
                <a href='<c:url value="/edit?id=${city.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${city.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
    </c:forEach>
</table>
</body>
</html>
