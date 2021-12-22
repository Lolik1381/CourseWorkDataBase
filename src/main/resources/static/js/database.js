let headers = [ "id",    "ky",    "kv",    "kd",    "kz",    "k_t",    "km",    "kt",    "z1",    "n1",    "tz",    "n",    "t",    "pys",    "sop",    "yz",    "feu",    "fi",    "ni",    "tzi",    "k"]

async function load_page() {
    let header = document.getElementById("header")

    for (let i = 0; i < headers.length; i++) {
        header.innerHTML += "<th scope='col'>" + headers[i] + "</th>"
    }

    let response = await fetch(window.origin + "/database/all");
    response = await response.json()

    let body = document.getElementById("body")
    for (let i = 0; i < response.length; i++) {
        let row = "<tr><th scope='row'>"+ response[i].id +"</th>"
        for (let j = 0; j < headers.length; j++) {
            if (headers[j] !== "id") {
                row += "<td>"+ response[i][headers[j]] +"</td>"
            }
        }
        row += "</tr>"

        body.innerHTML += row
    }
}

document.addEventListener("DOMContentLoaded", async function() {
    await load_page()
});