function solve(num1, num2, num3) {
    const sum = (a, b) => a + b;
    const subtract = (mySum, num) => mySum - num;

    return subtract(sum(num1, num2), num3);

}

// const calculation (num1, num2, num3) => {const sum = (a, b) => a + b;
// const subtract = (mySum, num) => mySum - num;
// return subtract (sum(num1, num2), num3);
// };


