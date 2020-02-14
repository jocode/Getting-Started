/**
 * A partir de las nuevas especificaciones del EcmaScript 6 ya podemos declarar una clase con la palabra reservada class, aunque es importante aclarar que estos no dejan de ser prototipos, sino todo lo contrario.
 */
class Car {

  constructor(license, driver) {
    this.id;
    this.license = license;
    this.driver = driver;
    this.passenger;
  }

  printDataCar() {
    console.log(this.driver);
    console.log(this.license);
    console.log(this.passenger);
  }

}