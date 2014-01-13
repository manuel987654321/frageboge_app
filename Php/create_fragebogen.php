<?php

// array for JSON response
$response = array();

// kontrolle ob alle Felder vorhanden
//if (isset($_POST['f1id']) && isset ($_POST['1teantwort']) && isset($_POST['2teantwort']) && isset($_POST['3teantwort']) && isset($_POST['4teantwort']) && isset($_POST['5teantwort'])) {
if (isset($_POST['1teantwort']) && isset($_POST['2teantwort']) && isset($_POST['3teantwort']) ) {		
	//$fragebogen1id = $_POST['f1id'];
	$antwort_1 = $_POST['1teantwort'];
	$antwort_2 = $_POST['2teantwort'];
	$antwort_3 = $_POST['3teantwort'];
	//$antwort_4 = $_POST['4teantwort'];
	//$antwort_5 = $_POST['5teantwort'];

	require_once '/connect.php';
	// connecting to db
	$db = new DB_CONNECT();

	
	//$result = mysql_query("INSERT INTO erstetabelle(f1id,1te antwort, 2te antwort, 3te antwort,4te antwort,5te antwort)
  	  
  	$result = mysql_query("INSERT INTO `fragebogen_datenbank`.`dritterfragebogen` (`fid`, `1teantwort`, `2teantwort`, `3teantwort`) 
  	VALUES (NULL, '$antwort_1', '$antwort_2', '$antwort_3')");
  
    //$result = mysql_query("INSERT INTO dritterfragebogen(1teantwort, 2teantwort, 3teantwort)
    //VALUES('$antwort_1', '$antwort_2', '$antwort_3')");

	// kontrolle ob eintrag erfolgreich war
	if (sizeof($result)>0) {
		// funktioniert
		$response["success"] = 1;
		$response["message"] = "Fragebogen erfolgreich erstellt !!";

		
		echo json_encode($response);
	} else {
		// nicht funktioniert
		$response["success"] = 0;
		$response["message"] = "Fehler aufgetreten !!";

		
		echo json_encode($response);
	}
} else {
	// Felder fehlen
	$response["success"] = 0;
	$response["message"] = "Benoetigte Felder fehlen !!";

	
	echo json_encode($response);
}
?>
