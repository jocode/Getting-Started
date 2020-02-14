# Importamos el modulo
from car import Car
from account import Account

if __name__ == "__main__":
    print("Hello python")

    car = Car("ADK823", Account("Juan Magallán", "87133813"))
    print(vars(car))
    print(vars(car.driver))
