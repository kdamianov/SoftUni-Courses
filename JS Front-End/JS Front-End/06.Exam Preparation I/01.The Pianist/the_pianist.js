function solve(input) {
    let piecesNum = Number(input.shift());
    let pieces = {};

    for (let i = 0; i < piecesNum; i++) {
        let [piece, composer, key] = input.shift().split('|');
        pieces[piece] = { composer, key };
    }

    for (const line of input) {
        let commandInfo = line.split('|');
        let command = commandInfo.shift();
        if (command === 'Add') {
            let [piece, composer, key] = commandInfo;

            if (!pieces.hasOwnProperty(piece)) {
                pieces[piece] = { composer, key };
                console.log(`${piece} by ${composer} in ${key} added to the collection!`);
            } else {
                console.log(`${piece} is already in the collection!`);
            }
        } else if (command === 'Remove') {
            let piece = commandInfo.shift();

            if (!pieces.hasOwnProperty(piece)) {
                console.log(`Invalid operation! ${piece} does not exist in the collection.`);
            } else {
                delete pieces[piece];
                console.log(`Successfully removed ${piece}!`);
            }
        } else if (command === 'ChangeKey') {
            let [piece, newKey] = commandInfo;

            if (!pieces.hasOwnProperty(piece)) {
                console.log(`Invalid operation! ${piece} does not exist in the collection.`);
            } else {
                pieces[piece].key = newKey;
                console.log(`Changed the key of ${piece} to ${newKey}!`);
            }
        }
    }

    let entries = Object.entries(pieces);
    for (const [piece, info] of entries) {
        console.log(`${piece} -> Composer: ${info.composer}, Key: ${info.key}`);
    }
}

solve([
    '3',
    'Fur Elise|Beethoven|A Minor',
    'Moonlight Sonata|Beethoven|C# Minor',
    'Clair de Lune|Debussy|C# Minor',
    'Add|Sonata No.2|Chopin|B Minor',
    'Add|Hungarian Rhapsody No.2|Liszt|C# Minor',
    'Add|Fur Elise|Beethoven|C# Minor',
    'Remove|Clair de Lune',
    'ChangeKey|Moonlight Sonata|C# Major',
    'Stop'
]
);