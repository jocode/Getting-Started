<?php 
require_once('Car.php');
require_once('Account.php');

$car = new Car("KJD838", new Account("Amira Montoya", "9281813"));
$car->printData();

?>