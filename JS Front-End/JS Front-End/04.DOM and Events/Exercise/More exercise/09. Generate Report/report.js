function generateReport() {
    let headers = Array.from(document.querySelectorAll("thead th"));
    let columns = Array.from(document.querySelectorAll('tbody tr'));
    let outputArea = document.getElementById('output');

    let checkedHeaders = [];
    let infoArr = [];

    for (let i = 0; i < headers.length; i++) {
        let checkedBox = headers[i].firstElementChild;
        if (checkedBox.checked === true) {
            checkedHeaders.push([i, checkedBox.name]);
        }
    }

    columns.forEach(c => {
        let info = {};
        let infoRows = c.children;

        checkedHeaders.forEach(ch => info[line[1]] = infoRows[line[0]].textContent);
        infoArr.push(info);
    });

    outputArea.value = JSON.stringify(infoArr);
}