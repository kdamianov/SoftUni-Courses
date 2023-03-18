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

// Alternative:

// function extract(content) {
//     const text = document.getElementById(content).textContent;

//     let pattern = /\(([^)]+)\)/g;
//     let result = text.matchAll(pattern);
//     let wordsArr = [];

//     for (const word of result) {
//         wordsArr.push(word[1]);
//     }

//     return wordsArr.join("; ")
// }