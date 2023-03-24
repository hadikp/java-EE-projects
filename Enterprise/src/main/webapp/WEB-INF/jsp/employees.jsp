<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee</title>
</head>
<body>
    <form method="post">
        <input name="name" />
        <input type="submit" value="Create employee" />
    </form>
    <table>
        <c:forEach items="${employees}" var="employee">
             <tr>
                <td>${employee.name}</td>
             </tr>
        </c:forEach>
     </table>




</body>
</html>