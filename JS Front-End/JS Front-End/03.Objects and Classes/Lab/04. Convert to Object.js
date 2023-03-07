function solve(jsonString) {
    let person = JSON.parse(jsonString);

    let entries = Object.entries(person);

    for (let [key, value] of entries) {
        console.log(`${key}: ${value}`);
    }
}

solve('{"name": "Peter", "age": 35, "town": "Plovdiv"}');