package Java;

class UberX extends Car {

  String brand;
  String model;

  public UberX(String license, Account driver, String brand, String model) {
    super(license, driver);

    this.brand = brand;
    this.model = model;
  }

  @Override
  public void setPassenger(Integer passenger) {
    if (passenger == 4)
      super.setPassenger(passenger);
    else
      System.out.println("Debes asignar 4 pasageros");
  }

}