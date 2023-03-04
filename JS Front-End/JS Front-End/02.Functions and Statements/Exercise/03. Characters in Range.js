function solve(char1, char2) {
    const getASCIICode = (char) => char.charCodeAt(0);
    let firstChar = getASCIICode(char1);
    let secondChar = getASCIICode(char2);

    let min = Math.min(firstChar, secondChar);
    let max = Math.max(firstChar, secondChar);

    let chars = [];

    for (let asciiCode = min + 1; asciiCode < max; asciiCode++) {
        chars.push(String.fromCharCode(asciiCode))
    }

    return chars.join(' ');
}

console.log(solve('C',
'#'
));