<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee</title>
</head>
<body>
    <table>
        <c:forEach var="i" begin="1" end="5">
        Item <c:out value="${i}"/>
        </c:forEach>
        <tr>
            <td>${message}</td>
        </tr>
    </table>



</body>
</html>