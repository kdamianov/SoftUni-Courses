function solve(num1, num2) {
    let sum = 0;
    let arr = [];
    for (let i = num1; i <= num2; i++) {
        arr.push(i);
        sum += i;
    }
    console.log(`${arr.join(' ')}`);
    console.log(`Sum: ${sum}`);
}


