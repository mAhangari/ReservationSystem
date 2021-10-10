<%--
  Created by IntelliJ IDEA.
  User: MORTEZA
  Date: 10/4/2021
  Time: 2:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="ir.maktab.model.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Profile</title>
    </head>
    <body>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null)
                out.println(message);
        %>
        <%
            Customer account = (Customer) session.getAttribute("account");
            out.println("Welcome " + account.getFirstName() + " " + account.getLastName());
            out.println("Select an option: ");
        %>
        <ul>
            <li>
                <a href="buy_ticket">Buy Ticket</a>
            </li>
            <li>
                <a href="refund_ticket">Ticket Refund</a>
            </li>
            <li>
                <a href="charge-wallet">Charge Account</a>
            </li>
            <li>
                <a href="log_out">Log Out</a>
            </li>
        </ul>
    </body>
</html>
