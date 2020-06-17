$(".alert").hide();
$("#enviar").click(function() {
	var Nick = $("#nick").val();
	var Password = $("#password").val();
	if(Nick.length<5 || Password.length<5){
		$("#mensaje").empty();
		$("#mensaje").append("El nick y la contraseña han de tener una longitud de al menos 5 caractéres.");	
	}
	else{
		var data={
				'Nick': Nick,
				'Password': Password,
			};
		$.ajax ({
			url: 'Introducir_Usuario',
			type: 'POST',
			data: data,
			dataType: 'text',
			success: function(resultado_registro) {
				if(resultado_registro=="correcto"){
					//motrar si el nick ya está siendo utilizado
					$(".alert").show();
					  setTimeout(function(){location.replace("index.html") },7000);
				}
				else{
					$("#mensaje").empty();
					$("#mensaje").append("Ese Nick ya esta siendo utilizado, por favor pruebe con un Nick diferente.");		
				}
			},
			error: function() {
				alert("Error en la comunicacion");
			}
		});  
	}
});
