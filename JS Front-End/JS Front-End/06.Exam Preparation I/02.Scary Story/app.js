window.addEventListener('load', solve);

function solve() {
  let firstNameEl = document.getElementById('first-name');
  let lastNameEl = document.getElementById('last-name');
  let ageEl = document.getElementById('age');
  let storyTitleEl = document.getElementById('story-title');
  let genreEl = document.getElementById('genre');
  let storyEl = document.getElementById('story');
  let publishBtnEl = document.getElementById('form-btn');
  let previewUlEl = document.getElementById('preview-list');
  let mainEl = document.getElementById('main');

  publishBtnEl.addEventListener('click', onPublish);

  function onPublish(e) {
    e.preventDefault();

    if (firstNameEl.value === "" ||
      lastNameEl.value === "" ||
      ageEl.value === "" ||
      storyTitleEl.value === "" ||
      storyEl.value === "") {
      return;
    }

    let liEl = document.createElement('li');
    liEl.setAttribute('class', 'story-info');
    let articleEl = document.createElement('article');
    let fullName = document.createElement('h4');
    fullName.textContent = `Name: ${firstNameEl.value} ${lastNameEl.value}`;
    let age = document.createElement('p');
    age.textContent = `Age: ${ageEl.value}`;
    let title = document.createElement('p');
    title.textContent = `Title: ${storyTitleEl.value}`;
    let genre = document.createElement('p');
    genre.textContent = `Genre: ${genreEl.value}`;
    let storyContent = document.createElement('p');
    storyContent.textContent = `${storyEl.value}`;

    articleEl.appendChild(fullName);
    articleEl.appendChild(age);
    articleEl.appendChild(title);
    articleEl.appendChild(genre);
    articleEl.appendChild(storyContent);
    liEl.appendChild(articleEl);

    let saveBtn = document.createElement('button');
    saveBtn.setAttribute('class', 'save-btn');
    saveBtn.textContent = 'Save Story';
    let editBtn = document.createElement('button');
    editBtn.setAttribute('class', 'edit-btn');
    editBtn.textContent = 'Edit Story';
    let deleteBtn = document.createElement('button');
    deleteBtn.setAttribute('class', 'delete-btn');
    deleteBtn.textContent = 'Delete Story';

    liEl.appendChild(saveBtn);
    liEl.appendChild(editBtn);
    liEl.appendChild(deleteBtn);

    previewUlEl.appendChild(liEl);

    let editFirstName = firstNameEl.value;
    let editLastName = lastNameEl.value;
    let editAge = ageEl.value;
    let editStoryTitle = storyTitleEl.value;
    let editStoryContent = storyEl.value;

    
    firstNameEl.value = '';
    lastNameEl.value = '';
    ageEl.value = '';
    storyTitleEl.value = '';
    storyEl.value = '';
    
    publishBtnEl.disabled = true;
    

    saveBtn.addEventListener('click', onSaveHandler);

    function onSaveHandler() {
      mainEl.innerHTML = '';
      let h1El = document.createElement('h1');
      h1El.textContent = 'Your scary story is saved!';
      mainEl.appendChild(h1El);
    }

    editBtn.addEventListener('click', onEditHandler);

    function onEditHandler() {
      firstNameEl.value = editFirstName;
      lastNameEl.value = editLastName;
      ageEl.value = editAge;
      storyTitleEl.value = editStoryTitle;
      storyEl.value = editStoryContent;

      liEl.remove();
      publishBtnEl.disabled = false;
    }

    deleteBtn.addEventListener('click', onDeleteHandler);

    function onDeleteHandler() {
      liEl.remove();
      publishBtnEl.disabled = false;
    }
  }
}
