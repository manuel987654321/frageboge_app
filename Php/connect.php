<?php
require_once (dirname(__FILE__) . "/medoo.min.php");
include (dirname(__FILE__) . "/db_config.php");
class DB_CONNECT {
    public $Database;

    public function __construct() {
        $db = $GLOBALS['db'];
        $this -> Database = new medoo( array(
            'database_type' => 'mysql',
            'database_name' => $db['database'],
            'server' => $db['hostname'],
            'username' => $db['username'],
            'password' => $db['password']
        ));
    }

}
?>