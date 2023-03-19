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
    
    for (let column of columns) {
        let info = {};
        let infoRows = column.children;

        for (let line of checkedHeaders) {
            info[line[1]] = infoRows[line[0]].textContent;
        }
        infoArr.push(info);
    }

    outputArea.value = JSON.stringify(infoArr);

    

}