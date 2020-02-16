package Java;

class Card extends Payment {

  int number;
  int cvv;
  String date;

  public Card(int id, int number, int cvv, String date) {
    super.id = id;
    this.number = number;
    this.cvv = cvv;
    this.date = date;
  }
}