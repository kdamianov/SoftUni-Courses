function solve() {
   const addButtons = Array.from(document.getElementsByClassName('add-product'));
   addButtons.forEach((b) => b.addEventListener('click', onClick));

   const checkoutButton = document.getElementsByClassName('checkout')[0];
   checkoutButton.addEventListener('click', checkout);

   const cart = [];
   const output = document.getElementsByTagName('textarea')[0];

   function onClick(e){
      if (e.target.tagName == "BUTTON" && e.target.classList.contains('add-product')) {
         const product = e.target.parentNode.parentNode;
         const productName = product.querySelector('.product-title').textContent;
         const productPrice = Number(product.querySelector('.product-line-price').textContent);
         
         cart.push({
            productName,
            productPrice
         });

         output.value += `Added ${productName} for ${productPrice.toFixed(2)} to the cart.\n`;
      }
   }

   function checkout() {
      const products = new Set();
      cart.forEach((p) => products.add(p.productName));

      const totalPrice = cart.reduce((ttl, currProd) => ttl + currProd.productPrice, 0);

      output.value += `You bought ${[...products.keys()].join(', ')} for ${totalPrice.toFixed(2)}.\n`;
      addButtons.forEach((b) => b.disabled = true);
      checkoutButton.disabled = true;
   }
}
