let numberTransmission = 0
let calculationUrl = window.origin + "/calculation";

document.getElementById("add-button").addEventListener('click', () => {
    let container = document.getElementById("currentTransmissions");

    container.innerHTML +=
        "<div style=\"border: 1px gray solid; padding: 1rem 1rem 0 1rem; margin-top: 1rem;\">\n" +
        " <p>Передача №"+ numberTransmission +"</p> " +
        "                        <div class=\"form-floating mb-3\">\n" +
        "                            <input type=\"email\" class=\"form-control\" id=\"tv"+ numberTransmission +"\">\n" +
        "                            <label for=\"tvi\">Время работы текущей передачи</label>\n" +
        "                        </div>\n" +
        "                        <div class=\"form-floating mb-3\">\n" +
        "                            <input type=\"email\" class=\"form-control\" id=\"n"+ numberTransmission +"\">\n" +
        "                            <label for=\"ni\">Частота вращения ведущей звездочки для текущей передачи</label>\n" +
        "                        </div>\n" +
        "                        <div class=\"form-floating mb-3\">\n" +
        "                            <input type=\"email\" class=\"form-control\" id=\"f"+ numberTransmission +"\">\n" +
        "                            <label for=\"fi\">F для текущей передачи</label>\n" +
        "                        </div>\n" +
        "                    </div>"
    numberTransmission++
})

document.getElementById("calculation-button").addEventListener('click', async () => {
    let z1 = document.getElementById("z1").value
    let N = document.getElementById("N").value
    let sop = document.getElementById("sop").value
    let driveType = document.getElementById("driveType").value
    let loadType = document.getElementById("loadType").value
    let chainRowRation = document.getElementById("chainRowRation").value

    let currentTransmissions = []
    for (let i = 0; i < numberTransmission; i++) {
        let tv = document.getElementById("tv" + i).value
        let n = document.getElementById("n" + i).value
        let f = document.getElementById("f" + i).value

        currentTransmissions.push({
            "tv": tv,
            "n": n,
            "f": f
        })
    }

    let response = await fetch(calculationUrl, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "z1": z1,
            "n": N,
            "sop": sop,
            "currentTransmissions": currentTransmissions,
            "driveType": driveType,
            "loadType": loadType,
            "chainRowRation": chainRowRation
        })
    })

    if (response.ok) {
        let json = await response.json()

        document.getElementById("result").innerHTML = ""
        for (let i = 0; i < json.length; i++) {
            document.getElementById("result").innerHTML +=
                "<p>Среднее давление равно = "+ json[i].result +"</p>"
        }
    }
})