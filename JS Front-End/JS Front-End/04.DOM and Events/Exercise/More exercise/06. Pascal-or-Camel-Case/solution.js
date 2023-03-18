function solve() {
  let input = document.getElementById('text').value;
  let currentCase = document.getElementById('naming-convention').value;
  let textArr = input.split(' ');
  let result = '';

  switch (currentCase) {
    case 'Camel Case':
      textArr.forEach((e, i) => {
        if (i === 0) {
          return result += e.toLowerCase();
        } else {
          return result += e[0].toUpperCase() + e.substring(1).toLowerCase();
        }
      });
      break;
    case 'Pascal Case':
      textArr.forEach((e, i) => {
        e = e.toLowerCase();
        return result += e[0].toUpperCase() + e.substring(1);
      });
      break;
    default:
      result = 'Error!';
      break;
  }
  document.getElementById('result').textContent = result;
}