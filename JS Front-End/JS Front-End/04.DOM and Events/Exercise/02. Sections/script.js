function create(words) {
   const content = document.getElementById('content');
   
   for (const word of words) {
      const newDiv = document.createElement('div');
      const newParagraph = document.createElement('p');
      newParagraph.textContent = word;
      newParagraph.style.display = 'none';
      
      //anonymous function or normal function (both work):
      newDiv.addEventListener('click', ()=> {
         newParagraph.style.display = 'block';
      })

      // attach to DOM tree
      newDiv.appendChild(newParagraph);
      content.appendChild(newDiv);
   }
}