const BASE_URL = 'http://localhost:3030/jsonstore/grocery/';
const productNameInput = document.getElementById('product');
const productCountInput = document.getElementById('count');
const productPriceInput = document.getElementById('price');
const addProductsBtn = document.getElementById('add-product');
const updateProductBtn = document.getElementById('update-product');
const loadAllProductsBtn = document.getElementById('load-product');
const tBody = document.getElementById('tbody');

loadAllProductsBtn.addEventListener('click', loadAllProductsHandler);
addProductsBtn.addEventListener('click', addProductHandler);

// Load All Products
function loadAllProductsHandler(e) {
    if (e) {
        e.preventDefault();
    }

    tBody.innerHTML = '';
    emptyAllInputs();
    fetch(BASE_URL)
        .then((res) => res.json())
        .then((data) => {
            const products = Object.values(data);

            for (const { product, count, price, _id } of products) {
                const tr = document.createElement('tr');
                createElement('td', 'name', product, tr);
                createElement('td', 'count-product', count, tr);
                createElement('td', 'product-price', price, tr);
                createElement('td', 'btn', '', tr);
                createElement('button', 'update', 'Update', tr.lastChild);
                tr.lastChild.firstChild.addEventListener('click', updateProductHandler);
                createElement('button', 'delete', 'Delete', tr.lastChild);
                tr.lastChild.lastChild.addEventListener('click', deleteProductHandler);

                tBody.appendChild(tr);
                tr.id = _id;
            }

        })
        .catch((err) => console.log(err))
    addProductsBtn.disabled = false;
    updateProductBtn.disabled = true;
}
// Update product
function updateProductHandler(e) {
    if (e) {
        e.preventDefault();
    }

    const parentNode = this.parentNode.parentNode;
    const tdArr = Array.from(parentNode.children);
    const prodName = tdArr[0].textContent;
    const prodCount = tdArr[1].textContent;
    const prodPrice = tdArr[2].textContent;
    updateProductBtn.disabled = false;

    productNameInput.value = prodName;
    productCountInput.value = prodCount;
    productPriceInput.value = prodPrice;

    addProductsBtn.disabled = true;
    updateProductBtn.addEventListener('click', submitUpdateHandler);

    function submitUpdateHandler(e) {
        if (e) {
            e.preventDefault();
        }
        const id = parentNode.id;
        const httpHeaders = {
            method: 'PATCH',
            body: JSON.stringify({
                product: productNameInput.value,
                count: productCountInput.value,
                price: productPriceInput.value
            })
        }
        fetch(`${BASE_URL}${id}`, httpHeaders)
            .then(() => loadAllProductsHandler())
            .catch((err) => console.error(err))
    }

}
// Delete product
function deleteProductHandler(e) {
    const id = this.parentNode.parentNode.id;
    const httpHEaders = {
        method: "DELETE",
    }

    fetch(`${BASE_URL}${id}`, httpHEaders)
        .then(() => loadAllProductsHandler())
        .catch((err) => console.error(err))
}
// Add product
function addProductHandler(e) {
    if (e) {
        e.preventDefault();
    }
    const product = productNameInput.value;
    const count = productCountInput.value;
    const price = productPriceInput.value;

    const httpHeaders = {
        method: 'POST',
        body: JSON.stringify({ product, count, price })
    };
    fetch(BASE_URL, httpHeaders)
        .then(() => loadAllProductsHandler())
        .catch((err) => console.error(err))
}

function createElement(type, elementClass, content, parentNode) {
    const element = document.createElement(type);

    if (elementClass) {
        element.className = elementClass
    }

    if (content && type !== 'input') {
        element.textContent = content;
    }

    if (content && type === 'input') {
        element.value = content;
    }

    if (parentNode) {
        parentNode.appendChild(element);
    }
}
function emptyAllInputs() {
    productNameInput.value = '';
    productCountInput.value = '';
    productPriceInput.value = '';
}
