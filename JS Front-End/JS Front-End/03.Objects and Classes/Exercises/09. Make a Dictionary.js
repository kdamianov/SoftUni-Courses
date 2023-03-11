function dictionary(input) {
    let dictionary = {}

    for (let line of input) {
        line = JSON.parse(line);
        dictionary[Object.keys(line)] = Object.values(line);
    }

    let sorted = Object.entries(dictionary).sort();

    for (const [ term, deff ] of sorted) {
        console.log(`Term: ${term} => Definition: ${deff}`);
    }
}

