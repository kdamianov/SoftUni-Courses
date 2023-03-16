function focused() {
    let focusedElements = Array.from(document.querySelectorAll('input[type="text"]'));

    for (let e of focusedElements) {
        e.addEventListener('focus', function () {
            e.parentElement.classList.add('focused');
        })
        e.addEventListener('blur', function () {
            e.parentElement.classList.remove('focused');
        })
    }
}
