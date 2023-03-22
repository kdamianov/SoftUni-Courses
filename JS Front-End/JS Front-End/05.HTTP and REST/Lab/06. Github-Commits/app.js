function loadCommits() {
    const username = document.getElementById('username');
    const repo = document.getElementById('repo');
    const ulElement = document.getElementById('commits');
    ulElement.textContent = '';
    const usernameVal = username.value;
    const repoVal = repo.value;
    const BASE_URL = 'https://api.github.com/repos/';

    fetch(`${BASE_URL}${usernameVal}/${repoVal}/commits`)
        .then((response) => response.json())
        .then((data) => data.forEach(({ commit }) => {
            const liElement = document.createElement('li');
            liElement.textContent = `${commit.author.name}: ${commit.message}`;
            ulElement.appendChild(liElement);
        }))
        .catch((e) => {
            const liElement = document.createElement('li');
            liElement.textContent = `Error: 404 (Not Found)`;
            ulElement.appendChild(liElement);
        });
}