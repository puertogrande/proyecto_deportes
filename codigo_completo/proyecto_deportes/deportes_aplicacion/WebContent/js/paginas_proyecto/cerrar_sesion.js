$.ajax ({
	url: 'Cerrar_sesion',
	type: 'POST',
	success: function(respuesta) {
		if(respuesta=="sesion cerrada"){
			alert("la sesion ha sido cerrada con exito");
			location.replace("login.html");
		}
	},
	
	error: function() {
		alert("Error en la comunicacion");
	}
});