function inserccion_jugadores(id){
    var id_equipo=id.toString();
	var respuesta="";
    $.ajax({
            headers: { 'X-Auth-Token': '8da834ac6d9e42df939ea632eadd8fe9' },
            url: 'http://api.football-data.org/v2/teams/'+id_equipo,
            dataType: 'json',
            type: 'GET',
            }).done(function(response) {
           
           	respuesta=response;
            var jugadores=respuesta.squad;
            for(let i=0;i<jugadores.length;i++){
                var fecha_no_procesada=jugadores[i].dateOfBirth;
                var Fecha_Dividida=fecha_no_procesada.split("T");
                var Fecha_Nacimiento=Fecha_Dividida[0];
                var data={
    					'ID': jugadores[i].id,
    					'Nombre': jugadores[i].name,
    					'Fecha_Nacimiento':Fecha_Nacimiento,
    					'Nacionalidad':jugadores[i].nationality,
    					'Rol':jugadores[i].role,
    					'Posicion': jugadores[i].position,
    				};
                
                $.ajax ({
    				url: 'Introducir_Jugadores',
    				type: 'POST',
    				data: data,
    				dataType: 'text',
    				success: function(data) {
    					 //se llama a la contratacion de combinados en equipos
    	                combinados_contratan_jugadores(id,jugadores[i].id)
    				},
    				/*error: function() {
    					alert("Error en la comunicasion");
    				}*/
    			});  
            }
        })
}