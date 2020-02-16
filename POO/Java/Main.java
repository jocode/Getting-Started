package Java;

class Main {

  public static void main(String[] args) {
    System.out.println("Hola mundo");

    // Instanciar el objeto
    Car car = new Car("AMQ123", new Account("Andres Pez", "1081786543"));
    car.passenger = 4;
    car.printDataCar();

    Car car2 = new Car("JSC893", new Account("Maria Buendia", "1031786543"));
    car2.passenger = 2;
    car2.printDataCar();

    Paypal paypal = new Paypal(1, "correo@correo.com");
    System.out.println(paypal.email);

  }

}