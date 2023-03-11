function solve(stock, orderedProducts) {
    //комбинираме в 1 масив!
    let combinedStock = [...stock, ...orderedProducts]; 
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



