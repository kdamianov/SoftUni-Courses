function solve(words, text) {
    let wordsArr = words.split(', ');
    let textArr = text.split(' ');

    for (let word of wordsArr) {
        for (let textWord of textArr) {
            if (textWord.includes('*') && textWord.length == word.length){
                text = text.replace(textWord, word);
            }
        }
    }
    console.log(text);
}

solve('great, learning',
'softuni is ***** place for ******** new programming languages'
);