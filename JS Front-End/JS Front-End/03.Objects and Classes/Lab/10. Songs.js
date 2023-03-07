function solve(input) {
    class Song {
        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    let songs = [];
    let songsNumber = input.shift();
    let songType = input.pop();

    for (let i = 0; i < songsNumber; i++) {
        let [ typeList, name, time ] = input[i].split('_');
        songs.push(new Song(typeList, name, time));
    }

    if (songType === 'all') {
        songs.forEach((s) => console.log(s.name));
    } else {
        let filtered = songs.filter((s) => s.typeList === songType);

        filtered.forEach((s) => console.log(s.name));
    }

}

solve([3,
    'favourite_DownTown_3:14',
    'favourite_Kiss_4:16',
    'favourite_Smooth Criminal_4:01',
    'favourite']
    );