var html='<div class="col-lg-4 col-md-6 col-sm-6 mt-5 mb-5 "> '
	html+= '<div class="card h-100 bg-info text-dark font-weight-bold rounded border-dark">';
	html += '<h3 class="Nombre card-header-title  bg-light pt-2 pb-2 text-center" style="height:100px;"></h3>';
	html +='<div class="card-body pt-2 pb-4 pl-5 pr-5">'
	html += '<h6 class="mt-2 mb-2 Ano_Creacion">Año creacion </h6>';
	html += '<h6 class="card-subtitle mb-2 Procedencia ">Procedencia : </h6>';
	html += '<h6 class="card-subtitle mb-2 Estadio ">Estadio : </h6>';
	html += '</div>';
	html +='<div class="card-footer">';
	html += '<h6><a class="Jugadores mr-5 text-light">Ver Jugadores</a> </h6>';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	html += '</div>';

var equipos="";
var queryString = window.location.search;
var urlParams = new URLSearchParams(queryString);
var ID = urlParams.get('ID')
var ID_Deporte = urlParams.get('ID_Deporte')

var id_liga = {'2000' : 'Copa del Mundo','2001' : 'Champions League','2002' : 'Bundesliga','2003' : 'Liga Holandesa','2013' : 'Liga Brasileña'
	,'2014' : 'Liga Española','2015' : 'Liga Francesa','2016' : 'Bundesliga','2017' : 'Liga Portuguesa','2018' : 'Eurocopa','2019' : 'Liga Italiana','2021' : 'Premier League'};
var liga = id_liga[ID];

$.ajax ({
	url: 'Pagina_mostrar_equipos',
	type: 'POST',
	dataType: 'text',
	data: {
		'ID': ID,
		'ID_Deporte': ID_Deporte,
	},
	
	success: function(data) {
		//alert(data);
		equipos=JSON.parse(data);
		$('#nombre_competicion').append(liga);
		for(let i=0;i<equipos.length;i++){
			$('#printcard').append(html);
			var equipo=equipos[i];
			var $Nombre=equipo.Nombre;
			var $Ano_Creacion=equipo.Ano_Creacion;
			var $Procedencia =equipo.Procedencia;
			var $Estadio =equipo.Estadio ;
			var url_jugadores="jugadores_combinado.html?Nombre="+$Nombre+"&ID_Equipo="+equipo.ID.toString();
	        
			 //crear un enlace 
	       //$(".userimg:eq("+i+")").append($img);
		 
	       $(".Nombre:eq("+i+")").append($Nombre);
	       $(".Ano_Creacion:eq("+i+")").append($Ano_Creacion);
	       $(".Procedencia:eq("+i+")").append($Procedencia);
	       $(".Estadio:eq("+i+")").append($Estadio); 
	       $(".Jugadores:eq("+i+")").attr('href', url_jugadores);
	       
		}
     		
	},
	error: function() {
		alert("Error en la comunicacion");
	}
});