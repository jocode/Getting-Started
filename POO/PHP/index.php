<?php 
require_once('car.php');
require_once('account.php');
require_once('uberX.php');
require_once('uberPool.php');

$uberX = new UberX("KJD838", new Account("Amira Montoya", "187623871"), "Audi", "X5");
// $car = new Car("KJD838", new Account("Amira Montoya", "187623871"));

$uberPool = new UberPool("KJD838", new Account("Palacina Mendoza", "12442"), "Hipster", "xy");
$uberX->printData();
$uberPool->printData();


?>