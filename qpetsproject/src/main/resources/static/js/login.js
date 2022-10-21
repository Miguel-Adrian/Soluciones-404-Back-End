addEventListener("submit", function (e) {
    e.preventDefault();

		 /*---------------Lee del formulario y compara con la base---------------*/
         		let email = document.getElementById("newUserEmail");
		        let pass = document.getElementById("newUserPass1");
		        
				let url = '/api/login/';
				let dato = {email: email.value, password: pass.value};
			
			fetch(url, {
				  method: 'POST', 
				  body: JSON.stringify(dato), 
				  headers:{
				    'Content-Type': 'application/json'
				  }
				}).then(res => res.json())
				.catch(error => console.error('Error:', error))
				.then(response => localStorage.setItem("token", response.accessToken));
		
		  /*----------------------------------------------------------------------*/
 
    inicioS()
});

function inicioS(){ //función para LEER/RECUPERAR en el local storage desded el fomrulario login
    event.preventDefault();
        //let nombre = document.getElementById("newUserName").value;
        //let apellido = document.getElementById("newUserLastName").value;
        let correo = document.getElementById("newUserEmail").value;
        //let numero = document.getElementById("newUserNumber").value;
        let pass1 = document.getElementById("newUserPass1").value;
        //let pass2 = document.getElementById("newUserPass2").value;
    
        let user = localStorage.getItem(correo);    // Recupera el elemento en formato {"correo":"example@mail.com",..}
        let data = JSON.parse(user);                // Convierte a formato JSON el elemento recuperado
 
        if (correo == 'soporteQpets@gmail.com' && pass1 == '12345'){
            Swal.fire({
                position: 'center',
                icon: 'success',
                title: '¡Hola equipo!',
                showConfirmButton: false,
                timer: 2000,
                color: "#6E3E22",
                iconColor: "#6F1D1B"
            })
            setTimeout(function() {
                location.href = "../pages/agregar.html";
            }, 1500);
            
        } else {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Los datos no coinciden',
                showConfirmButton: false,
                timer: 3000,
                color: "#6E3E22",
                iconColor: "#6F1D1B"
            })
        }

        if(correo == data.correo && pass1 == data.pass1){  //COMPARA los valores ingresados con los almacenados
                Swal.fire({
                position: 'center',
                icon: 'success',
                title: 'Inicio de sesión exitoso',
                showConfirmButton: false,
                timer: 2000,
                color: "#6E3E22",
                iconColor: "#6F1D1B"
            })

            setTimeout(function() {
                location.href = "../index.html";
            }, 2000);
    
        } else {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Los datos no coinciden',
                showConfirmButton: false,
                timer: 3000,
                color: "#6E3E22",
                iconColor: "#6F1D1B"
            })
            return console.log("No se encontraron datos");
        }
    }