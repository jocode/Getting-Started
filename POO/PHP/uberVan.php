<?php 
require_once('car.php');

class UbenVan extends Car {
  public $typeCarAccepted;
  public $seatsMaterial;

  public function __construct($license, $driver, $typeCarAccepted, $seatsMaterial){
    parent::__construct($license, $driver);
    
    $this->typeCarAccepted = $typeCarAccepted;
    $this->seatsMaterial = $seatsMaterial;
  }

}

?>