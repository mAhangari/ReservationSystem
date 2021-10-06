<%--
  Created by IntelliJ IDEA.
  User: MORTEZA
  Date: 10/5/2021
  Time: 2:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Travel Schedule</title>
    </head>
    <body>
        <form action="saveFlightSchedule">
            <table>
                <tr>
                    <td>
                        <label for="sourceID">Source Place</label>
                    </td>
                    <td>
                        <input id="sourceID" type="text" name="source">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="destinationID">Destination Place</label>
                    </td>
                    <td>
                        <input id="destinationID" type="text" name="destination">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="travelDayID">Travel Day</label>
                    </td>
                    <td>
                        <input id="travelDayID" type="datetime-local" name="travelDay">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="flightNumberID">Flight Number</label>
                    </td>
                    <td>
                        <input id="flightNumberID" type="text" name="flightNumber">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="flightPriceID">Flight Price</label>
                    </td>
                    <td>
                        <input id="flightPriceID" type="text" name="flightPrice">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="submit" />
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
