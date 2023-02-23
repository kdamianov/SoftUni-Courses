function solve(numbers, rotations) {
    rotations %= numbers.length;

    for (let i = 0; i < rotations; i++) {
        let firstNum = numbers.shift();
        numbers.push(firstNum);
    }
    console.log(numbers.join(' '));
}

