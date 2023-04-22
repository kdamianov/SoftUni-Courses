window.addEventListener("load", solve);

function solve() {

    let inputObj = {
        title: document.getElementById('task-title'),
        category: document.getElementById('task-category'),
        content: document.getElementById('task-content')
    }
    console.log(inputObj);
    let otherDOMSelectors = {
        publishBtn: document.getElementById('publish-btn'),
        reviewEl: document.getElementById('review-list'),
        publishedEl: document.getElementById('published-list')
    }

    otherDOMSelectors.publishBtn.addEventListener('click', onPublishHandler);
    function onPublishHandler(e) {

        e.preventDefault();
        const inputFields = Object.values(inputObj).every((element) => element.value !== '');
        if (!inputFields) {
            return;
        }

        let { title, category, content } = inputObj;

        taskInfo = {
            title: title.value,
            category: category.value,
            content: content.value
        }

        const liEl = createHTMLElement('li', otherDOMSelectors.reviewEl, '', ['rpost']);
        const articleEl = createHTMLElement('article', liEl);
        createHTMLElement('h4', articleEl, `${title.value}`);
        createHTMLElement('p', articleEl, `Category: ${category.value}`);
        createHTMLElement('p', articleEl, `Content: ${content.value}`);
        const editBtn = createHTMLElement('button', liEl, 'Edit', ['action-btn', 'edit']);
        const postBtn = createHTMLElement('button', liEl, 'Post', ['action-btn', 'post']);

        editBtn.addEventListener('click', onEditHandler);
        postBtn.addEventListener('click', onPostHandler);
        clear();
        function onEditHandler() {

            let parentEl = this.parentNode;
            for (const key in taskInfo) {
                inputObj[key].value = taskInfo[key];
            }
            parentEl.remove();
        }
        function onPostHandler() {
            const taskToPost = document.querySelector('.rpost');
            let parentEl = document.getElementById('published-list');
            console.log(taskToPost);
            parentEl.appendChild(taskToPost);
            document.querySelector('#published-list > li > button.action-btn.edit').remove();
            document.querySelector('#published-list > li > button.action-btn.post').remove();
        }
        clear();
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
    function clear() {
        inputObj.title.value = '';
        inputObj.category.value = '';
        inputObj.content.value = '';
    }
}