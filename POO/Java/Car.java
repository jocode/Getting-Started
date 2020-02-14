package Java;

class Car {

  Integer id;
  String license;
  Account driver;
  Integer passenger;

  public Car(String license, Account driver) {
    this.license = license;
    this.driver = driver;
  }

  void printDataCar() {
    System.out.println("License: " + license + " Driver: " + driver.name + " Passenger: " + passenger);
  }

}