
    //para calcular el numero de jornadas utilizamos las jornadas que hemos tenido en la edicion anterior del torneo
    function partidos_jornada(numero_jornada){
    	//alert(numero_jornada);
        var url='http://api.football-data.org/v2/competitions/2019/matches?matchday='+numero_jornada.toString();
        $.ajax({
            headers: { 'X-Auth-Token': '8da834ac6d9e42df939ea632eadd8fe9' },
            url:url,
            dataType: 'json',
            type: 'GET',
            }).done(function(response) {
            respuesta=response;
            var partidos=respuesta.matches;
            for (let i=0;i<partidos.length;i++){
                var partido=partidos[i];  
                var jugado=0;
                var fecha_no_procesada=partido.utcDate;
                var Fecha_Dividida=fecha_no_procesada.split("T");
                var Fecha=Fecha_Dividida[0];
               
                if(partido.status=="FINISHED"){
                        jugado=1;
                }
               
                $.ajax ({
    				url: 'Introducir_Partidos',
    				type: 'POST',
    				data: {
    					'ID': partido.id,
    					'ID_Competicion': respuesta.competition.id,
    					'ID_Combinado_Local':partido.homeTeam.id,
    					'ID_Combinado_Visitante':partido.awayTeam.id,
    					'Numero_Jornada':partido.season.currentMatchday,
                        'Goles_Anotaciones_Local': partido.score.fullTime.homeTeam,
                        'Goles_Anotaciones_Visitante':partido.score.fullTime.awayTeam,
                        'Jugado':jugado,
                        'Fecha':Fecha,
    				},
    				dataType: 'text',
    				success: function(data) {
    				},
    				/*error: function() {
    					alert("Error en la comunicasion");
    				}*/
    			});
            }
        })
    }

    function introducir_partidos(id_competicion){
	    var respuesta="";
	    var ultimas_jornada_registrada=1;
	    $.ajax({
	        headers: { 'X-Auth-Token': '8da834ac6d9e42df939ea632eadd8fe9' },
	        url:'http://api.football-data.org/v2/competitions/'+id_competicion.toString(),
	        dataType: 'json',
	        type: 'GET',
	        }).done(function(response) {
	           respuesta=response;
	           var numero_jornadas=respuesta.seasons[1].currentMatchday;
	           for(let i=ultimas_jornada_registrada;i<=numero_jornadas;i++){
	            partidos_jornada(i);
	           }       
	    })
    }	  
