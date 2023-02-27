function solve(inputArr) {
    let minedGrams = 0;
    let days = 0;
    let totalMoney = 0;
    let gainedBitcoins = 0;
    let dayOfFirstBitcoin = 0;

    for (let i = 0; i < inputArr.length; i++) {
        days++;
        minedGrams = inputArr[i];
        
        if (days % 3 === 0) {
            minedGrams *= 0.7;
        }

        totalMoney += minedGrams * 67.51;

        while (totalMoney >= 11949.16) {
            if (dayOfFirstBitcoin === 0) {
                dayOfFirstBitcoin = days;
            }
            gainedBitcoins++;
            totalMoney -= 11949.16;
        }
    }
    
    console.log(`Bought bitcoins: ${gainedBitcoins}`);
    
    if (dayOfFirstBitcoin > 0) {
        console.log(`Day of the first purchased bitcoin: ${dayOfFirstBitcoin}`);
    }
    
    console.log(`Left money: ${totalMoney.toFixed(2)} lv.`)
}
