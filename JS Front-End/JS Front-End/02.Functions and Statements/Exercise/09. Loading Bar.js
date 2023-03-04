function solve(input){
    let bar = '[..........]';

    if (input == 100) {
        console.log('100% Complete!');
        console.log('[%%%%%%%%%%]');
    } else {
        for (let i = 0; i < input; i+=10) {
            bar = bar.replace('.', '%');
        }
        console.log(`${input}% ${bar}`);
        console.log('Still loading...');
    }
}

solve(30);