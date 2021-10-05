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
        <title>By Ticket</title>
    </head>
    <body>
        <h2>Fill following field:</h2>
        <form action="flightSchedule">
            <table>
                <tr>
                    <td>
                        <label for="sourceID">Source Place</label>
                    </td>
                    <td>
                        <input id="sourceID" type="text" name="source"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="destinationID">Destination Place</label>
                    </td>
                    <td>
                        <input id="destinationID" type="text" name="destination" />
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
