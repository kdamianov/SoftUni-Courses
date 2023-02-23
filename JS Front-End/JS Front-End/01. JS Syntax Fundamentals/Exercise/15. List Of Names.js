function listOfNames(names) {
    let list =  [...names]
    .sort((aName, bName) => aName.localeCompare(bName))
    .map((name, index) => `${index +1}.${name}`)
    .join('\n');

    console.log(list);
}