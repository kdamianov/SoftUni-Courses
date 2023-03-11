function oddOcc(input) {
    let foundWords = {};
    let words = input.split(' ');

    for (let word of words) {
        word = word.toLowerCase();

        if (foundWords.hasOwnProperty(word)) {
            foundWords[word] += 1;
        } else {
            foundWords[word] = 1;
        }
    }

    let filtered = Object.entries(foundWords)
        .filter(([key, value]) => { 
            return value % 2 !== 0; 
        })
        .sort((wordA,wordB) => {
            let [_nameA, countA] = wordA;
            let [_nameB, countB] = wordB;

            return countB - countA;
        });

    let result = '';
    for (const [key, value] of filtered) {
        result += key + ' ';
    }

    console.log(result);
}

oddOcc('Java C# Php PHP Java PhP 3 C# 3 1 5 C#');