<%--
  Created by IntelliJ IDEA.
  User: MORTEZA
  Date: 10/10/2021
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="ir.maktab.model.Employee" %>
<html>
    <head>
        <title>Coupon</title>
        <link rel="stylesheet" href="sign_up_employee_style.css">
    </head>
    <body>
        <%
            Employee account = (Employee) session.getAttribute("account");
            out.println("Welcome " + account.getFirstName() + " " + account.getLastName());
            out.println("Select an option: ");
        %>
        <form action="discountCouponController" method="get">
            <table>
                <tr>
                    <td>
                        <label for="codeID">Insert Coupon Code</label>
                    </td>
                    <td>
                        <input id="codeID" type="text" name="couponCode" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="expireID">Select Expire Date</label>
                    </td>
                    <td>
                        <input id="expireID" type="datetime-local" name="expireDate" required/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="offPercentageID">Insert Percentage of Offer</label>
                    </td>
                    <td>
                        <input id="offPercentageID" type="number" min="0" max="100" name="OffPercentage" required/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Add" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
