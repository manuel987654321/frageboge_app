<?php

// array for JSON response
$response = array();

// kontrolle ob alle Felder vorhanden
//if (isset ($_POST['1teantwort']) && isset($_POST['2teantwort']) && isset($_POST['3teantwort']) && isset($_POST['4teantwort']) && isset($_POST['5teantwort'])
//&& isset($_POST['6teantwort']) && isset($_POST['7teantwort']) && isset($_POST['8teantwort']) && isset($_POST['9teantwort']) && isset($_POST['10teantwort'])) {

if (isset($_POST['1teantwort']) && isset($_POST['2teantwort']) && isset($_POST['3teantwort'])) {

	$antwort_1 = $_POST['1teantwort'];
	$antwort_2 = $_POST['2teantwort'];
	$antwort_3 = $_POST['3teantwort'];
	//$antwort_4 = $_POST['4teantwort'];
	//$antwort_5 = $_POST['5teantwort'];
	//$antwort_6 = $_POST['6teantwort'];
	//$antwort_7 = $_POST['7teantwort'];
	//$antwort_8 = $_POST['8teantwort'];
	//$antwort_9 = $_POST['9teantwort'];
	//$antwort_10 = $_POST['10teantwort'];

	require_once '/connect.php';
	// connecting to db
	$db = new DB_CONNECT();

	$test = "$antwort_1" . "_" . $antwort_2 . "_" . $antwort_3;

	$result = $db -> Database -> insert("dritterfragebogen", array("1teantwort" => $antwort_1, "2teantwort" => $antwort_2, "3teantwort" => $antwort_3));

  	//file_put_contents("log.txt", sprintf($result));
  	
	// kontrolle ob eintrag erfolgreich war
	if (sizeof($result) > 0) {
		// funktioniert
		$response["success"] = 1;
		$response["message"] = $test;

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
