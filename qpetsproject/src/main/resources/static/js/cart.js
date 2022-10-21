let contenido = document.getElementById("contenido");
let totalCarrito = 0.0;
let filtroEliminar = [];
let filtroSobrante = [];

window.addEventListener("load", function (event) {
    traer();
})

document.getElementById("card").addEventListener("click", function (event){
    deleteProduct(event.target);
})

function traer() {
    fetch('../src/json/productos.json')
        .then(res => res.json())
        .then(datos => {
         let filtroCarrito = localStorage.getItem('cartIds').split(",");
            filtroCarrito.forEach(id => {
                datos.forEach(dato => {
                    if (dato.id == id) {
                        contenido.innerHTML += `
                        <tr>
                            <th scope="row" id="info"><img src="${dato.img}" alt="${dato.name}" 
                            style="width: 100px; height: 100px;"></th>
                            <td id="info">${dato.name}</td>
                            <td id="info">$${parseFloat(dato.price).toFixed(2)}</td>
                            
                            <td> <a class="btn"><img class="bote" id="${dato.id}" src="../src/images/carrito/trash3-fill.svg" alt="" name="borrarcar"></a></td>
                        </tr>
                        `;
                        totalCarrito += parseFloat(dato.price);
                    }
                    document.getElementById("totalCarrito").innerHTML =
                    `<i class="bi bi-cart-check-fill"></i> Total: $${totalCarrito.toFixed(2)}`
                })
            })
        })
}

function deleteProduct(element) {
    fetch('../src/json/productos.json')
        .then(res => res.json())
        .then(datos => {
            if (element.name === "borrarcar") {
                filtroEliminar = localStorage.getItem('cartIds').split(",")
                    .filter(item => parseInt(item) != element.id);
                filtroSobrante = localStorage.getItem('cartIds').split(",")
                    .filter(item => parseInt(item) == element.id);
                filtroSobrante.forEach(id => {
                    datos.forEach(dato => {
                        if (dato.id == id) {
                            totalCarrito -= parseFloat(dato.price);
                        }
                document.getElementById("totalCarrito").innerHTML =
                `<i class="bi bi-cart-check-fill"></i> Total: $${totalCarrito.toFixed(2)}`
                localStorage.setItem('cartIds', filtroEliminar);
                element.parentElement.parentElement.parentElement.remove();
            })
        })
                
            }
        })
}