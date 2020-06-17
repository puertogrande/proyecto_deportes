/*comprobar que el usuario tiene permiso para realizar los cambios*/
var usuario_session="";
$.ajax ({
	url: 'Comprobar_sesion',
	type: 'POST',
	success: function(usuario) {
		if(usuario=="no iniciado"){
			location.replace("necesitas_registrarte.html");
		}
	},
	
	error: function() {
		alert("Error en la comunicacion");
	}
});

$("#crear_competicion" ).click(function() {
	  var id_competicion = $("#campeonato").children("option:selected").val();
	  if(id_competicion=="ninguno"){
		  alert("selecciona alguna competicion");
		  competicion_seleccionada=null;
	  }
	  else{
		  alert("la competición será creada o actualizada, este proceso puede durar varios minutos");
		  crear_competicion(id_competicion)
	  }
});
	  