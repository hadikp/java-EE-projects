<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee</title>
</head>
<body>
    <form method="post">
        Full name: <input name="name" />
        Country: <input name="country" />
        Salary: <input name="salary" />
        <input type="submit" value="Create employee" />
    </form>
    <table>
        <c:forEach items="${employees}" var="employee">
             <tr>
                <td>Fullname: ${employee.name}</td>
                <td>Country: ${employee.country}</td>
                <td>Salary: ${employee.salary}</td>
             </tr>
        </c:forEach>
     </table>
</body>
</html>