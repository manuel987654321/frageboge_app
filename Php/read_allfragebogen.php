<?php

// array for JSON response
$response = array();

// include db connect class
require_once '/connect.php';

// connecting to db
$db = new DB_CONNECT();

$result = $db -> Database -> select("dritterfragebogen", "*");
//$result = $db -> Database -> select("ersterfragebogen", "*");

if (sizeof($result) > 0) {

	$response["fragebogen"] = array();

	foreach ($result as $row) {
		// temp user array
		$erstefr = array();

		//$erstefr["f1id"] = $row["f1id"];
		$erstefr["fid"] = $row["fid"];
		$erstefr["1teantwort"] = $row["1teantwort"];
		$erstefr["2teantwort"] = $row["2teantwort"];
		$erstefr["3teantwort"] = $row["3teantwort"];
		// $erstefr["4te antwort"] = $row["4te antwort"];
		// $erstefr["5te antwort"] = $row["5te antwort"];
		// $erstefr["6te antwort"] = $row["6te antwort"];
		// $erstefr["7te antwort"] = $row["7te antwort"];
		// $erstefr["8te antwort"] = $row["8te antwort"];
		// $erstefr["9te antwort"] = $row["9te antwort"];
		// $erstefr["10te antwort"] = $row["10te antwort"];
		

		array_push($response["fragebogen"], $erstefr);
	}

	$response["success"] = 1;

	echo json_encode($response);

} else {

	$response["success"] = 0;
	$response["message"] = "Keine Fragebogen gefunden";

	echo json_encode($response);
}
?>