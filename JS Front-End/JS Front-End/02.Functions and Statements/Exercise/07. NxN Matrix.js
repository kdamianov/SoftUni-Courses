function solve(number) {
    let result = new Array(number)
        .fill(new Array(number).fill(number))
        .forEach(row => console.log(row.join(' ')));
}