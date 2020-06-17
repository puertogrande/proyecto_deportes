/*comprobar que el usuario tiene permiso para realizar los cambios*/
var usuario_session="";
$.ajax ({
	url: 'Comprobar_sesion',
	type: 'POST',
	success: function(usuario) {
		if(usuario=="no iniciado"){
			location.replace("necesitas_registrarte.html");
		}
	},
	
	error: function() {
		alert("Error en la comunicacion");
	}
});

var html='<div class="col-lg-6 mt-2 mb-5 carta"> '
	html+= '<div class="card h-100 bg-info text-white mt-3 font-weight-bold rounded border-dark">';
	html += '<h3 class="card-header-title  bg-light pt-2 pb-2 text-center" style="height:100px;"><a class="card-title text-dark  Nombre"></a></h3>';
	html +='<div class="card-body pt-2 pb-4 pl-5 pr-5">'
	html += '<img class="Userimg"> </img>';
	html += '<h6 class="Descripcion mt-2 mb-2">Descripcion: </h6>';
	html += '<h6 class="card-subtitle Nacionalidad mb-2">Pais origen : </h6>';
	html += '<h6 class="card-subtitle Fecha_Nacimiento mb-2">Fecha Nacimiento : </h6>';
	html += '<h6 class="card-subtitle Posicion mb-2">Posicion : </h6>';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	html += '</div>';

var jugador="";
var queryString = window.location.search;
var urlParams = new URLSearchParams(queryString);
var ID = urlParams.get('ID');
var ID_Deporte = urlParams.get('ID_Deporte');
var nombre_imagen="";

//insertamos los valores para cuando se hace click
 $.ajax ({
    	url: 'Pagina_editar_jugadores',
    	type: 'POST',
    	dataType: 'text',
    	data: {
    		'ID': ID,
    		'ID_Deporte': ID_Deporte,
    	},
    	
    	success: function(data) {
    		jugador=JSON.parse(data);
    		//borra el contenido anterior
    		$('#printcard').empty();
    		$('#printcard').append(html);
    	
    		var url="editar_jugador.html?ID="+jugador.ID.toString()+"&ID_Deporte="+jugador.ID_Deporte.toString();
            //crear un enlace 
           //$(".userimg:eq("+i+")").append($img);
            $(".Nombre:eq("+0+")").append(jugador.Nombre);
            $(".Nombre:eq("+0+")").attr('href', url);
            $(".Descripcion:eq("+0+")").append(jugador.Descripcion);
            $(".Nacionalidad:eq("+0+")").append(jugador.Nacionalidad);
            $(".Fecha_Nacimiento:eq("+0+")").append(jugador.Fecha_Nacimiento);
            $(".Posicion:eq("+0+")").append(jugador.Posicion);
            //$(".Userimg:eq("+0+")").attr('src', "\\"+jugador.Imagen);
    	},
    	error: function() {
    		alert("Error en la comunicasion");
        	}
        });
        
$('form').submit(function(event) {
    event.preventDefault();
  
    var Descripcion = $("#descripcion").val(); 
    $.ajax ({
		url: 'Pagina_editar_jugadores',
		type: 'POST',
		dataType: 'text',
		data: {
			'ID': ID,
			'ID_Deporte': ID_Deporte,
			'Descripcion': Descripcion,
		},
		
		success: function(data) {
			location.reload();
		},
		error: function() {
			alert("Error en la comunicacion");
  			}
  		});
    
    // se envía la información al servnet para que suba la imagen al servidor
    /*$.ajax({
        url : $(this).attr('action'),
        type : $(this).attr('method'),
        data : new FormData(this),
        contentType : false,
        cache : false,
        processData : false,
        success : function(imagen) {
        	//llamar a la funcion para introducir el jugador y luego reload
        	nombre_imagen = imagen.replace(/\\/g, "\\\\");
        	alert(nombre_imagen);
        	
        	//si se ha introducido una imagen la introducimos en la base de datos
        	if(nombre_imagen !=""){
        		 $.ajax ({
         			url: 'Pagina_editar_jugadores',
         			type: 'POST',
         			dataType: 'text',
         			data: {
         				'ID': ID,
         				'ID_Deporte': ID_Deporte,
         				'Imagen': "\\\\"+nombre_imagen,
         			},
         			
         			success: function(data) {
         				location.reload();
         			},
         			error: function() {
         				alert("Error en la comunicacion");
         	  			}
         	  		});    
        	}
        	
        	},
        
        error: function() {
			alert("Error en la comunicacion");
  			}
    });  */   
});
 

     