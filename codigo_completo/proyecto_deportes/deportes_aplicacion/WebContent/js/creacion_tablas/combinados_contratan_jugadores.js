var contador=0;

function mensaje(){
	alert("Los datos se han introducido con éxito");
}

function combinados_contratan_jugadores(id_combinado,id_jugador){
	var data={
			'ID_Combinado':id_combinado,
			'ID_Jugador': id_jugador,
		};
	
	$.ajax ({
		url: 'Introducir_Combinados_Contratan_Jugadores',
		type: 'POST',
		data:data,
		dataType: 'text',
	
		/*error: function() {
			alert("Error en la comunicasion");
		}*/
	});
	if(contador==0){
		 setTimeout(mensaje,8000);
		 contador++;
	}
}

