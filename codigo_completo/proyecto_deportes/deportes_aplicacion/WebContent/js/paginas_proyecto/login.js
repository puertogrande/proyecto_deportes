$("#enviar").click(function() {
	var Nick = $("#nick").val();
	var Password = $("#password").val();
	if(nick.length<5 || password.length<5){
		$("#mensaje").append("El nick y la contraseña han de tener una longitud de al menos 5 caractéres");
	}
	else{
		var data={
				'Nick': Nick,
				'Password': Password,
			};
		$.ajax ({
			url: 'Login_Usuario',
			type: 'POST',
			data: data,
			dataType: 'text',
			success: function(respuesta) {
				if(respuesta=="Los datos son erroneos"){
					$("#mensaje").empty();
					$("#mensaje").append("El nombre o la contraseña son incorrectos.");		
				}
				else{
					location.replace("index.html");
				}
			},
			error: function() {
				alert("Error en la comunicacion final");
			}
		});  
	}
});
