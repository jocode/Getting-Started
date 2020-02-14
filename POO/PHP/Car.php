<?php 
require_once('Account.php');
class Car {
  
  public int $id;
  public $license;
  public $driver;
  public $passenger;

  public function __construct(string $license, Account $driver){
    $this->license = $license;
    $this->driver = $driver;
  }

  function printData(){
    echo'<pre>';
    print_r($this->driver); // print_r vs var_dump
    var_dump($this->driver);
    print($this->license);
    echo'</pre>';
  }

}

?>