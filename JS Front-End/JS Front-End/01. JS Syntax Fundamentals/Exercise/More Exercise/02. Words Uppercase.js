function solve(text) {
    let searchedWord = /\w+/g;
    let wordsArr = text.match(searchedWord);
    let newArr = [];
    

    for (let i = 0; i < wordsArr.length; i++) {
        newArr.push(wordsArr[i].toUpperCase());
    }
        

    console.log(newArr.join(', '));
}

solve('Hi, how are you?');