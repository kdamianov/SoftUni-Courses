function solve(input) {
    let horses = input.shift().split('|');

    for (let i = 0; i < input.length; i++) {
        let [command, ...rest] = input[i].split(' ');
        if (command === 'Retake') {
            let overtaking = rest[0];
            let overtaken = rest[1];
            let firstIndex = horses.indexOf(overtaking);
            let secondIndex = horses.indexOf(overtaken);
            if (firstIndex < secondIndex) {
                let temp = horses[firstIndex];
                horses[firstIndex] = horses[secondIndex];
                horses[secondIndex] = temp;
                console.log(`${overtaking} retakes ${overtaken}.`)
            }
        } else if (command === 'Trouble') {
            let horseInTrouble = rest[0];
            let horseIndex = horses.indexOf(horseInTrouble);
            if (horseIndex > 0) {
                horses.splice(horseIndex, 1);
                horses.splice(horseIndex - 1, 0, horseInTrouble);
                console.log(`Trouble for ${horseInTrouble} - drops one position.`)
            }
        } else if (command === 'Rage') {
            let rageHorse = rest[0];
            let horseIndex = horses.indexOf(rageHorse);
            horses.splice(horseIndex, 1);
            horses.splice(horseIndex + 2, 0, rageHorse);
            console.log(`${rageHorse} rages 2 positions ahead.`)
        } else if (command === 'Miracle') {
            let miracleHorse = horses.shift();
            horses.push(miracleHorse);
            console.log(`What a miracle - ${miracleHorse} becomes first.`)
        } else {
            break;
        }
    }
    console.log(String(horses.join('->')));
    console.log(`The winner is: ${horses[horses.length - 1]}`);

}

