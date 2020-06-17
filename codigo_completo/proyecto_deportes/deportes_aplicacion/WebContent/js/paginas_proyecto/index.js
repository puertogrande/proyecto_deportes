
function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > x.length) {slideIndex = 1}
  x[slideIndex-1].style.display = "block";
  setTimeout(carousel, 3000); // Change image every 3 seconds
}
var slideIndex = 0;
carousel();
var today = new Date();
var dd = String(today.getDate()).padStart(2, '0').toString();
var mm = String(today.getMonth() + 1).padStart(2, '0').toString(); //January is 0!
var yyyy = today.getFullYear().toString();
today=yyyy+"-"+ mm +"-"+ dd;

var url = "http://newsapi.org/v2/everything?q=deportes&from="+ today + "&sortBy=publishedAt&apiKey=8df97af536804dd4b638adeabd300af1";

$.ajax({
		url: url,
		dataType: 'json',
		type: 'GET',
	}).done(function(informacion_noticias) {
		var noticias_api=informacion_noticias.articles;
		var noticias_html = document.getElementsByClassName("noticias");
		$(".noticias h3").eq(3).text("este es diferente");
		for (let i = 0; i < 6; i++) {
		$(".noticias h3").eq(i).text(noticias_api[i].title);
		$(".noticias p").eq(i).text(noticias_api[i].description);
		$(".noticias h6").eq(i).text(noticias_api[i].author);
	}
})
