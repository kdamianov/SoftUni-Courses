function solve() {
    const BASE_URL = 'http://localhost:3030/jsonstore/tasks/';

    const location = document.getElementById('location');
    const temperature = document.getElementById('temperature');
    const date = document.getElementById('date');

    const citiesList = document.getElementById('list');
    const addWeatherBtn = document.getElementById('add-weather');
    const editWeatherBtn = document.getElementById('edit-weather');
    const loadBtn = document.getElementById('load-history');

    loadBtn.addEventListener('click', onLoadHandler);
    addWeatherBtn.addEventListener('click', onAddHandler);

    async function onLoadHandler() {
        
        clearAll();
        try {
            const res = await fetch(BASE_URL);
            const allCities = await res.json();
            for (const { location, temperature, date, _id} of Object.values(allCities)) {
                const cityContainer = createElement('div', citiesList, null, ['container']);
                cityContainer.id = _id;
                createElement('h2', cityContainer, location);
                createElement('h3', cityContainer, date);
                createElement('h3', cityContainer, temperature, null, 'celsius');
                const btnContainer = createElement('div', cityContainer, null, ['buttons-container']);
                createElement('button', btnContainer, 'Change', ['change-btn']);
                btnContainer.lastChild.addEventListener('click',onChangeHandler)
                createElement('button', btnContainer, 'Delete', ['delete-btn']);
                btnContainer.lastChild.addEventListener('click',onDelete)

            }
        } catch (err) {
            console.error(err);
        }
        editWeatherBtn.disabled = true;
        addWeatherBtn.disabled = false;
    }
    
    function onChangeHandler(e) {
        const parentNode = this.parentNode.parentNode;
        editWeatherBtn.disabled = false;
        addWeatherBtn.disabled = true;
        const infoArr = Array.from(parentNode.children);
        location.value = infoArr[0].textContent;
        temperature.value = infoArr[2].textContent;
        date.value = infoArr[1].textContent;

        editWeatherBtn.addEventListener('click', onEditHandler);
        parentNode.remove();

        function onEditHandler(e) {
            if (e) {
                e.preventDefault();
            }
            const elementID = parentNode.id;
            const httpHeaders = {
                method: 'PUT',
                body: JSON.stringify({
                    location: location.value,
                    temperature: temperature.value,
                    date: date.value
                })
            }
            fetch(`${BASE_URL}${elementID}`, httpHeaders)
                .then(() => {
                    clearAll();
                    onLoadHandler()
                })
                .catch((err) => console.error(err))
        }

    }
    //ADD
    function onAddHandler(e) {

        e.preventDefault();

        const headers = {
            method: 'POST',
            body: JSON.stringify({
                location: location.value,
                temperature: temperature.value,
                date: date.value
            })
        };

        fetch(BASE_URL, headers)
            .then(onLoadHandler)
            .catch(console.error);

        clearAll();

    }

    function onDelete(e) {
        const id = this.parentNode.parentNode.id;
        const httpHEaders = {
            method: "DELETE",
        }
        fetch(`${BASE_URL}${id}`, httpHEaders)
            .then(() => {
                onLoadHandler();
            })
            .catch((err) => console.error(err))
    }

    function clearAll() {
        citiesList.innerHTML = '';
        location.value = '';
        temperature.value = '';
        date.value = '';
    }
    function createElement(type, parentNode, content, classes, id, attributes, useInnerHtml) {
        let htmlElement = document.createElement(type);

        if (content && useInnerHtml) {
            htmlElement.innerHTML = content;
        } else {
            if (content && type !== 'input') {
                htmlElement.textContent = content;
            } else if (content && type === 'input') {
                htmlElement.value = content;
            }
        }

        if (classes && classes.length > 0) {
            htmlElement.classList.add(...classes);
        }

        if (id) {
            htmlElement.id = id;
        }
        // {scr: 'link', href: 'http'} 
        if (attributes) {
            for (const key in attributes) {
                htmlElement.setAttribute(key, attributes[key]);
            }
        }

        if (parentNode) {
            parentNode.appendChild(htmlElement);
        }

        return htmlElement;
    }
}

solve();
