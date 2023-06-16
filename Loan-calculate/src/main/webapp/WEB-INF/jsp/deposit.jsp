<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Deposit</title>
</head>
<body>
    <form method="post">
        Fund: <input name="fund" /> &nbsp;
        Interest: <input name="interest" /> &nbsp;
        Year: <input name="depositYear" /> &nbsp;
        Payment: <input name="payment" /> &nbsp;
        <input type="submit" value="Create datas" />
    </form>
    <table>
        <c:forEach items="${deposits}" var="deposit">
                     <tr>
                        <td>Fund: ${deposit.fund}</td>
                        <td>Interest: ${deposit.interest}</td>
                        <td>Years of deposit: ${deposit.depositYear}</td>
                        <td>Payment: ${deposit.payment}</td>
                     </tr>
        </c:forEach>
        <c:forEach items="${depositByYears}" var="depositByYear">
              <tr>
                 <td>Compound interest by year: ${depositByYear}</td>
              </tr>
        </c:forEach>
        <c:forEach items="${annuities}" var="annuity">
                       <tr>
                          <td>Annuity: ${annuity}</td>
                       </tr>
        </c:forEach>
        <c:forEach items="${annuitiesYear}" var="annuityYear">
                       <tr>
                          <td>Annuity year: ${annuityYear}</td>
                       </tr>
        </c:forEach>
     </table>
</body>
</html>