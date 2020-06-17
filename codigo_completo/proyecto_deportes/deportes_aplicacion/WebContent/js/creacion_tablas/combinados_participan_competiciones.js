
//mejorar las funcion por si tambien se introducen los puntos y las anotaciones

function combinados_participan_competiciones(ID_Combinado,ID_Competicion){
	$.ajax ({
		url: 'Introducir_Combinados_Participan_Competiciones',
		type: 'POST',
		data: {
			'ID_Combinado':ID_Combinado,
			'ID_Jugador': ID_Competicion,
		},
		dataType: 'text',
		success: function(data) {
		},
		/*error: function() {
			alert("Error en la comunicasion");
		}*/
	});
	
}

