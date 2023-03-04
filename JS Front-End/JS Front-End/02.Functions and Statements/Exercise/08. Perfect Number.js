function solve(num) {
    let divisors = [];

    for (let currentNum = 1; currentNum < num; currentNum++) {
        if (num % currentNum === 0) {
            divisors.push(currentNum);
        }
    }

    let divisorsSum = divisors.reduce((previousVal, currentVal) => previousVal + currentVal, 0);

    if (num === divisorsSum) {
        console.log('We have a perfect number!')
    } else {
        console.log('It\'s not so perfect.');
    }
}

solve(6);
solve(28);
solve(1236498);
