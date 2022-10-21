window.addEventListener("keyup", event => {
    if (event.key === "Enter" && event.target.id === 'theSearchBar') {
        localStorage.setItem('textoBuscar', event.target.value.toLowerCase());
        window.location.assign("../pages/catalogo.html");
    }
})

function filtroPerro() {
    localStorage.setItem("textoBuscar", "perro");
    location.href="../pages/catalogo.html"
}

function filtroGato() {
    localStorage.setItem("textoBuscar", "gato");
    location.href="../pages/catalogo.html"
}

function filtroAccesorios() {
    localStorage.setItem("textoBuscar", "accesorios");
    location.href="../pages/catalogo.html"
}

function filtroJuguetes() {
    localStorage.setItem("textoBuscar", "juguetes");
    location.href="../pages/catalogo.html"
}

function filtroAlimento() {
    localStorage.setItem("textoBuscar", "alimento");
    location.href="../pages/catalogo.html"
}

function filtroLimpieza() {
    localStorage.setItem("textoBuscar", "limpieza");
    location.href="../pages/catalogo.html"
}
