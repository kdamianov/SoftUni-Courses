function catalogue(input) {
    let output = {};

    for (let line of input) {
        let [name, price] = line.split(' : ');
        output[name] = Number(price);
    }

    let sorted = Object.keys(output).sort((keyA, keyB) =>  keyA.localeCompare(keyB));

    let productLetter = '';
    for (let name of sorted) {
        let price = output[name];
        if (productLetter !== name[0]) {
            productLetter = name[0];
            console.log(productLetter);
        }
        console.log(`  ${name}: ${price}`)
    }

}

catalogue([
    'Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10'
]
);