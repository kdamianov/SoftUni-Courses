function extractText() {
    const liElements = Array.from(document.querySelectorAll('#items > li'));
    const result = document.getElementById('result');

    liElements
        .forEach((li) => {
            console.log(li.textContent);
            result.textContent += li.textContent + '\n';
        })
}