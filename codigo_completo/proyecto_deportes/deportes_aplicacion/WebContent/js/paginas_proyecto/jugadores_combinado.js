var html='<div class="col-lg-4 col-md-6 col-sm-6 mt-2 mb-2"> '
	html+= '<div class="card h-100 bg-info text-white mt-3 font-weight-bold rounded border-dark">';
	html += '<h3 class="card-header-title  bg-light pt-2 pb-2 text-center" style="height:100px;"><a class="card-title text-dark  Nombre"></a></h3>';
	html +='<div class="card-body pt-2 pb-4 pl-5 pr-5">'
	html += '<div class="userimg"> </div>';
	html += '<h6 class="Descripcion mt-2 mb-2">Descripcion: </h6>';
	html += '<h6 class="card-subtitle Nacionalidad mb-2">Pais origen : </h6>';
	html += '<h6 class="card-subtitle Fecha_Nacimiento mb-2">Fecha Nacimiento : </h6>';
	html += '<h6 class="card-subtitle Posicion mb-2">Posicion : </h6>';
	html += '</div>';
	html +='<div class="card-footer">';
	html +='<a href="#" class="Editar btn bg-light ml-3 text-dark font-weight-bold"> Editar </a>';
	html +='</div>';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	html += '</div>';

var equipos="";
var queryString = window.location.search;
var urlParams = new URLSearchParams(queryString);
var Nombre_equipo = urlParams.get('Nombre');
var ID_equipo = urlParams.get('ID_Equipo').toString();

$( function() {
    $( "#draggable" ).draggable();
  } );

  $("#cerrar").click(function() {
    if($('#draggable').css('display') != 'none'){
    	location.replace("competiciones.html")
    }
  });

var data={
		'ID_equipo': ID_equipo,
		'ID_deporte':"1",
	};

$.ajax ({
	url: 'Pagina_jugadores',
	type: 'POST',
	dataType: 'text',
	data: data,
	success: function(jugadores_obtenidos) {
		jugadores=JSON.parse(jugadores_obtenidos);
		if(jugadores.length==0){
			$("#draggable").css("display", "block");
		}
		//borra el contenido anterior
		$('#nombre_equipo').append(Nombre_equipo);
		$('#printcard').empty();

		for(let i=0;i<jugadores.length;i++){
			$('#printcard').append(html);
			var jugador=jugadores[i];
			var $Nombre=jugador.Nombre;
			var $Descripcion=jugador.Descripcion;
			var $Nacionalidad=jugador.Nacionalidad;
			var $Posicion=jugador.Posicion;
			var $Fecha_Nacimiento=jugador.Fecha_Nacimiento;
			var url="editar_jugador.html?ID="+jugador.ID.toString()+"&ID_Deporte="+jugador.ID_Deporte.toString();
	        //crear un enlace 
	       //$(".userimg:eq("+i+")").append($img);
	       $(".Nombre:eq("+i+")").append($Nombre);
	       $(".Nombre:eq("+i+")").attr('href', url);
	       $(".Descripcion:eq("+i+")").append($Descripcion);
	       $(".Nacionalidad:eq("+i+")").append($Nacionalidad);
	       $(".Fecha_Nacimiento:eq("+i+")").append($Fecha_Nacimiento);
	       $(".Posicion:eq("+i+")").append($Posicion);
	       $(".Editar:eq("+i+")").attr('href', url);
		}
	   $( "#cargando" ).remove();
		
	},
	error: function() {
		alert("Error en la comunicacion");
	}
}); 
