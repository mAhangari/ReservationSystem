<%--
  Created by IntelliJ IDEA.
  User: MORTEZA
  Date: 10/4/2021
  Time: 3:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Buy Ticket</title>
    </head>
    <body>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null)
                out.println(message);
        %>
        <h2>Fill following field:</h2>
        <form action="flightSchedule">
            <table>
                <tr>
                    <td>
                        <label for="sourceID">Source Place</label>
                    </td>
                    <td>
                        <input id="sourceID" type="text" name="source" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="destinationID">Destination Place</label>
                    </td>
                    <td>
                        <input id="destinationID" type="text" name="destination" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="sortAirlineID">Air Line Name</label>
                    </td>
                    <td>
                        <select name="airlineName" id="sortAirlineID">
                            <option value="0">All Airline</option>
                            <option value="1">Iran Air</option>
                            <option value="2">Aseman</option>
                            <option value="3">Homa</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="sortPriceID">Max Price</label>
                    </td>
                    <td>
                        <input id="sortPriceID" type="number" min="50" step="5" name="priceValue">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <button type="submit">Submit</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
