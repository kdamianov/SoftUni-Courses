function colorize() {
    const tableElements = Array.from(document.querySelectorAll('tr:nth-of-type(even)'));
    tableElements.forEach((td) => td.style.backgroundColor = 'teal');
}