class Paypal extends Payment {

  constructor(id, number, cvv, date) {
    super(id);
    this.number = number;
    this.cvv = cvv;
    this.date = date;
  }

}