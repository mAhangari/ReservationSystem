function tableFromJson(flightSchedule) {

    let col = [];

    for (let key in flightSchedule) {
        console.log(key);
        if (col.indexOf(key) === -1 && key !== "id") {
            col.push(key);
        }
    }

    // Create a table.
    let table = document.createElement("table");

    // Create table header row using the extracted headers above.
    let tr;                  // table row.

    // add json data to the table as rows.
    for (let j = 0; j < col.length; j++) {
        tr = table.insertRow(-1);
        let tabCell = tr.insertCell(-1);
        tabCell.innerHTML = col[j];
        tabCell = tr.insertCell(-1);
        tabCell.innerHTML = flightSchedule[col[j]];
    }

    // Now, add the newly created table with json data, to a container.
    let divShowData = document.getElementById('showTicketData');
    divShowData.innerHTML = "";
    divShowData.appendChild(table);
}

function tableFromCustomer(customerPojo) {

    let column = [];

    for (let key in customerPojo) {
        console.log(key);
        if (column.indexOf(key) === -1) {
            column.push(key);
        }
    }

    // Create a table.
    let table = document.createElement("table");

    // Create table header row using the extracted headers above.
    let tr;                  // table row.

    // add json data to the table as rows.
    for (let j = 0; j < column.length; j++) {
        tr = table.insertRow(-1);
        let tabCell = tr.insertCell(-1);
        tabCell.innerHTML = column[j];
        tabCell = tr.insertCell(-1);
        tabCell.innerHTML = customerPojo[column[j]];
    }

    // Now, add the newly created table with json data, to a container.
    let divShowData = document.getElementById('showPassengerData');
    divShowData.innerHTML = "";
    divShowData.appendChild(table);
}

