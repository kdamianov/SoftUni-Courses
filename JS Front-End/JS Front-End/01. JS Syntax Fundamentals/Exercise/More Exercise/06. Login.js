function solve(inputArr) {
    let username = inputArr[0];
    let usernameArr = username.split('');
    let reversed = usernameArr.reverse();
    let correctPass = reversed.join('');

    for (let i = 1; i <= inputArr.length - 1; i++) {
        if (inputArr[i] === correctPass) {
            console.log(`User ${username} logged in.`);
            break;
        } else if (i === 4) {
            console.log(`User ${username} blocked!`);
        } else {
            console.log('Incorrect password. Try again.');

        }
    }
}
solve(['sunny','rainy','cloudy','sunny','not sunny']);