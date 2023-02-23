function sortingNumbers(numbers) {
    let sorted = [...numbers].sort((a, b) => a - b);
    let step = 0;
    let result = [];
    while (sorted.length > 0) {
        if (step % 2 === 0) {
            let firstEl = sorted.shift();
            result.push(firstEl);
        } else {
            let lastEl = sorted.pop();
            result.push(lastEl);
        }
        step++;
    }
    return result;
}