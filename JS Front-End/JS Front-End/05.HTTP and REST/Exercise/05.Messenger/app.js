function attachEvents() {
    const BASE_URL = 'http://localhost:3030/jsonstore/messenger';
    const submitBtn = document.getElementById('submit');
    const refreshBtn = document.getElementById('refresh');
    const textArea = document.getElementById('messages');
    const nameInput = document.querySelector('input[name="author"]');
    const msgInput = document.querySelector('input[name="content"]');

    submitBtn.addEventListener('click', onClick);
    refreshBtn.addEventListener('click', onRefresh);

    function onClick() {
        let messageInfo = {
            author: nameInput.value,
            content: msgInput.value
        }
        fetch(BASE_URL, {
            method: 'POST',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(messageInfo)
        })
            .catch(err => console.error(err))
        nameInput.value = '';
        msgInput.value = '';
    }

    function onRefresh() {
        textArea.textContent = '';
        fetch(BASE_URL)
            .then(response => response.json())
            .then(data => {
                let output = Object.values(data).map((message) => `${message.author}: ${message.content}`).join('\n');
                textArea.textContent = output;
            })
            .catch(err => console.error(err))
    }
}

attachEvents();