window.addEventListener('load', solve);

function solve() {
    const addBtn = document.getElementById('add-btn');

    const song = {
        genre: document.getElementById('genre'),
        name: document.getElementById('name'),
        author: document.getElementById('author'),
        date: document.getElementById('date')
    }

    addBtn.addEventListener('click', addSongHandler);

    function addSongHandler(e) {
        if (e) {
            e.preventDefault();
        }

        const inputFields = Object.values(song).every((element) => element.value !== '');
        if (!inputFields) {
            return;
        }

        const hitsContainer = document.querySelector('.all-hits-container');
        const divElement = document.createElement('div');
        divElement.setAttribute('class', 'hits-info');

        divElement.innerHTML = `<img src="./static/img/img.png">
                                <h2>Genre: ${song.genre.value}</h2>
                                <h2>Name: ${song.name.value}</h2>
                                <h2>Author: ${song.author.value}</h2>
                                <h3>Date: ${song.date.value}</h3>
                                <button class="save-btn">Save song</button>
                                <button class="like-btn">Like song</button>
                                <button class="delete-btn">Delete</button>`;

        hitsContainer.appendChild(divElement);

        Object.values(song).forEach((input) => {
            input.value = ''
        });

        const likeBtn = divElement.querySelector('.like-btn');
        const saveBtn = divElement.querySelector('.save-btn');
        const deleteBtn = divElement.querySelector('.delete-btn');

        likeBtn.addEventListener('click', likeSongHandler);
        saveBtn.addEventListener('click', saveSongHandler);
        deleteBtn.addEventListener('click', deleteSongHandler)
        
        function likeSongHandler(e) {
            debugger
            e.currentTarget.disabled = true;
            let likes = document.querySelector('.likes p');
            let likesArr = likes.textContent.split(': ');
            let likesCount = Number(likesArr[1]);
            likesCount++;
            likes.textContent = `Total Likes: ${likesCount}`;

        }

        function saveSongHandler() {
            const savedSongElement = document.querySelector('.saved-container');
            likeBtn.remove();
            saveBtn.remove();
            //мести на ново място и маха от старото място
            savedSongElement.appendChild(divElement); 
        }

        function deleteSongHandler() {
            divElement.remove();
        }
    }
}