<%--
  Created by IntelliJ IDEA.
  User: MORTEZA
  Date: 10/4/2021
  Time: 2:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="ir.maktab.model.Employee" %>
<html>
    <head>
        <title>Admin Profile</title>
    </head>
    <body>
        <%
            Employee account = (Employee) session.getAttribute("account");
            out.println("Welcome " + account.getFirstName() + " " + account.getLastName());
            out.println("Select an option: ");
        %>

        <ul>
           <li>
               <a href="coupon">Add Discount Coupon</a>
           </li>
           <li>
               <a href="add-employee-jsp">Add Employee</a>
           </li>
           <li>
               <a href="log_out">Log out</a>
           </li>
        </ul>
    </body>
</html>
