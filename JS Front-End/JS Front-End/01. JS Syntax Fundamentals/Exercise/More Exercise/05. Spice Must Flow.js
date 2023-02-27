function solve(startingYield) {
    let operatingDays = 0;
    let spiceAmount = 0;

    while (startingYield >= 100) {
        spiceAmount += startingYield - 26;
        operatingDays++;

        startingYield -= 10;
    }

    if (spiceAmount >= 10) {
        spiceAmount -= 26;
    } else {
        spiceAmount = 0;
    }

    console.log(operatingDays);
    console.log(spiceAmount);
}
