function solve(input) {
    let towns = [];
    for (const line of input) {
        let [town, latitude, longitude] = line.split(' | ');
        let townObject = {town, latitude: Number(latitude).toFixed(2), longitude: Number(longitude).toFixed(2)};
        towns.push(townObject);
    }

    for (const town of towns) {
        console.log(town);
    }
}

