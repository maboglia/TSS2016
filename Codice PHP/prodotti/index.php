<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>jQuery.getJSON demo</title>
  <style>
  img {
    height: 100px;
    float: left;
  }
  </style>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
 
<div id="images"></div>
 
<script>
(function() {
  var prodottiAPI = "http://192.168.0.233/Prodotti/api_lista_prodotti.php";
  $.getJSON( prodottiAPI)
    .done(function( data ) {
    	$("#images").text(data);

      $.each( data.prodotti, function( i, item ) {
        $( "<li>" ).text(item.Prodotto + item.Descrizione ).appendTo( "#images" );
      //   if ( i === 3 ) {
      //     return false;
      //   }
      });
    })
      .fail(function( jqxhr, textStatus, error ) {
    var err = textStatus + ", " + error;
    console.log( "Request Failed: " + err );
})
    ;
})();
</script>
 
</body>
</html>