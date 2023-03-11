function inventoryFunc(input) {
    let heroes = [];

    for (const line of input) {
        let [name, level, inventory] = line.split(' / ');
        level = Number(level);
        heroes.push({ name, level, inventory });
    }

    let sorted = heroes.sort((heroA, heroB) => heroA.level -heroB.level);

    for (const hero of sorted) {
        console.log(`Hero: ${hero.name}`);
        console.log(`level => ${hero.level}`);
        console.log(`items => ${hero.inventory}`);

    }
}

inventoryFunc([
    'Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara'
]
);