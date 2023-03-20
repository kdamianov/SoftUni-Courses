function encodeAndDecodeMessages() {
    let buttons = Array.from(document.getElementsByTagName('button'));
    buttons[0].addEventListener('click', encodeAndSend);
    buttons[1].addEventListener('click', decodeAndRead);
    let textAreas = document.querySelectorAll('textarea');

    function encodeAndSend(e) {
        let message = Array.from(e.target.parentElement.children[1].value);
        let encodedMessage = '';
        message.forEach(ch => {
            let currentChar = ch.charCodeAt();
            encodedMessage += String.fromCharCode(currentChar + 1);
        });
        
        textAreas[1].value = encodedMessage;
        textAreas[0].value = '';

    }

    function decodeAndRead(e) {
        let encodedMessage = Array.from(e.target.parentElement.children[1].value);
        let decodedMessage = '';
        encodedMessage.forEach(ch => {
            let currentChar = ch.charCodeAt();
            decodedMessage += String.fromCharCode(currentChar - 1);
        });

        textAreas[1].value = decodedMessage;
    }
}