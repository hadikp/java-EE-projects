<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Deposit</title>
</head>
<body>
    <form method="post">
        Fund: <input name="fund" />
        Interest: <input name="interest" />
        Year: <input name="depositYear" />
        Payment: <input name="payment" />
        <input type="submit" value="Create datas" />
    </form>
    <table>
        <c:forEach items="${deposits}" var="deposit">
             <tr>
                <td>Fund: ${deposit.fund}</td>
                <td>Interest: ${deposit.interest}</td>
                <td>Year: ${deposit.depositYear}</td>
             </tr>
        </c:forEach>
     </table>
</body>
</html>