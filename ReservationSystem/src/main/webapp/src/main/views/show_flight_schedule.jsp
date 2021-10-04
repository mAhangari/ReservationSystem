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
        <style>
            th, td, p, input, h3 {
                font:15px 'Segoe UI';
            }
            table, th, td {
                border: solid 1px #ddd;
                border-collapse: collapse;
                padding: 2px 3px;
                text-align: center;
            }
            th {
                font-weight:bold;
            }
        </style>
    </head>
    <body>
            <script>
                window.onload = function() {
                    tableFromJson();
                }
            </script>
            <p id='showData'></p>

    </body>
    <script>

        function tableFromJson() {
            let flightSchedules = <%=request.getAttribute("flightSchedules")%>;

            let col = [];
            for (let i = 0; i < flightSchedules.length; i++) {
                for (let key in flightSchedules[i]) {

                    if (col.indexOf(key) === -1) {
                        col.push(key);
                    }
                }
            }

            // Create a table.
            let table = document.createElement("table");

            // Create table header row using the extracted headers above.
            let tr = table.insertRow(-1);                   // table row.
            console.log(tr);

            for (let i = 0; i < col.length; i++) {
                let th = document.createElement("th");      // table header.
                th.innerHTML = col[i];
                tr.appendChild(th);
            }

            // add json data to the table as rows.
            for (let i = 0; i < flightSchedules.length; i++) {

                tr = table.insertRow(-1);

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
    </script>
</html>

