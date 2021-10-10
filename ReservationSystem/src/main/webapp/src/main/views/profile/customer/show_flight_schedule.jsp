<%--
  Created by IntelliJ IDEA.
  User: MORTEZA
  Date: 10/4/2021
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Flight Schedule</title>

        <link rel="stylesheet" href="style_flight_schedule">

    </head>
    <body>
        <%
            String message = (String) request.getAttribute("message");
            if (message != null)
                out.println(message);
        %>

        <script>
            let flightSchedules = <%=session.getAttribute("flightSchedules")%>;
            window.onload = function() {
                tableFromJson(flightSchedules);
            }
        </script>
        <table>
            <tr>
                <td>
                    <p><button onclick="sortTableByAirline(flightSchedules)">Sort By Airline</button></p>
                </td>
                <td>
                    <p><button onclick="sortTableByPrice(flightSchedules)">Sort By Price</button></p>
                </td>
            </tr>
        </table>
        <form action="submit-ticket" method="get">
            <p id='showData'></p>
            <input type="submit" value="submit" />
        </form>
    </body>
    <script>
        let ascending = false;

        function tableFromJson(flightSchedules) {

            let col = [];
            for (let i = 0; i < flightSchedules.length; i++) {
                for (let key in flightSchedules[i]) {

                    if (col.indexOf(key) === -1 && key !== "id") {
                        col.push(key);
                    }
                }
            }

            // Create a table.
            let table = document.createElement("table");

            // Create table header row using the extracted headers above.
            let tr = table.insertRow(-1);                   // table row.
            let th = document.createElement("th");
            th.innerHTML = "option";
            tr.appendChild(th);

            for (let i = 0; i < col.length; i++) {
                th = document.createElement("th");      // table header.
                th.innerHTML = col[i];
                tr.appendChild(th);
            }

            // add json data to the table as rows.
            for (let i = 0; i < flightSchedules.length; i++) {
                let check= "<input type='radio' name='flightOption' value=";
                check = check.concat(flightSchedules[i]['id'], ">")
                tr = table.insertRow(-1);
                let tabCell = tr.insertCell(-1);
                tabCell.innerHTML = check;

                for (let j = 0; j < col.length; j++) {
                    let tabCell = tr.insertCell(-1);
                    tabCell.innerHTML = flightSchedules[i][col[j]];
                }
            }

            // Now, add the newly created table with json data, to a container.
            let divShowData = document.getElementById('showData');
            divShowData.innerHTML = "";
            divShowData.appendChild(table);

        }

        function sortTableByAirline(flightSchedules) {
            if (ascending === false) {
                flightSchedules.sort(function (a, b) {
                    return a.airline.localeCompare(b.airline);
                });
                ascending = true;
            } else if (ascending === true) {
                flightSchedules.sort(function(a, b) {
                    return b.airline.localeCompare(a.airline);
                });
                ascending = false;
            }
            tableFromJson(flightSchedules);
        }

        function sortTableByPrice(flightSchedules) {
            if (ascending === false) {
                flightSchedules.sort(function (a, b) {
                    return a.price.localeCompare(b.price);
                });
                ascending = true;
            } else if (ascending === true) {
                flightSchedules.sort(function(a, b) {
                    return b.price.localeCompare(a.price);
                });
                ascending = false;
            }
            tableFromJson(flightSchedules);
        }
    </script>
</html>

