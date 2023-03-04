function solve(input) {
    let cleanedCar = 0;

    for (const command of input) {
        switch (command) {
            case 'soap':
                cleanedCar += 10;
                break;
            case 'water':
                cleanedCar += cleanedCar * 0.20;
                break;
            case 'vacuum cleaner':
                cleanedCar += cleanedCar * 0.25;
                break
            case 'mud':
                cleanedCar -= cleanedCar * 0.10;
                break;
        }
    }
    console.log(`The car is ${cleanedCar.toFixed(2)}% clean.`)
}
