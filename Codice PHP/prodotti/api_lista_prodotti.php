<?php 

include_once './db_connect.php';

function getCategories(){
    $db = new DbConnect();
    // array for json response
    $response = array();
    $response["prodotti"] = array();
    
    // Mysql select query
    $result = mysql_query("SELECT * FROM prodotti");
    
    while($row = mysql_fetch_array($result)){
        // temporary array to create single category
        $tmp = array();
        $tmp["ID"] = $row["ID"];
        $tmp["Prodotto"] = $row["Prodotto"];
        $tmp["Descrizione"] = $row["Descrizione"];
        $tmp["Prezzo"] = $row["Prezzo"];
        
        // push category to final json array
        array_push($response["prodotti"], $tmp);
    }
    
    // keeping response header to json
    header('Content-Type: application/json');
    
    // echoing json result
    echo json_encode($response);
}


    header('Content-Type: application/json');
 header("Access-Control-Allow-Origin: *");

//getCategories();
?>


{
    "prodotti": [{
        "ID": "1",
        "Prodotto": "Mac Mini",
        "Descrizione": "Mac Mini processore Intel I5\r\n8GB di RAM, 500GB",
        "Prezzo": "788.99",
        "Disponibilita": "infinita"
    }, {
        "ID": "2",
        "Prodotto": "Dell XPS 13 ",
        "Descrizione": "Processore Intel i7\r\n16GB RAM, 512ssd",
        "Prezzo": "1249.00"
    }, {
        "ID": "3",
        "Prodotto": "Mac Book",
        "Descrizione": "Mac Book processore Intel I7\r\n16GB di RAM, 1500GB",
        "Prezzo": "1288.99"
    }, {
        "ID": "4",
        "Prodotto": "AlePiBell dell XPS 13 ",
        "Descrizione": "Processore Intel i75\r\n160GB RAM, 2048ssd, solo per oggi",
        "Prezzo": "249.99"
    }]
}