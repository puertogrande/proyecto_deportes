
//una vez terminada parar despues de cada objeto competicion el deporte correspondiente a la competicion
var html='<div class="col-lg-4 col-md-6 col-sm-6 mt-5 mb-5 "> '
	html+= '<div class="card h-100 bg-info text-dark font-weight-bold rounded border-dark">';
	html += '<h3 class="Nombre card-header-title  bg-light pt-2 pb-2 text-center" style="height:100px;"></h3>';
	html +='<div class="card-body pt-2 pb-4 pl-5 pr-5">'
	html += '<h6 class="card-subtitle Pais pt-2 mb-2"> Pais: </h6>';
	html += '<h6 class="card-subtitle Fecha_comienzo  pt-2 mb-2">Fecha Comienzo : </h6>';
	html += '<h6 class="card-subtitle Fecha_fin  pt-2 mb-2">Fecha Fin : </h6>';
	html += '</div>';
	html +='<div class="card-footer">';
	html += '<h6><a class="Equipos mr-3 text-light">Mostrar Equipos</a> <a class="Clasificacion mr-3 text-light">Clasificacion</a> <a class="Grafico text-light">Gráfico</a></h6>';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	html += '</div>';
	html += '</div>';

var deportes="";
var paises_competiciones=[];

	$.ajax ({
		url: 'Pagina_competiciones',
		type: 'POST',
		dataType: 'text',
		success: function(data) {
			competiciones=JSON.parse(data);
			for(let i=0;i<competiciones.length;i++){
				$('#printcard').append(html);
				var competicion=competiciones[i];
	
				var $Nombre=competicion.Nombre;
				var $Pais=competicion.Pais;
				var $Fecha_comienzo=competicion.Fecha_comienzo;
				var $Fecha_fin=competicion.Fecha_fin;
				var url_Equipos="mostrar_equipos.html?ID="+competicion.ID.toString()+"&ID_Deporte="+competicion.ID_deporte.toString();
				var url_clasificacion="clasificacion.html?ID="+competicion.ID.toString()+"&ID_Deporte="+competicion.ID_deporte.toString();
				var url_grafico="grafico.html?ID="+competicion.ID.toString()+"&ID_Deporte="+competicion.ID_deporte.toString();
				
		        $(".Nombre:eq("+i+")").append($Nombre);
		        $(".Pais:eq("+i+")").append($Pais);
		        $(".Fecha_comienzo:eq("+i+")").append($Fecha_comienzo);
		        $(".Fecha_fin:eq("+i+")").append($Fecha_fin);
		        $(".Equipos:eq("+i+")").attr('href', url_Equipos);
		        $(".Clasificacion:eq("+i+")").attr('href', url_clasificacion);
		        $(".Grafico:eq("+i+")").attr('href', url_grafico);
		       
		        if(paises_competiciones.includes(competicion.Pais)){
					continue;
				 }
				 else{
					paises_competiciones.push(competicion.Pais);
				 }   
			}
			
			for(let i=0;i<paises_competiciones.length;i++){
				 optionText =paises_competiciones[i]; 
		         optionValue =paises_competiciones[i]; 
		         $('#pais').append(new Option(optionText,optionValue)); 
			}
			
		},
		error: function() {	
			alert("Error en la comunicasion");
		}
	});
	
		
$("#buscar" ).click(function() {
	  var pais = $("#pais").children("option:selected").val();
	  if($("#pais").children("option:selected").val()=="ninguno"){
			 pais=null;
		  }
	  $.ajax ({
			url: 'Pagina_competiciones',
			type: 'POST',
			dataType: 'text',
			data: {
				'pais': pais,
			},
			
			success: function(data) {
				competiciones=JSON.parse(data);
				//borra el contenido anterior
				$('#printcard').empty();

				for(let i=0;i<competiciones.length;i++){
					$('#printcard').append(html);
					var competicion=competiciones[i];
					var $Nombre=competicion.Nombre;
					var $Pais=competicion.Pais;
					var $Fecha_comienzo=competicion.Fecha_comienzo;
					var $Fecha_fin=competicion.Fecha_fin;
					
					//$(".userimg:eq("+i+")").append($img);
				       $(".Nombre:eq("+i+")").append($Nombre);
				       $(".Pais:eq("+i+")").append($Pais);
				       $(".Fecha_comienzo:eq("+i+")").append($Fecha_comienzo);
				       $(".Fecha_fin:eq("+i+")").append($Fecha_fin);       
				}
				
			},
			error: function() {
				alert("Error en la comunicacion");
			}
		});      
	               
	});
	  