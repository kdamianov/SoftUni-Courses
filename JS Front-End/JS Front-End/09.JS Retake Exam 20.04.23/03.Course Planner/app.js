function solve() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';
    const loadBtn = document.getElementById('load-course');
    const divEl = document.getElementById('list');
    const inputTitle = document.getElementById('course-name');
    const inputType = document.getElementById('course-type');
    const inputDescription = document.getElementById('description');
    const inputTeacher = document.getElementById('teacher-name');
    const addCourseBtn = document.getElementById('add-course');
    const editCourseBtn = document.getElementById('edit-course');

    loadBtn.addEventListener('click', onLoadHandler);
    addCourseBtn.addEventListener('click', onAddHandler);

    function onLoadHandler(e) {
        if (e) {
            e.preventDefault();
        }

        fetch(BASE_URL)
            .then((res) => res.json())
            .then((data) => {
                clear();
                const courses = Object.values(data);
                for (const { title, type, description, teacher, _id } of courses) {
                    const courseDiv = document.createElement('div');
                    courseDiv.className = 'container';
                    courseDiv.id = _id;
                    createElement('h2', title, courseDiv);
                    createElement('h3', teacher, courseDiv);
                    createElement('h3', type, courseDiv);
                    createElement('h4', description, courseDiv);
                    createElement('button', 'Edit Course', courseDiv, 'edit-btn');
                    courseDiv.lastChild.addEventListener('click', onEditCourseHandler);
                    createElement('button', 'Finish Course', courseDiv, 'finish-btn');
                    courseDiv.lastChild.addEventListener('click', onFinishHandler);

                    divEl.appendChild(courseDiv);
                }

            })
            .catch((err) => console.error(err))
    }

    function onEditCourseHandler() {
        const parentNode = this.parentNode;
        editCourseBtn.disabled = false;
        addCourseBtn.disabled = true;
        const infoArr = Array.from(parentNode.children);
        inputTitle.value = infoArr[0].textContent;
        inputType.value = infoArr[2].textContent;
        inputDescription.value = infoArr[3].textContent;
        inputTeacher.value = infoArr[1].textContent;
        editCourseBtn.addEventListener('click', onEdit);
        parentNode.remove();

        function onEdit(e) {
            if (e) {
                e.preventDefault();
            }

            const elementID = parentNode.id;
            const httpHeaders = {
                method: 'PUT',
                body: JSON.stringify({
                    description: inputDescription.value,
                    teacher: inputTeacher.value,
                    title: inputTitle.value,
                    type: inputType.value
                })
            }

            fetch(`${BASE_URL}${elementID}`, httpHeaders)
                .then(() => {
                    divEl.innerHTML = '';
                    onLoadHandler()
                    inputTitle.value = '';
                    inputType.value = '';
                    inputDescription.value = '';
                    inputTeacher.value = '';
                })
                .catch((err) => console.error(err))
        }
    }

    function onFinishHandler() {
        const parentNode = this.parentNode;
        const id = this.parentNode.id;

        const httpHEaders = {
            method: "DELETE",
        }

        fetch(`${BASE_URL}${id}`, httpHEaders)
            .then(() => {
                onLoadHandler();
            })
            .catch((err) => console.error(err))
    }
    function onAddHandler(e) {
        if (e) {
            e.preventDefault();
        }
        const title = inputTitle.value;
        const type = inputType.value;
        const description = inputDescription.value;
        const teacher = inputTeacher.value;

        const httpHeaders = {
            method: 'POST',
            body: JSON.stringify({ title, type, description, teacher })
        }

        fetch(BASE_URL, httpHeaders)
            .then(() => {
                divEl.innerHTML = '';
                onLoadHandler()
                inputTitle.value = '';
                inputType.value = '';
                inputDescription.value = '';
                inputTeacher.value = '';

            })
            .catch((err) => console.error(err))

    }

    function createElement(type, content, parentNode, elementClass) {
        const element = document.createElement(type);

        if (elementClass) {
            element.className = elementClass
        }

        if (content && type !== 'input') {
            element.textContent = content;
        }

        if (content && type === 'input') {
            element.value = content;
        }

        if (parentNode) {
            parentNode.appendChild(element);
        }
    }
    function clear() {
        divEl.innerHTML = '';
        inputTitle.value = '';
        inputType.value = '';
        inputDescription.value = '';
        inputTeacher.value = '';
    }
}
solve();



