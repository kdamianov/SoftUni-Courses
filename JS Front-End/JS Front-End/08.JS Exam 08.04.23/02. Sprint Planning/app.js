window.addEventListener('load', solve);

function solve() {
    let inputObj = {
        title: document.getElementById('title'),
        description: document.getElementById('description'),
        label: document.getElementById('label'),
        estimationPoints: document.getElementById('points'),
        assignee: document.getElementById('assignee'),
        ID: ''
    }

    let otherDOMSelectors = {
        createBtn: document.getElementById('create-task-btn'),
        deleteBtn: document.getElementById('delete-task-btn'),
        taskSection: document.getElementById('tasks-section'),
        totalPts: document.getElementById('total-sprint-points'),
        taskID: document.getElementById('task-id')
    }

    otherDOMSelectors.createBtn.addEventListener('click', onCreateHandler);

    let taskInfo = {};

    taskID = 0;
    let totalPoints = 0;

    function onCreateHandler(e) {

        e.preventDefault();

        const inputFields = Object.values(inputObj).every((element) => element.value !== '');
        if (!inputFields) {
            return;
        }

        let { title, description, label, estimationPoints, assignee } = inputObj;

        taskID++;

        taskInfo = {
            title: title.value,
            description: description.value,
            label: label.value,
            estimationPoints: estimationPoints.value,
            assignee: assignee.value,
            ID: `task-${taskID}`
        }

        totalPoints += Number(taskInfo.estimationPoints);

        const articleEl = createHTMLElement('article', otherDOMSelectors.taskSection, '', ['task-card'], taskInfo.ID);
        let taskCardLabel = '';
        switch (taskInfo.label) {
            case 'Feature':
                taskCardLabel = createHTMLElement('div', articleEl, '', ['task-card-label', 'feature']);
                taskCardLabel.innerHTML = 'Feature &#8865';
                break;
            case 'Low Priority Bug':
                taskCardLabel = createHTMLElement('div', articleEl, '', ['task-card-label', 'low-priority']);
                taskCardLabel.innerHTML = 'Low Priority Bug &#9737';
                break;
            case 'High Priority Bug':
                taskCardLabel = createHTMLElement('div', articleEl, '', ['task-card-label', 'high-priority']);
                taskCardLabel.innerHTML = 'High Priority Bug &#9888';
                break;
        }
        createHTMLElement('h3', articleEl, `${title.value}`, ['task-card-title']);
        createHTMLElement('p', articleEl, `${description.value}`, ['task-card-description']);
        createHTMLElement('div', articleEl, `Estimated at ${Number(estimationPoints.value)} pts`, ['task-card-points']);
        createHTMLElement('div', articleEl, `Assigned to: ${assignee.value}`, ['task-card-assignee']);
        let taskCardActions = createHTMLElement('div', articleEl, '', ['task-card-actions']);
        let deleteBtn = createHTMLElement('button', taskCardActions, 'Delete');
        deleteBtn.addEventListener('click', onDeleteHandler);
        otherDOMSelectors.totalPts.textContent = `Total Points ${totalPoints}pts`;
        clear();

        function onDeleteHandler() {

            let parentEl = this.parentNode.parentNode;
            otherDOMSelectors.taskID.value = parentEl.id;
            otherDOMSelectors.createBtn.disabled = true;
            for (const key in taskInfo) {
                inputObj[key].value = taskInfo[key];
                inputObj[key].disabled = true;
            }
            otherDOMSelectors.deleteBtn.disabled = false;
            totalPoints -= Number(inputObj.estimationPoints.value);
            otherDOMSelectors.totalPts.textContent = `Total Points ${totalPoints}pts`;
            parentEl.remove();

        }
        otherDOMSelectors.deleteBtn.addEventListener('click', onClearTaskHandler);

        function onClearTaskHandler() {
            clear();
            for (const key in inputObj) {
                
                inputObj[key].disabled = false;
            }
            otherDOMSelectors.taskID.removeAttribute('value');
            otherDOMSelectors.deleteBtn.disabled = true;
            otherDOMSelectors.createBtn.disabled = false;
        }

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
        inputObj.description.value = '';
        inputObj.label.value = '';
        inputObj.estimationPoints.value = '';
        inputObj.assignee.value = '';
    }
}

//         taskInfo = {
//             taskID: taskID.value,
//             title: title.value,
//             description: description.value,
//             label: label.value,
//             estimationPoints: estimationPoints.value,
//             assignee: assignee.value
//         }

//         let totalPoints = 0;
//         totalPoints += Number(estimationPoints.value);
//         taskID = 1;
//         taskID++;

//         const articleEl = createHTMLElement('article', otherDOMSelectors.tasksSection, '', ['task-card'], `task-${taskID}`);
//         let taskCardLabel = createHTMLElement('div', articleEl);
//         if (label.value === 'Feature') {
//             taskCardLabel.innerHTML = `<div class="task-card-label feature">Feature ${featureIcon}</div>`;
//         } else if (label.value === 'Low Priority Bug') {
//             taskCardLabel.innerHTML = `<div class="task-card-label low-priority">Low Priority Bug ${lowPriorityIcon}</div>`;
//         } else if (label.value === 'High Priority Bug') {
//             taskCardLabel.innerHTML = `<div class="task-card-label high-priority">High Priority Bug ${highPriorityIcon}</div>`;

//         }
//         createHTMLElement('h3', articleEl, `${title.value}`, ['task-card-title']);
//         createHTMLElement('p', articleEl, `${description.value}`, ['task-card-description']);
//         createHTMLElement('div', articleEl, `Estimated at ${Number(estimationPoints.value)}`, ['task-card-points']);
//         createHTMLElement('div', articleEl, `Assigned to: ${assignee.value}`, ['task-card-assignee']);
//         let taskCardActions = createHTMLElement('div', articleEl, '', ['task-card-actions']);
//         let deleteBtn = createHTMLElement('button', taskCardActions, 'Delete');

//         otherDOMSelectors.totalSprintPoints.value = `Total Points ${totalPoints}pts`;
//         deleteBtn.addEventListener('click', onDeleteHandler);

//         clear();

//         function onDeleteHandler() {
//             otherDOMSelectors.createBtn.setAttribute('disabled', true);
//             articleEl.remove();
//             for (const key in taskInfo) {
//                 inputObj[key].value = taskInfo[key];
//                 inputObj[key].disabled = true;
//             }

//             otherDOMSelectors.deleteBtn.disabled = false;
//             otherDOMSelectors.deleteBtn.addEventListener('click', clear);
//             totalPoints -= taskInfo.estimationPoints.value;
//         }


//     }



//     function createHTMLElement(type, parentNode, content, classes, id, attributes, useInnerHtml) {
//         const htmlElement = document.createElement(type);

//         if (content && useInnerHtml) {
//             htmlElement.innerHTML = content;
//         } else {
//             if (content && type !== 'input') {
//                 htmlElement.textContent = content;
//             }

//             if (content && type === 'input') {
//                 htmlElement.value = content;
//             }
//         }

//         if (classes && classes.length > 0) {
//             htmlElement.classList.add(...classes);
//         }

//         if (id) {
//             htmlElement.id = id;
//         }

//         // { src: 'link', href: 'http' }
//         if (attributes) {
//             for (const key in attributes) {
//                 htmlElement.setAttribute(key, attributes[key])
//             }
//         }

//         if (parentNode) {
//             parentNode.appendChild(htmlElement);
//         }

//         return htmlElement;
//     }
//     function clear() {
//         Object.values(inputObj).forEach((input) => (input.value = ''));
//     }