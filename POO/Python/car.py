from account import Account


class Car:
    id = int
    license = str
    driver = Account("", "")
    passenger = str

    def __init__(self, name, driver):
        self.name = name
        self.driver = driver

    def printData(self):
        print(self.license, self.passenger)
        print(vars(self.driver))
