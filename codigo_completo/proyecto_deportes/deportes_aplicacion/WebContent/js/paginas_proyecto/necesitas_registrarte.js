$("#draggable").css("display", "block");

$( function() {
    $( "#draggable" ).draggable();
  } );

  $("#cerrar").click(function() {
    if($('#draggable').css('display') != 'none'){
    	location.replace("registro.html")
    }
  });
