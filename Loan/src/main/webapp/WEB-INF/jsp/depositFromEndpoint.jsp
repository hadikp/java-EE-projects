<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <title>Deposit</title>
    <link rel="stylesheet" href="C:/H/ujratervez2021/SEJavaRaepulo/java-EE-projects/Loan/src/main/webapp/WEB-INF/css/style.css"></link>
    <style>
        body {

           }
        .container {
           display: flex;
           flex-direction: column;
           background-color: aquamarine;
             }
        table {
                margin: 10px;
                padding: 10px;
                background-color: #eee;
                border: 1px solid #000;
                border-radius: 5px;
         }
         input {
                font-size: 1.5rem;
                font-family: Mulish;
                color: chocolate;
                margin: 10px;
                padding: 10px;
         }
          </style>
</head>
<body>
    <h2>Data from loan-calc Endpoint</h2>
    <div class="container">
        <table><display=flex>
            <tr><td>Fund: ${deposit.fund}</td></tr></tr>
            <tr><td>Interest: ${deposit.interest}</td></tr>
            <tr><td>Years of deposit: ${deposit.year}</td></tr>
            <tr><td>Payment: ${deposit.payment}</td></tr>
            <tr><td>Annuity: ${deposit.annuity}</td></tr>
            <tr><td>Annuities year: ${deposit.annuitiesYear}</td></tr>
            <tr><td>Annual interest on deposit: ${deposit.depositInterestByYear}</td></tr>
            <tr><td>Monthly interest on deposit: ${deposit.depositInterestByMonth}</td></tr>
        </table>
        <form method="post">
            <input type="submit" value="Save data" />
        </form>

    </div>
</body>
</html>