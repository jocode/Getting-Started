package Java;

class Paypal extends Payment {

  String email;

  public Paypal(int id, String email) {
    super.id = id;
    this.email = email;
  }

}