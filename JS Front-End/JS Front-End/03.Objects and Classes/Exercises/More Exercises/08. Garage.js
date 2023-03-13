function garage(input) {
    let garages = {};

    for (const line of input) {
        let [garageNumber, info] = line.split(' - ');
        if (!garages.hasOwnProperty(garageNumber)) {
            garages[garageNumber] = [];
        }
        garages[garageNumber].push(info);
    }

    let entries = Object.entries(garages);
    for (const [key, value] of entries) {
        console.log(`Garage № ${key}`);

        for (let line of value) {
            line = String(line);
            while (line.includes(': ')) {
                line = line.replace(': ', ' - ');
            }
            console.log(`--- ${line}`);
        }


    }
}

// Test
garage(['1 - color: blue, fuel type: diesel', '1 - color: red, manufacture: Audi', '2 - fuel type: petrol', '4 - color: dark blue, fuel type: diesel, manufacture: Fiat']);
garage(['1 - color: green, fuel type: petrol',
    '1 - color: dark red, manufacture: WV',
    '2 - fuel type: diesel',
    '3 - color: dark blue, fuel type: petrol']
);


