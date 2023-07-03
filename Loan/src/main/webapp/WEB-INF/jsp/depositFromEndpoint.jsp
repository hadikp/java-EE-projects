<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Deposit</title>
</head>
<body>
    <table>
        <c:forEach items="${deposits}" var="deposit">
                     <tr>
                        <td>Fund: ${deposit.fund}</td>
                        <td>Interest: ${deposit.interest}</td>
                        <td>Years of deposit: ${deposit.depositYear}</td>
                        <td>Payment: ${deposit.payment}</td>
                     </tr>
        </c:forEach>
     </table>
</body>
</html>