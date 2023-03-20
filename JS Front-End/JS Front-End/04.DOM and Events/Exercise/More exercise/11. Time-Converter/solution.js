function attachEventsListeners() {

    let buttons = Array.from(document.querySelectorAll('input[type="button"]'));
    buttons.forEach(b => b.addEventListener('click', convert));

    function convert(e) {
        let input = Number(e.target.parentElement.querySelector('input[type="text"]').value);
        let unit = e.target.id;

        switch (unit) {
            case 'daysBtn':
                fillInput(input);
                break;
            case 'hoursBtn':
                fillInput(input / 24);
                break;
            case 'minutesBtn':
                fillInput(input / 1440);
                break;
            case 'secondsBtn':
                fillInput(input / 86400);
                break;
        }
    }

    function fillInput(value) {
        let inputFields = Array.from(document.querySelectorAll('input[type="text"]'));
        inputFields.shift().value = value;
        let currentValue = value * 24;
        inputFields.forEach(f => {
            f.value = currentValue;
            currentValue *= 60;
        });
    }
}