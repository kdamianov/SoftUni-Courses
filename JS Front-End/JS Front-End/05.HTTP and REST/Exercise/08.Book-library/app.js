function attachEvents() {
  const loadBooks = document.getElementById('loadBooks');
  const booksContainer = document.querySelector('table > tbody');
  const [titleInput, authorInput] = Array.from(document.querySelectorAll('#form > input'));
  const submitBtn = document.querySelector('#form > button');
  const formHeader = document.querySelector('#form > h3');

  let allBooks = {};
  let editBookID = null;
  const BASE_URL = 'http://localhost:3030/jsonstore/collections/books/';

  loadBooks.addEventListener('click', loadAllBooksHandler);
  submitBtn.addEventListener('click', submitFormHandler);

  async function loadAllBooksHandler() {
    booksContainer.innerHTML = '';
    const booksResponse = await fetch(BASE_URL);
    const booksData = await booksResponse.json();

    allBooks = booksData;
    for (const bookID in booksData) {
      const { author, title } = booksData[bookID];
      const tableRow = document.createElement('tr');
      const titleColumn = document.createElement('td');
      titleColumn.textContent = title;
      tableRow.appendChild(titleColumn);
      const authorColumn = document.createElement('td');
      authorColumn.textContent = author;
      tableRow.appendChild(authorColumn);
      const buttonsColumn = document.createElement('td');
      const editBtn = document.createElement('button');
      editBtn.textContent = 'Edit';
      const deleteBtn = document.createElement('button');
      deleteBtn.textContent = 'Delete';
      deleteBtn.id = bookID;

      editBtn.addEventListener('click', () => {
        editBookID = bookID;
        formHeader.textContent = 'Edit FORM';
        submitBtn.textContent = 'Save';
        titleInput.value = title;
        authorInput.value = author;
      });

      deleteBtn.addEventListener('click', deleteBookHandler);

      buttonsColumn.appendChild(editBtn);
      buttonsColumn.appendChild(deleteBtn);
      tableRow.appendChild(buttonsColumn);

      booksContainer.appendChild(tableRow);

    }
  }

  async function submitFormHandler(event) {
    const title = titleInput.value;
    const author = authorInput.value;

    const httpHeaders = {
      method: 'POST',
      body: JSON.stringify({ title, author })
    }

    let url = BASE_URL;

    if (formHeader.textContent === 'Edit FORM') {
      httpHeaders.method = 'PUT';
      url += editBookID;
    }
    const responseData = await fetch(url, httpHeaders);
    loadAllBooksHandler();

    if (formHeader.textContent === 'Edit FORM') {
      formHeader.textContent = 'FORM';
      submitBtn.textContent = 'Submit';
    }

    titleInput.value = '';
    authorInput.value = '';
  }

  async function deleteBookHandler() {
    const id = this.id;
    const httpHeaders = {
      method: 'DELETE'
    };

    await fetch(BASE_URL + id, httpHeaders);
    loadAllBooksHandler();
  }
}

attachEvents();