function attachGradientEvents() {
    const gradientElement = document.getElementById('gradient');
    const resultElement = document.getElementById('result');
    gradientElement.addEventListener('mousemove', mouseOverHandler);

    function mouseOverHandler(e) {
        const percent = Number(Math.floor((e.offsetX / e.target.clientWidth) * 100));

        resultElement.textContent = percent + '%';

    }
}

// e.target.clientWidth - дължина на дадения елемент
// e.offsetX - разстояние от началото на елемента