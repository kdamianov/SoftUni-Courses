function solve(input) {
    let groceries = input.shift().split('!');
    
    for (const line of input) {
        let commandInfo = line.split(' ');
        let command = commandInfo.shift();
        let product = String(commandInfo[0]);
        let index = groceries.indexOf(product);

        if (command === 'Urgent') {
            if (!groceries.includes(product)) {
                groceries.unshift(product);
            }
        } else if (command === 'Unnecessary') {
            if (groceries.includes(product)) {
                groceries.splice(index, 1);
            }
        } else if (command === 'Correct') {
            let newProduct = String(commandInfo[1]);
            if (groceries.includes(product)) {
                groceries.splice(index, 1, newProduct);
            }
            
        } else if ( command === 'Rearrange') {
            if (groceries.includes(product)) {
                groceries.splice(index, 1);
                groceries.push(product);
            }
        }

    
    }
    console.log(groceries.join(', '));
}

solve(["Milk!Pepper!Salt!Water!Banana",
"Urgent Salt",
"Unnecessary Grapes",
"Correct Pepper Onion",
"Rearrange Grapes",
"Correct Tomatoes Potatoes",
"Go Shopping!"]);