window.addEventListener("load", solve);

function solve() {
  const scoreInfo = {
    playerName: null,
    score: null,
    round: null
  }

  const inputDOMSelectors = {
    playerName: document.getElementById('player'),
    score: document.getElementById('score'),
    round: document.getElementById('round')
  }

  const otherDOMSelectors = {
    addBtn: document.getElementById('add-btn'),
    sureList: document.getElementById('sure-list'),
    scoreBoardList: document.getElementById('scoreboard-list'),
    clearBtn: document.querySelector('.clear')
  }
  
  otherDOMSelectors.addBtn.addEventListener('click', onAddHandler);
  otherDOMSelectors.clearBtn.addEventListener('click', () => {
    window.location.reload();
  })

  //Add
  function onAddHandler(e){
    e.preventDefault();

    const allFieldsHaveValue = Object.values(inputDOMSelectors)
      .every((input) => input.value !== '');

    if (!allFieldsHaveValue) {
      return;
    }

    const { playerName, score, round } = inputDOMSelectors;
    const sureList = otherDOMSelectors.sureList;

    let li = createElement('li', sureList, null, ['dart-item']);
    let article = createElement('article', li);
    createElement('p', article, playerName.value);
    createElement('p', article, `Score: ${Number(score.value)}`);
    createElement('r', article, `Round: ${Number(round.value)}`);

    let editBtn = createElement('button', li, 'edit', ['btn', 'edit']);
    let okBtn = createElement('button', li, 'ok', ['btn', 'ok']);

    editBtn.addEventListener('click', onEditHandler);
    okBtn.addEventListener('click', onOkHandler);

    for (const key in inputDOMSelectors) {
      scoreInfo[key] = inputDOMSelectors[key].value;
    }

    clearInputs();
    otherDOMSelectors.addBtn.setAttribute('disabled', true);
    
    //Edit
    function onEditHandler(e) {
      for (const key in inputDOMSelectors) {
        inputDOMSelectors[key].value = scoreInfo[key];
      }

      otherDOMSelectors.addBtn.removeAttribute('disabled');
      otherDOMSelectors.sureList.innerHTML = '';
    }

    //OK
    function onOkHandler(e) {
      editBtn.remove();
      okBtn.remove();
      otherDOMSelectors.scoreBoardList.appendChild(li);
      otherDOMSelectors.addBtn.removeAttribute('disabled');
    }
  }

  

  function clearInputs() {
    Object.values(inputDOMSelectors)
      .forEach((input) => {
        input.value = '';
      })
  }
  function createElement(type, parentNode, content, classes, id, attributes, useInnerHtml) {
    let htmlElement = document.createElement(type);

    if (content && useInnerHtml) {
      htmlElement.innerHTML = content;
    } else {
      if (content && type !== 'input') {
        htmlElement.textContent = content;
      } else if (content && type === 'input') {
        htmlElement.value = content;
      }
    }

    if (classes && classes.length > 0) {
      htmlElement.classList.add(...classes);
    }

    if (id) {
      htmlElement.id = id;
    }
    // {scr: 'link', href: 'http'} 
    if (attributes) {
      for (const key in attributes) {
        htmlElement.setAttribute(key, attributes[key]);
      }
    }

    if (parentNode) {
      parentNode.appendChild(htmlElement);
    }

    return htmlElement;
  }
}
