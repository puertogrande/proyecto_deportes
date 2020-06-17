function insercion_equipos(id_competicion){
	var respuesta="";
	var equipos="";
	var url_seleccionada="http://api.football-data.org/v2/competitions/"+id_competicion.toString()+"/teams?";
	
	        $.ajax({
	                headers: { 'X-Auth-Token':'8da834ac6d9e42df939ea632eadd8fe9'},
	                url:url_seleccionada,
	                dataType: 'json',
	                type: 'GET',
	                }).done(function(response) {
	               	respuesta=response;
	               	equipos=respuesta.teams;
	               	
	               	for(let i=0;i<equipos.length;i++){
	               		var equipo=equipos[i];
	               		var ID=equipo.id;
	               		var name=equipo.name;
	               		var Ano_Creacion=equipo.founded;
	               		var Procedencia=equipo.address;
	               		var Estadio=equipo.venue
	               		
	               		var data={
		    					'ID': ID,
		    					'name': name,
		    					'Ano_Creacion': Ano_Creacion,
		    					'Procedencia': Procedencia,
		    					'Estadio':Estadio,
		    				};
	           
	               	 $.ajax ({
		    				url: 'Introducir_Equipos',
		    				type: 'POST',
		    				data: data,
		    				dataType: 'text',
		    				
		    	
		    				error: function() {
		    					alert("Error en la comunicacion");
		    				}
		    			});
	               	
	               	 
	               	 //parece que hay un error al ponerlo en suscess
	               	combinados_participan_competiciones(ID,id_competicion)
	               	//llamar a la funcion de coger a los jugadores a traves de un id
					inserccion_jugadores(ID);
				
	               	}	            
	            });
	        introducir_partidos(id_competicion);
}


