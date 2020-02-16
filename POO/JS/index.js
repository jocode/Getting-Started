// las nuevas especificaciones del EcmaScript 6 (Aunque es importante aclarar que estos no dejan de ser prototipos)
var car = new Car("ADK9783", new Account("Juan Perez", "8773221"));
car.passenger = 4;
car.printDataCar();

var uberX = new UberX("LJE083", new Account("Anita Hernandez", "83723751"), "Audi", "Q5");
uberX.printDataCar();
console.log(uberX);

var paypal = new Paypal(1, "correo@correo.com");
console.log(paypal);
