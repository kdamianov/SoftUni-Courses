function solve(num) {
    let arr = Array.from(String(num));
    let firstNum = arr[0];
    let isSame = true;
    let sum = 0;

    for (digit of arr) {
        if (digit == firstNum) {
            isSame = true;
        } else {
            isSame = false;
        }

        sum += Number(digit);
    }

    console.log(isSame);
    console.log(sum);
}

