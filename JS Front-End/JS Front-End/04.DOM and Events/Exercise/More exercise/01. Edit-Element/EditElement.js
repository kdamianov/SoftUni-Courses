function editElement(...arr) {
    const element = arr[0];
    const match = String(arr[1]);
    const replacer = String(arr[2]);

    while (element.textContent.includes(match)){
        element.textContent = element.textContent.replace(match, replacer);
    }
}