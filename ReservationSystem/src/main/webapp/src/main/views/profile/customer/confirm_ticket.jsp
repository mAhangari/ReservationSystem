<%--
  Created by IntelliJ IDEA.
  User: MORTEZA
  Date: 10/11/2021
  Time: 2:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="ir.maktab.model.FlightSchedule" %>
<%@ page import="ir.maktab.util.ApplicationContext" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="java.io.IOException" %>
<%@ page import="ir.maktab.model.pojo.FlightSchedulePOJO" %>
<%@ page import="java.time.Duration" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="ir.maktab.model.Customer" %>
<%@ page import="ir.maktab.model.pojo.UserPOJO" %>
<%@ page import="ir.maktab.model.Coupon" %>
<html>
    <head>
        <title>Confirm Ticket</title>
        <link rel="stylesheet" href="style_flight_schedule">
        <script type="text/javascript" src="scriptFunctions"></script>
    </head>
    <body>
        <%
            RequestDispatcher requestDispatcher;
            String jsonStr = null;
            FlightSchedulePOJO flightSchedulePOJO = new FlightSchedulePOJO();

            if (request.getParameter("flightOption") != null)
                session.setAttribute("flightOpt", request.getParameter("flightOption"));


            if (session.getAttribute("flightOpt") != null) {
                Long flightId = Long.valueOf((String) session.getAttribute("flightOpt"));
                FlightSchedule flightSchedule = ApplicationContext.flightScheduleServ.findById(flightId);

                flightSchedulePOJO.setId(flightSchedule.getId());
                flightSchedulePOJO.setFlightNumber(flightSchedule.getFlightNumber());
                flightSchedulePOJO.setDestination(flightSchedule.getDestination());
                flightSchedulePOJO.setSource(flightSchedule.getSource());
                flightSchedulePOJO.setAirline(flightSchedule.getAirline().getAirlineName());
                flightSchedulePOJO.setTime(flightSchedule.getFlyTime());
                if (Duration.between(LocalDateTime.now(), flightSchedule.getFlyTime()).toMinutes() <= 60L)
                    flightSchedulePOJO.setPrice(String.valueOf(
                                    Long.parseLong(flightSchedule.getPrice()) / 2L
                            )
                    );
                else
                    flightSchedulePOJO.setPrice(flightSchedule.getPrice());

                ObjectMapper obj = new ObjectMapper();

                try {
                    jsonStr = obj.writeValueAsString(flightSchedulePOJO);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                request.setAttribute("message", "No tickets selected!!!");
                requestDispatcher = request.getRequestDispatcher("/src/main/views/profile/customer/show_flight_schedule.jsp");
                requestDispatcher.forward(request, response);
            }
        %>
        <%!
            public String getCustomerPojo(Customer customer) {

                String customerJson = "";
                UserPOJO customerPojo = new UserPOJO(
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getUsername(),
                        customer.getBirthDate(),
                        customer.getNationalCode()
                );

                ObjectMapper mapper = new ObjectMapper();
                try {
                    customerJson = mapper.writeValueAsString(customerPojo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return customerJson;
            }

        %>
        <script>
            window.onload = function() {
                tableFromJson(<%=jsonStr%>);
                tableFromCustomer(<%=getCustomerPojo((Customer) session.getAttribute("account"))%>)
            }
        </script>

        <h2>Ticket Information</h2>
        <p id="showTicketData"></p>
        <br />

        <h2>Passenger Information</h2>
        <p id="showPassengerData"></p>

        <br/>
        <form action="ticketController">
        <label for="discountCodeID">If have a discount code insert</label>
        <input id="discountCodeID" type="text" name="coupon">
        <input type="submit" value="import">
        </form>

        <%
            String message = (String) request.getAttribute("message");
            if (message != null)
                out.println(message);
        %>
        <br/>
        <table>
            <tr>
                <td>
                    Discount (%)
                </td>
                <td>
                    Total purchase
                </td>
            </tr>
            <tr>
                <td>
                    <%
                        Coupon coupon = null;
                        if (request.getAttribute("Coupon") != null) {
                            coupon = (Coupon) request.getAttribute("Coupon");
                            out.print(coupon.getPercentage() + " %");
                        }

                        else out.print("0 %");
                    %>
                </td>
                <td>
                    <%
                        if (request.getAttribute("Coupon") != null) {
                            double totalAmount = (Integer.parseInt(flightSchedulePOJO.getPrice()) - (coupon.getPercentage() / 100.0) * Integer.parseInt(flightSchedulePOJO.getPrice()));
                            out.print(totalAmount + " $");
                            session.setAttribute("totalAmount", String.valueOf(totalAmount));
                        }
                        else {
                            out.print(flightSchedulePOJO.getPrice() + " $");
                            session.setAttribute("totalAmount", flightSchedulePOJO.getPrice());
                        }
                    %>
                </td>
            </tr>
        </table>
        <form action="submit-ticket" method="post">
            <input type="submit" value="Buy">
        </form>

    </body>
</html>
