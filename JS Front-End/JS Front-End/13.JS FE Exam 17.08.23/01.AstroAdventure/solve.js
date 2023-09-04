function solve(input){
    let astronautsNum = input.shift();
    let astronautsTeam = {};
    let commandParser = {
        Explore: explore,
        Refuel: refuel,
        Breathe: breathe
    };

    for (let index = 0; index < astronautsNum; index++) {
        let [ astronautName, oxygenLevel, energyReserves ] = input.shift().split(' ');
        astronautsTeam[astronautName] = { oxygenLevel, energyReserves }
    }
    

    for (const line of input) {
        if (line === 'End') {
            break;
        } else {
            let commandLine = line.split(' - ');
            let command = commandLine.shift();

            commandParser[command](...commandLine);
        }
    }

    for (const astronaut in astronautsTeam) {
        console.log(`Astronaut: ${astronaut}, Oxygen: ${astronautsTeam[astronaut].oxygenLevel}, Energy: ${astronautsTeam[astronaut].energyReserves}`)
    }
    

    function explore(astronautName, energyNeeded){
        let energyReserves = Number(astronautsTeam[astronautName].energyReserves);
        if (energyReserves > Number(energyNeeded)) {
            let energyReservesLeft = energyReserves - Number(energyNeeded);
            astronautsTeam[astronautName].energyReserves = energyReservesLeft;
            console.log(`${astronautName} has successfully explored a new area and now has ${energyReservesLeft} energy!`);
        } else {
            console.log(`${astronautName} does not have enough energy to explore!`)
        }
    }

    function refuel(astronautName, amount){
        let energyReserves = Number(astronautsTeam[astronautName].energyReserves);
        let addedEnergy = Number(amount);
        let currentEnergyReserves = astronautsTeam[astronautName].energyReserves;
        astronautsTeam[astronautName].energyReserves = energyReserves + addedEnergy;
        let amountRecovered = addedEnergy;
        if (astronautsTeam[astronautName].energyReserves > 200) {
            amountRecovered = 200 - currentEnergyReserves;
            astronautsTeam[astronautName].energyReserves = 200;
        }

        console.log(`${astronautName} refueled their energy by ${amountRecovered}!`)
    }

    function breathe(astronautName, amount){
        let oxygenLevel = Number(astronautsTeam[astronautName].oxygenLevel);
        let addedOxygen = Number(amount);
        let currentOxygenLevel = astronautsTeam[astronautName].oxygenLevel;
        astronautsTeam[astronautName].oxygenLevel = oxygenLevel + addedOxygen;
        let amountRecovered = addedOxygen;

        if (astronautsTeam[astronautName].oxygenLevel > 100) {
            amountRecovered = 100 - currentOxygenLevel;
            astronautsTeam[astronautName].oxygenLevel = 100;
        }
        console.log(`${astronautName} took a breath and recovered ${amountRecovered} oxygen!`);
    }
    
}

solve([ '4',
    'Alice 60 100',
    'Bob 40 80',
    'Charlie 70 150',
    'Dave 80 180',
    'Explore - Bob - 60',
    'Refuel - Alice - 30',
    'Breathe - Charlie - 50',
    'End']
);