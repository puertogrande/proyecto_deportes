var queryString = window.location.search;
var urlParams = new URLSearchParams(queryString);
var id_competicion = urlParams.get('ID')
var ID_Deporte = urlParams.get('ID_Deporte')
var clasificacion="";
var equipos="";
var url='http://api.football-data.org/v2/competitions/'+id_competicion.toString()+'/standings';

$( function() {
    $( "#draggable" ).draggable();
  } );

$("#cerrar").click(function() {
  if($('#draggable').css('display') != 'none'){
	  location.replace("competiciones.html")
    }
 });

$.ajax({
        headers: {'X-Auth-Token':'8da834ac6d9e42df939ea632eadd8fe9'},
        url:url,
        dataType: 'json',
        type: 'GET',
        }).done(function(clasificacion) {  
            try{
            	equipos=clasificacion.standings[0].table;
            }
            catch(error){
            	$("#draggable").css("display", "block");
            }
            if(equipos.length>0){
            	var table = $('<table>').addClass('table  table-success  font-weight-bold mb-5 table-striped');
                var fila = $('<tr >').addClass('fila table-info');
                fila.append($('<td>').addClass('posicion').text("Posicion"));
                fila.append($('<td>').addClass('nombre').text("Nombre del equipo"));
                fila.append($('<td>').addClass('partidos_jugados').text("Partidos Jugados"));
                fila.append($('<td>').addClass('puntos').text("Puntos"));
                fila.append($('<td>').addClass('partidos_ganados').text("Partidos Ganados"));
                fila.append($('<td>').addClass('goles_favor').text("Goles a Favor"));
                fila.append($('<td>').addClass('goles_contra').text("Goles en contra"));
                fila.append($('<td>').addClass('diferencia_goles').text("Diferencia de goles"));
                table.append(fila);

                for(let i=0;i<equipos.length;i++){
                    var equipo=equipos[i];
                    console.log(equipo);
                    var posicion=equipo.position;
                    var nombre=equipo.team.name;
                    var partidos_jugados=equipo.playedGames;
                    var puntos=equipo.points;
                    var partidos_ganados=equipo.won;
                    var goles_favor=equipo.goalsFor;
                    var goles_contra=equipo.goalsAgaints;
                    var diferencia_goles=equipo.goalsDifference;
                    var fila = $('<tr>').addClass('fila');
                    fila.append($('<td class="pl-4">').addClass('posicion').text(equipo.position));
                    fila.append($('<td>').addClass('nombre').text(equipo.team.name));
                    fila.append($('<td class="pl-4">').addClass('partidos_jugados').text(equipo.playedGames));
                    fila.append($('<td class="pl-4">').addClass('puntos').text(equipo.points));
                    fila.append($('<td class="pl-4">').addClass('partidos_ganados').text(equipo.won));
                    fila.append($('<td class="pl-4">').addClass('goles_favor').text(equipo.goalsFor));
                    fila.append($('<td class="pl-4">').addClass('goles_contra').text(equipo.goalsAgainst));
                    fila.append($('<td class="pl-4">').addClass('diferencia_goles').text(equipo.goalDifference));

                    table.append(fila);
                }
            }
            

            $('#printcard').append(table);
                        
        });