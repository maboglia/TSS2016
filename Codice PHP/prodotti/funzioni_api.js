(function() {
  var prodottiAPI = "http://192.168.0.233/Prodotti/api_lista_prodotti.php";
  $.getJSON( prodottiAPI)
    .done(function( data ) {
    	$("#images").text(data);

      $.each( data.prodotti, function( i, item ) {
        $( "<div>" ).css("border", "1px solid black").text(item.Prodotto + item.Descrizione ).appendTo( "#images" );
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