def saludar():
    print("Hola, bienvenido al mundo de la programación")

def saludo(nombre):
    return "Hola {}, bienvenido".format(nombre)

print("Ingresa tu nombre")
nombre = input()
print(saludo(nombre))