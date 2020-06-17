var queryString = window.location.search;
var urlParams = new URLSearchParams(queryString);
var id_competicion = urlParams.get('ID');
var ID_Deporte = urlParams.get('ID_Deporte');
var datos="";
var url='http://api.football-data.org/v2/competitions/'+id_competicion.toString()+'/standings';
var estadisticas_equipos=[ ['Equipo', 'Puntos','Goles a Favor', 'Goles en contra'],];

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
        }).done(function(datos) {
            try{
            	var equipos=datos.standings[0].table;
            }
            catch(error){
            	$("#draggable").css("display", "block");
            }
            $('#nombre_competicion').append(datos.competition.name);
            var fila_de_filas=[
                ['Equipo', 'Partidos Jugados', 'Puntos', 'Goles a favor', 'Goles en contra'],                
              ];
            for(let i=0;i<equipos.length;i++){
                var equipo=equipos[i];      
                var posicion=equipo.position;
                var nombre=equipo.team.name;
                var partidos_jugados=equipo.playedGames;
                var puntos=equipo.points;
                var partidos_ganados=equipo.won;
                var goles_favor=equipo.goalsFor;
                var goles_contra=equipo.goalsAgainst;
                var diferencia_goles=equipo.goalsDifference;
                fila_de_filas.push( [posicion.toString()+" "+nombre,partidos_jugados,puntos,goles_favor,goles_contra]);
            }
            google.charts.load('current', {'packages':['corechart']});
            google.charts.setOnLoadCallback(drawVisualization);
             
            function drawVisualization() {
              // Some raw data (not necessarily accurate)
              var data = google.visualization.arrayToDataTable(fila_de_filas);
              var options = {
                title : 'Datos de los equipos',
                seriesType: 'bars',
                series: {5: {type: 'line'}}
              };
              var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
              chart.draw(data, options);
            }
        });
       