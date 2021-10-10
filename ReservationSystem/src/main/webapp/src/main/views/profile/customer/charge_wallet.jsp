<%--
  Created by IntelliJ IDEA.
  User: MORTEZA
  Date: 10/7/2021
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Charge Wallet</title>
    </head>
    <body>
        <form action="charge-customer-wallet" method="post">
            <label for="price_id">Insert price to charge your account:</label>
            <table>
                <tr>
                    <td>
                        <input id="price_id" type="number" name="price" required />
                    </td>
                    <td>
                        <input type="submit" value="charge" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
