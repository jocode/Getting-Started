package Java;

class Main {

  public static void main(String[] args) {
    System.out.println("Hola mundo");

    // Instanciar el objeto
    Car car = new Car("AMQ123", new Account("Andres Pez", "1081786543"));
    car.setPassenger(2);
    car.printDataCar();

    UberX uberx = new UberX("JSC893", new Account("Maria Buendia", "1031786543"), "Audi", "Q5");
    uberx.setPassenger(4);
    uberx.printDataCar();

    Paypal paypal = new Paypal(1, "correo@correo.com");
    System.out.println(paypal.email);

  }

}