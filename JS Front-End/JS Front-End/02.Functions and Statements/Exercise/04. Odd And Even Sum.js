function solve(input) {
    let numbers = Array.from(String(input), Number);
    let oddSum = 0;
    let evenSum = 0;

    numbers.forEach(number => {
        if (number % 2 === 0) {
            evenSum += number;
        } else {
            oddSum += number;
        }
    });

    console.log(`Odd sum = ${oddSum}, Even sum = ${evenSum}`);
}
