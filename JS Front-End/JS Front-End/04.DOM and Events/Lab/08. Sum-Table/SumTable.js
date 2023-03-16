function sumTable() {
    let costEl = Array.from(document.querySelectorAll('tr td:nth-of-type(2)'));

    let sumValue = 0;

    costEl.forEach((e) => {
        sumValue += Number(e.textContent);
    });

    let sumEl = document.getElementById('sum');
    sumEl.textContent = sumValue;
}