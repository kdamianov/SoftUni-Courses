function solve(fightsCount, helmetPrice, swordPrice, shieldPrice, armorPrice) {
    let totalExpenses = 0;

    let brokenHelmets = Math.floor(fightsCount / 2);
    let brokenSwords = Math.floor(fightsCount / 3);
    let brokenShields = Math.floor(fightsCount / 6);
    let brokenArmor = Math.floor(brokenShields / 2);

    totalExpenses = brokenHelmets * helmetPrice + brokenSwords * swordPrice 
    + brokenShields * shieldPrice + brokenArmor * armorPrice;

    console.log(`Gladiator expenses: ${totalExpenses.toFixed(2)} aureus`);
}

solve (23,
    12.50,
    21.50,
    40,
    200
    );