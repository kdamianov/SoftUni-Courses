function solve(numbers) {
    numbers
        .forEach((num) => {
            console.log(isPalindrome(num))
        });

    function isPalindrome(num) {
        let reversed = Number([...num.toString()].reverse().join(''));

        return num === reversed;
    }
}

// const isPalindrome = (num) => Number([...num.toString()].reverse().join('')) === num;
// let result = numbers.map(isPalindrome).join('\n');         returns an array!