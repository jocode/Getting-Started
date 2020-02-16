# -*- coding: utf-8 -*-
from car import Car
from account import Account
from uberBlack import UberBlack
from paypal import Paypal

if __name__ == "__main__":
    print("Hello python")

    car = Car("ADK823", Account("Juan Magallán", "87133813"))
    print(vars(car))
    print(vars(car.driver))

    uberBlack = UberBlack("LJD273", Account("Juan Magallán", "87133813"), [
                          "Audi", "Mercedes"], ["Cuero"])
    print(vars(uberBlack))

    paypal = Paypal(1, "juan@correo.com")
    print(vars(paypal))
