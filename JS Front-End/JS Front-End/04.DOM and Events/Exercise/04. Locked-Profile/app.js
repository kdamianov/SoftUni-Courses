function lockedProfile() {
    const buttons = Array.from(document.getElementsByTagName('button'));

    buttons.forEach((button) => {
        button.addEventListener('click', toggleInformation);
    });

    function toggleInformation(e) {
        const btn = e.currentTarget;
        const currentProfile = btn.parentElement;
        const children = Array.from(currentProfile.children);
        const unlockRadioInput = children[4];
        const addInfoDiv = children[9];

        if (unlockRadioInput.checked) {
            if (btn.textContent === 'Show more') {
                addInfoDiv.style.display = 'block';
                btn.textContent = 'Hide it';
            } else {
                addInfoDiv.style.display = 'none';
                btn.textContent = 'Show more';
            }
        }
    }
}