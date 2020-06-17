//Listado de competiciones disponibles 2000 Mundial,2001 Champions League,2002 Bundesliga ,2003 Liga Holandesa,2013 Liga Brasileña ,
//2014 Liga Española,2015 Liga Francesa,2016 Bundesliga,2017 Liga Portuguesa, 2018 Eurocopa,2019 Liga Italiana ,2021 Premier League
//var id_competicion=2021;

function crear_competicion(id_competicion){
	var respuesta="";
	var equipos="";
	var url='http://api.football-data.org/v2/competitions/'+id_competicion.toString();
	        $.ajax({
	                headers: {'X-Auth-Token':'8da834ac6d9e42df939ea632eadd8fe9'},
	                url:url,
	                dataType: 'json',
	                type: 'GET',
	                }).done(function(response) {
	               	respuesta=response;
	            
	                var nombre=respuesta.name;
	                var pais=respuesta.area.name;
	                var terminada=false;
	                if(respuesta.winner != undefined){
	                    terminada = true;
	                }
	
	                var Fecha_comienzo=respuesta.currentSeason.startDate;
	                var Fecha_fin=respuesta.currentSeason.endDate;
	                var data={
	    					'ID': respuesta.id,
	    					'Nombre': respuesta.name,
	    					'Pais': respuesta.area.name,
	    					'Terminada': terminada,
	    					'Fecha_comienzo':respuesta.currentSeason.startDate,
	    					'Fecha_fin':respuesta.currentSeason.endDate,
	    				};
	                
	                $.ajax ({
	    				url: 'Introducir_Competiciones',
	    				type: 'POST',
	    				data:data,
	    				dataType: 'text',
	    				success: function(data) {
	    					insercion_equipos(id_competicion);
	    					
	    				},
	    				error: function() {
	    					alert("Error en la comunicacion");
	    				}
	    			});
	            });
			}
        
               		
               		
      
               
