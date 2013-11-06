<?php

// array for JSON response
$response = array();

// include db connect class
require_once '/connect.php';

// connecting to db
$db = new DB_CONNECT();
$result = $db -> Database -> select("erstetabelle", "*");

if (sizeof($result) > 0) {
  
    $response["fragebogen"] = array();

    foreach($result as $row) {
        // temp user array
        $erstefr = array();

        $erstefr["f1id"] = $row["f1id"];
        $erstefr["1te antwort"] = $row["1te antwort"];
        $erstefr["2te antwort"] = $row["2te antwort"];
        $erstefr["3te antwort"] = $row["3te antwort"];
        $erstefr["4te antwort"] = $row["4te antwort"];
        $erstefr["5te antwort"] = $row["5te antwort"];

       
        array_push($response, $erstefr);
    }
    
    $response["success"] = 1;

    
    echo json_encode($response);
} else {
   
    $response["success"] = 0;
    $response["message"] = "Keine Fragebogen gefunden";

   
    echo json_encode($response);
}
?>