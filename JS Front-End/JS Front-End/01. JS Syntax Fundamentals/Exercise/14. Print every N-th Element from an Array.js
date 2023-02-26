function solve(arr, num) {
    let newArr = [];
    for (let index = 0; index < arr.length; index += num) {
        newArr.push(arr[index]);
    }
    return newArr;
}
