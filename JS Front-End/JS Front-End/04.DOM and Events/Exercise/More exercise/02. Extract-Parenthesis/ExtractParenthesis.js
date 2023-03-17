function extract(content) {
    const text = document.getElementById(content).textContent;

    let pattern = /\(([^)]+)\)/g;
    let matcher = pattern.exec(text);
    let wordsArr = [];

    while (matcher) {
        wordsArr.push(matcher[1]);
        matcher = pattern.exec(text);
    }

    return wordsArr.join("; ")
}