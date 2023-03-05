function solve(input) {
    let cleanedCar = 0;
    const add = (a, b) => a + b;
    const percent = (a, b) => a * (b / 100);

    for (const command of input) {
        switch (command) {
            case 'soap':
                cleanedCar = add(cleanedCar, 10);
                break;
            case 'water':
                cleanedCar += percent(cleanedCar, 20);
                break;
            case 'vacuum cleaner':
                cleanedCar += percent(cleanedCar, 25);
                break
            case 'mud':
                cleanedCar -= percent(cleanedCar, 10);
                break;
        }
    }
    console.log(`The car is ${cleanedCar.toFixed(2)}% clean.`)
}

solve(['soap', 'soap', 'vacuum cleaner', 'mud', 'soap', 'water']);
