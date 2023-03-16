function subtract() {
    let firstNum = document.getElementById('firstNumber');
    let firstNumValue = Number(firstNum.value);
    let secondNum = document.getElementById('secondNumber');
    let secondNumValue = Number(secondNum.value);


    let result = firstNumValue - secondNumValue;
    let resultElement = document.getElementById('result');
    resultElement.textContent = result;
}

function subtract() {
    let firstNumber = document.getElementById('firstNumber');
    let firstNumAsNumber = Number(firstNumber.value);
    let secondNumber = document.getElementById('secondNumber');
    let secondNumAsNumber = Number(secondNumber.value)

    let result = firstNumAsNumber - secondNumAsNumber;
    let resultElement = document.getElementById('result');
    resultElement.textContent = result
  
}