setHeader = document.getElementsByTagName("header");
setFooter = document.getElementsByTagName("footer");

window.addEventListener("load", function (e) {
    setHeader[0].innerHTML += `
    <header class="header">
    <div class="navInf">
      <nav class="navbar navbar-expand-xl navbar-light" style="background-color:#6F1D1B">
        <a class="navbar-brand mr-5" href="../index.html"><img src="../src/images/Logo.jpeg" alt="Logo Q-Pets" class="logoHeader"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
          aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav mx-auto navInfLink">
            <a class="nav-item nav-link mx-auto menuLink" href="./catalogo.html" style="color:white">Catálogo</a>
            <a class="nav-item nav-link mx-auto menuLink" href="./about.html" style="color:white">Acerca de nosotros</a>
            <a class="nav-item nav-link mx-auto menuLink" href="./contacto.html" style="color:white">Contacto</a>
            <a class="nav-item nav-link mx-auto menuLink" href="./login.html" tabindex="-1" aria-disabled="true"
              style="color:white">Iniciar sesión</a>
          </div>
          <div class="form-inline justify-content-center">
          <div>
            <input id="theSearchBar" class="form-control" type="search" placeholder="Buscar producto..." aria-label="Search">
          </div>
          <div>
            <a class="button" href="./cart.html"><img src="../src/images/Cart.png" alt="Carrito" style="height:30px;margin-left:10px"></a>
            <a class="button" href="./login.html"><img src="../src/images/User.png" alt="Iniciar sesión" style="height:30px;margin-left:10px;"></a>
          </div>
        </div>
        </div>
      </nav>
    </div>
  </header>
`;
    setFooter[0].innerHTML += `
    <div class="container-fluid" id="topFooter" style="padding-top: 20px;">
        <div class="row no-gutters" style="padding: 0px;">
            <div style="padding: 20px;" class="col-md-4 text-md-left text-center">
                <a href="../index.html"><img class="rounded float-center" src="../src/images/footer/logoQPets.jpg" alt="Logo de Q-Pets" width="220px"></a>
                <br/>
                <br/>
                <a href="#"><img class="float-center imgRedes" style="padding: 5px;" src="../src/images/footer/iconoFacebook.png" height="48px" alt="Logo de Facebook"></a>
                <a href="#"><img class="float-center imgRedes" style="padding: 5px;" src="../src/images/footer/iconoInstagram.png" height="48px" alt="Logo de Instagram"></a>
                <a href="#"><img class="float-center imgRedes" style="padding: 5px;" src="../src/images/footer/iconoTwitter.png" height="48px" alt="Logo de Twitter"></a>
                <a href="#"><img class="float-center imgRedes" style="padding: 5px;" src="../src/images/footer/iconoWhatsapp.png" height="48px" alt="Logo de Whatsapp"></a> 
            </div>
            <div class="col-md-3 text-md-left text-center">
                <ul class="list-unstyled">
                <li>
                    <strong>Atención al cliente</strong>
                </li>
                <br/>
                <li><a href="../pages/terms.html">Forma de pago</a></li>
                <li><a href="../pages/terms.html">Términos y condiciones</a></li>
                <li><a href="../pages/terms.html">Preguntas frecuentes</a></li>
                <li><a href="../pages/terms.html">Políticas de devolución y envío</a></li>
                </ul>
            </div>
            <div class="col-md-2 text-md-left text-center">
                <ul class="list-unstyled">
                <li><strong>Compra</strong></li><br />
                <li><strong>Perro</strong></li>
                <li><a href="../pages/catalogo.html" onclick="filtroPerro()">Alimento</a></li>
                <li><a href="../pages/catalogo.html" onclick="filtroPerro()">Accesorios</a></li>
                <br />
                <li><strong>Gato</strong></li>
                <li><a href="../pages/catalogo.html" onclick="filtroGato()">Alimento</a></li>
                <li><a href="../pages/catalogo.html" onclick="filtroGato()">Accesorios</a></li>
            </ul>
            </div>
            <div class="col-md-3 text-md-left text-center">
                <ul class="list-unstyled">
                    <li>
                        <a href="../pages/contacto.html"><strong>Contacto</strong></a>
                    </li>
                    <br />
                    <li>Correo electrónico:</li>
                    <li>email@qpets.com.mx</li>
                    <br>
                    <li>Teléfono</li>
                    <li>+52 XX XXX XXX</li>
                    <img style="padding: 4px; padding-bottom: 6px;" class="mt-1" src="../src/images/footer/iconoMC.png" alt="Logo Master Card" height="48px">
                    <img style="padding: 5px;" src="../src/images/footer/iconoAmEx.png" alt="Logo American Express" height="48px">
                    <img style="padding: 5px;" src="../src/images/footer/iconoTarjeta.png" height="48px" alt="Icono de tarjeta">
                </ul>
            </div>
        </div>
    </div>
    <div class="container-fluid" id="bottomFooter">
        <div class="row" style="padding-bottom: 10px;">
            <div class="col-2"><img class="float-left" src="../src/images/footer/roedor.png" alt="Imagen de ratón" width="48px"></div>
            <div class="col-8 text-center">Copyright © 2022. Q-Pets. Todos los derechos reservados.</div>
            <div class="col-2 "><img class="float-right" src="../src/images/footer/huellita.png" alt="Imagen de huellita" height="36px"></div>
        </div>
    </div>
    `;
})

window.addEventListener("keyup", event =>{
  if(event.key === "Enter" && event.target.id === 'theSearchBar'){
    localStorage.setItem('textoBuscar', event.target.value.toLowerCase());
    window.location.assign("../pages/catalogo.html");
  }
})