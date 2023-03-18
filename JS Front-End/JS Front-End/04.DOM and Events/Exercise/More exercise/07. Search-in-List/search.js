function search() {
   let townsArr = Array.from(document.querySelectorAll('ul li'));
   let searchedTown = document.getElementById('searchText').value;
   let matchesCount = 0;

   for (const town of townsArr) {
      let townName = town.textContent;

      if (townName.includes(searchedTown)) {
         town.style.textDecoration = 'underline';
         town.style.fontWeight = 'bold';
         matchesCount ++;
      }
   }
   document.getElementById('result').textContent = `${matchesCount} matches found`;
}
