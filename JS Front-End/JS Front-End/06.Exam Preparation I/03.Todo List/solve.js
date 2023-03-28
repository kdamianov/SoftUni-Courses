
function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';
    const titleInput = document.getElementById('title');
    const addBtn = document.getElementById('add-button');
    const loadBtn = document.getElementById('load-button');
    const todoListContainer = document.getElementById('todo-list');

    loadBtn.addEventListener('click', loadTaskHandler);
    addBtn.addEventListener('click', addTaskHandler)


    //Load
    function loadTaskHandler(e) {
        if (e) {
            e.preventDefault();
        }

        todoListContainer.innerHTML = '';

        fetch(BASE_URL)
            .then((data) => data.json())
            .then((tasksRes) => {
                const tasks = Object.values(tasksRes);

                for (const { _id, name } of tasks) {
                    const li = document.createElement('li');
                    const span = document.createElement('span');
                    const removeBtn = document.createElement('button');
                    const editBtn = document.createElement('button');

                    li.id = _id;
                    span.textContent = name;
                    removeBtn.textContent = 'Remove';
                    removeBtn.addEventListener('click', removeTaskHandler);
                    editBtn.textContent = 'Edit';
                    editBtn.addEventListener('click', loadEditFormHandler);

                    li.append(span, removeBtn, editBtn);
                    todoListContainer.appendChild(li);
                }
            })
            .catch((err) => console.error(err))
    }
    //Edit
    function loadEditFormHandler(e) {
        const liParent = e.currentTarget.parentNode;
        const [span, _removeBtn, editBtn] = Array.from(liParent.children);
        const editInput = document.createElement('input');
        editInput.value = span.textContent;
        liParent.prepend(editInput);
        const submitBtn = document.createElement('button');
        submitBtn.textContent = 'Submit';
        submitBtn.addEventListener('click', submitTaskHandler)
        liParent.appendChild(submitBtn);
        span.remove();
        editBtn.remove();

    }
    //Submit
    function submitTaskHandler(e) {
        const liParent = this.parentNode;
        const id = liParent.id;
        const [input] = Array.from(liParent.children);

        const httpHeaders = {
            method: 'PATCH',
            body: JSON.stringify({ name: input.value })
        }

        fetch(`${BASE_URL}${id}`, httpHeaders)
            .then(() => loadTaskHandler())
            .catch(err => console.error(err))

    }
    //Add
    function addTaskHandler(e) {
        if (e) {
            e.preventDefault();
        }

        const name = titleInput.value;

        const httpHeaders = {
            method: "POST",
            body: JSON.stringify({ name })
        }

        fetch(BASE_URL, httpHeaders)
            .then(() => {
                loadTaskHandler()
                titleInput.value = '';
            })
            .catch((err) => console.error(err))
    }
    //Remove
    function removeTaskHandler(e) {
        const id = this.parentNode.id;
        const httpHEaders = {
            method: "DELETE",
        }

        fetch(`${BASE_URL}${id}`, httpHEaders)
            .then(() => loadTaskHandler())
            .catch((err) => console.error(err))
    }
}

attachEvents();
