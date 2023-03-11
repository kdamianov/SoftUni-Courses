function wordTracker(input) {
    let words = {};
    let searchedWords = input.shift().split(' ');

    for (const word of searchedWords) {
        let count = input.filter((w) => w === word).length;
        words[word] = count;
    }

    let ordered = Object.entries(words)
        .sort((wordA, wordB) => {
            let [_nameA, countA] = wordA;
            let [_nameB, countB] = wordB;

            return countB - countA;
        });

    // for (const line of ordered) {
    //     console.log(`${line[0]} - ${line[1]}`);
    // }

    for (const [word, count] of ordered) {
        console.log(`${word} - ${count}`);
    }
}

wordTracker([
    'is the',
    'first', 'sentence', 'Here', 'is', 'another', 'the', 'And', 'finally', 'the', 'the', 'sentence']
);