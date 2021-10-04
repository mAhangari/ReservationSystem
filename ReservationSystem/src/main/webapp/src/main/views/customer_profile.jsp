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
        <title>Title</title>
    </head>
    <body>
        <%
            Customer account = (Customer) request.getAttribute("account");
            out.println("Welcome " + account.getFirstName() + " " + account.getLastName());
            out.println("Select an option: ");
        %>
        <ul>
            <li>
                <a href="bye_ticket">By Ticket</a>
            </li>
            <li>
                <a href="refund_ticket">Ticket Refund</a>
            </li>
            <li>
                <a href="log_out">Log Out</a>
            </li>
        </ul>
    </body>
</html>
