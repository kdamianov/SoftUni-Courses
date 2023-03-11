function piccolo(input){
    let parking = new Set();

    for (let line of input) {
        let [ command, carNum ] = line.split(', ');
        if (command === 'IN') {
            parking.add(carNum);
        } else if (command === 'OUT') {
            parking.delete(carNum);
        }
    }
    
    if (parking.size === 0) {
        console.log('Parking Lot is Empty')
    } else {
        let sortedCars = [...parking.keys()].sort((numA, numB) => numA.localeCompare(numB));
        sortedCars.forEach(car => console.log(car));
    }
}

piccolo(['IN, CA2844AA',
'IN, CA1234TA',
'OUT, CA2844AA',
'OUT, CA1234TA']
);