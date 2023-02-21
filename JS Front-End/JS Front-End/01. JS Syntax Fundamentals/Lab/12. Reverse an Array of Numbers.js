function reverse(n, inputArr) {
    let newArr = [];

    for (let i = 0; i < n; i++) {
        let element = inputArr[i];
        newArr.push(element);
    }

    let output = "";

    for (let i = newArr.length - 1; i >= 0; i--) {
        let newElement = newArr[i];
        output += newElement + " ";
    }

    console.log(output);
}

reverse(2, [66, 43, 75, 89, 47]);