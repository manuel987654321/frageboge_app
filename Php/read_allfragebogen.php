<?php

// array for JSON response
$response = array();

// include db connect class
require_once '/connect.php';

// connecting to db
$db = new DB_CONNECT();
$result = $db -> Database -> select("ersterfragebogen", "*");
//$result = $db -> Database -> select("dritterfragebogen", "*");

if (sizeof($result) > 0) {

	$response["fragebogen"] = array();

	foreach ($result as $row) {
		// temp user array
		$erstefr = array();

		//$erstefr["fid"] = $row["fid"];
		
		$erstefr["f1id"] = $row["f1id"];
		$erstefr["1te antwort"] = $row["1te antwort"];
		$erstefr["2te antwort"] = $row["2te antwort"];
		$erstefr["3te antwort"] = $row["3te antwort"];
		$erstefr["4te antwort"] = $row["4te antwort"];
		$erstefr["5te antwort"] = $row["5te antwort"];
		$erstefr["6te antwort"] = $row["6te antwort"];
		$erstefr["7te antwort"] = $row["7te antwort"];
		$erstefr["8te antwort"] = $row["8te antwort"];
		$erstefr["9te antwort"] = $row["9te antwort"];
		$erstefr["10te antwort"] = $row["10te antwort"];
		$erstefr["11te antwort"] = $row["11te antwort"];
		$erstefr["12te antwort"] = $row["12te antwort"];
		$erstefr["13te antwort"] = $row["13te antwort"];
		$erstefr["14te antwort"] = $row["14te antwort"];
		$erstefr["15te antwort"] = $row["15te antwort"];
		$erstefr["16te antwort"] = $row["16te antwort"];
		$erstefr["17te antwort"] = $row["17te antwort"];
		$erstefr["18te antwort"] = $row["18te antwort"];
		$erstefr["19te antwort"] = $row["19te antwort"];
		$erstefr["20te antwort"] = $row["20te antwort"];

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