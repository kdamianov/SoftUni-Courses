function loadRepos() {
	const USER_NAME = document.getElementById('username').value;
	const USER_REPOS = document.getElementById('repos')
	const BASE_URL = "https://api.github.com/users/";

	USER_REPOS.textContent = '';
	fetch(`${BASE_URL}${USER_NAME}/repos`)
		.then((response) => response.json())
		.then((data) => 
			data.forEach(currentElement => {
				let hrefEl = document.createElement('a');
				hrefEl.textContent = `${currentElement.full_name}`;
				hrefEl.setAttribute("href", `${currentElement.html_url}`);
				const liEl = document.createElement('li');
				liEl.appendChild(hrefEl);
				USER_REPOS.appendChild(liEl);
			})
		)
		.catch((error) => {
			hrefEl.textContent = `${error}`;
			const liEl = document.createElement('li');
			liEl.appendChild(hrefEl);
			USER_REPOS.appendChild(liEl);
		});
}
