function deleteByEmail() {
    const result = document.getElementById('result');
    const input = document.querySelector('input[name = "email"]');  // селектира по такъв селектор, чиито атрибут е "email"!
    const evenTds = Array.from(document.querySelectorAll('td:nth-child(even)'));
    let emailValue = input.value;

    let foundElement = evenTds.find((td) => td.textContent === emailValue);

    if (foundElement) {
        result.textContent = 'Deleted.';
        foundElement.parentElement.remove(); //може и с .parentNode
    } else {
        result.textContent = 'Not found.';
    }
}