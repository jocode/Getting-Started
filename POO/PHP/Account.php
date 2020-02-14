<?php 

class Account {
  public int $id;
  public $name = "";
  public $document = "";
  public $email = "";
  public $password = "";

  function __construct(string $name, string $document){
    $this->name = $name;
    $this->document = $document;
  }
}

?>