<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <title>Deposit</title>
    <link rel="stylesheet" href="style.css"></link>
    <style>
        .container {
           display: flex;
           background-color: aqua;
             }
        table {
                flex: 1;
                margin: 10px;
                padding: 10px;
                background-color: #eee;
                border: 1px solid #ccc;
                border-radius: 5px;
         }
          </style>
</head>
<body>
    <h2>Adatok a loan-calc API-rol</h2>
    <div class="container">
        <table><display=flex>
            <tr>
               <td>Fund: ${deposit.fund}</td>
               <td>Interest: ${deposit.interest}</td>
               <td>Years of deposit: ${deposit.year}</td>
               <td>Payment: ${deposit.payment}</td>
            </tr>
         </table>
    </div>
</body>
</html>