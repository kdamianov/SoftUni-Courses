function solve() {
    
    let input = document.getElementById('input');
    let result = document.getElementById('result');
    let selectMenuTo = document.getElementById('selectMenuTo');
    let toBinary = document.createElement('option');
    toBinary.value = 'binary';
    toBinary.textContent = 'Binary';
    selectMenuTo.appendChild(toBinary);
    let toHexadecimal = document.createElement('option');
    toHexadecimal.value = 'hexadecimal';
    toHexadecimal.textContent = 'Hexadecimal';
    selectMenuTo.appendChild(toHexadecimal);

    document.getElementsByTagName('button')[0].addEventListener('click', convert);

    function convert() {
        if (selectMenuTo.value === 'binary') {
            result.value = Number(input.value).toString(2);
        } else if (selectMenuTo.value === 'hexadecimal') {
            result.value = Number(input.value).toString(16).toUpperCase();
        }
    }
    
}
