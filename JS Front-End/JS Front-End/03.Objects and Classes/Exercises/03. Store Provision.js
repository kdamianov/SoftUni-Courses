function solve(stock, orderedProducts) {
    let combinedStock = [...stock, ...orderedProducts]; //комбинираме в 1 масив!
    let store = {};

    for (let i = 0; i < combinedStock.length; i++) {
        let prop = combinedStock[i];
        if (i % 2 === 0) {
            if (!store.hasOwnProperty(prop)) {
                store[prop] = 0;
            }
        } else {
            let value = Number(prop);
            let previousProp = combinedStock[i - 1];
            store[previousProp] += value; 
        }
    }

    for (const key in store) {
        console.log(`${key} -> ${store[key]}`);
    }
}

solve([
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
],
    [
        'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]
);

