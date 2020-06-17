var usuario_session="";
$.ajax ({
	url: 'Comprobar_sesion',
	type: 'POST',
	success: function(usuario) {
		if(usuario!="no iniciado"){
			usuario_session=JSON.parse(usuario);
			$('#usuario_nombre').append(usuario_session.Nick);
		}
	},
	
	error: function() {
		alert("Error en la comunicacion");
	}
});












