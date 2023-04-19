// TODO:
function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';
    const loadBtn = document.getElementById('load-board-btn');
    const addBtn = document.getElementById('create-task-btn');
    const taskTitle = document.getElementById('title');
    const taskDescription = document.getElementById('description');
    const toDoSection = document.querySelector('#todo-section .task-list');
    const inProgressSection = document.querySelector('#in-progress-section .task-list');
    const codeReviewSection = document.querySelector('#code-review-section .task-list');
    const doneSection = document.querySelector('#done-section .task-list');

    loadBtn.addEventListener('click', loadHandler);
    addBtn.addEventListener('click', addHandler);
    const dataStatuses = {};

    function loadHandler() {
        toDoSection.innerHTML = '';
        inProgressSection.innerHTML = '';
        codeReviewSection.innerHTML = '';
        doneSection.innerHTML = '';


        fetch(BASE_URL)
            .then((response) => response.json())
            .then((data) => {
                const tasks = Object.values(data);

                for (const task of tasks) {
                    dataStatuses[task._id] = task.status;
                    let liEl = createHTMLElement('li', '', '', ['task']);
                    createHTMLElement('h3', liEl, task.title);
                    createHTMLElement('p', liEl, task.description);
                    let button = '';

                    switch (task.status) {
                        case 'ToDo':
                            button = createHTMLElement('button', liEl, 'Move to In Progress');
                            button.addEventListener('click', moveHandler)
                            button.id = task._id;
                            document.querySelector('#todo-section > ul').appendChild(liEl);
                            break;
                        case 'In Progress':
                            button = createHTMLElement('button', liEl, 'Move to Code Review');
                            button.id = task._id;
                            button.addEventListener('click', moveHandler)
                            document.querySelector('#in-progress-section > ul').appendChild(liEl);

                            break;
                        case 'Code Review':
                            button = createHTMLElement('button', liEl, 'Move to Done');
                            button.id = task._id;
                            button.addEventListener('click', moveHandler)
                            document.querySelector('#code-review-section > ul').appendChild(liEl);
                            break;
                        case 'Done':
                            button = createHTMLElement('button', liEl, 'Close');
                            button.id = task._id;
                            button.addEventListener('click', deleteHandler);
                            document.querySelector('#done-section > ul').appendChild(liEl);
                            break;
                    }

                }
                console.log(dataStatuses);
            })
            .catch(err => console.error(err))

    }
    function addHandler(e) {
        if (e) {
            e.preventDefault();
        }
        let data = {
            "title": taskTitle.value,
            "description": taskDescription.value,
            "status": "ToDo"
        };
        fetch(BASE_URL, {
            method: 'POST',
            body: JSON.stringify(data)
        })
            .then(() => loadHandler(), taskTitle.value = '', taskDescription.value = '')
            .catch(err => console.error(err))
    }
    function moveHandler(e) {
        let id = this.id;
        let currStatus = dataStatuses[id];
        let newStatus = '';

        if (currStatus === 'ToDo') {
            newStatus = 'In Progress';
        } else if (currStatus === 'In Progress') {
            newStatus = 'Code Review';
        } else if (currStatus === 'Code Review') {
            newStatus = 'Done';
        }

        fetch(`${BASE_URL}${id}`, {
            method: 'PATCH',
            body: JSON.stringify({ "status": newStatus })
        })
            .then(loadHandler)
            .catch((err) => console.error(err));
    }
    function deleteHandler() {
        let id = this.id;
        fetch(BASE_URL + id, {
            method: 'DELETE'
        })
            .then(() => loadHandler())
            .catch((err) => console.error(err));

    }



    function createHTMLElement(type, parentNode, content, classes, id, attributes, useInnerHtml) {
        const htmlElement = document.createElement(type);

        if (content && useInnerHtml) {
            htmlElement.innerHTML = content;
        } else {
            if (content && type !== 'input') {
                htmlElement.textContent = content;
            }

            if (content && type === 'input') {
                htmlElement.value = content;
            }
        }

        if (classes && classes.length > 0) {
            htmlElement.classList.add(...classes);
        }

        if (id) {
            htmlElement.id = id;
        }

        // { src: 'link', href: 'http' }
        if (attributes) {
            for (const key in attributes) {
                htmlElement.setAttribute(key, attributes[key])
            }
        }

        if (parentNode) {
            parentNode.appendChild(htmlElement);
        }

        return htmlElement;
    }
}

attachEvents();