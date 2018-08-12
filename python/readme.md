# Python

Python es un lenguaje de programación interpretado cuya filosofía hace hincapié en una sintaxis que favorezca un código legible.

Se trata de un lenguaje de programación multiparadigma, ya que soporta orientación a objetos, programación imperativa y, en menor medida, programación funcional. Es un lenguaje interpretado, usa tipado dinámico y es multiplataforma. 

Python a diferencia de otros lenguajes de programación no usa llaves, en lugar de ellas,usa la identación para reconocer los bloques de código. Por esta razón, y al no usar punto y coma al final de cada sentencia es uno de los lenguajes más legibles y fáciles de codificar.

![Python](http://es.scoda.okfn.org/files/2017/07/python-logo-master-v3-TM-flattened.png)

## Primer hola mundo en python

Para hacer nuestro primero `hola mundo` en python, usamos la función **print();**
```python
print("Hola mundo")
```

Si creamos un archivo con esta línea de código, debemos ubicarnos en la carpeta raíz y a partir de ella ejecutar el comando python, indicando luego el archivo que queremos ejecutar. Por ejemplo

``python holamundo.py`

*La extensión de python `.py`*

En python los comentarios se pueden poner de dos formas:

- Escribiendo el símbolo almoadilla (`#`) delante de la línea de texto donde está el comentario.
- Escribiendo triple comilla doble (`"""`) al principio y al final del comentario (que puede ocupar más de una línea).

```python
# Este es un comentario de una sola línea
 
""" Este es un comentario multilinea. ""
```

## ¿Cómo funciona una variable?

las variables son espacios en memoria, son como cajas donde podemos guardar valores de un sólo tipo de dato. 

Hay otro tipo de variables que son llamadas **constantes** este tipo de variable no cambia su valor durante la ejecución del programa.

El signo __+__ funciona como operador de concatenación de 2 variables de tipo texto. Concatenar, quiere decir unir dos textos en uno solo.

## Lectura de Datos

Para leer datos por consola en python, debemos usar la función **input()** precedida de una variable donde queremos que se almacene el valor que digitemos.

```python
nombre = input()
```

## Operadores Aritméticos

Son parte esencial de la programación. Éstos operadores aritméticos son:
- `+` Suma o concatenación
- `-` Resta
- `/` Division
- `*` Multiplicación
- `%` Módulo (Resto o residio de la división)

Con la función **int()** convertimos una cadena de texto u otro valor a tipo de dato entero.
`int(input())` De esta forma estammos convirtiendo el texto a un número entero

La función **str()** convierte un tipo de dato a cadena de texto (string)


## Operadores de comparación

Estos operadores, no permiten comparar 2 valores. Los operadores de comparación son:
- `>` Mayor que
- `<` Menor que
- `>=` Mayor o igual que
- `<=` Menor o igual que
- `==` Igual a
- `===` Idéntico (Quiere decir que tiene el mismo valor y tipo de dato)

Los operadores de comparación son muy usados junto con las estructuras de control como los condicionales. Un ejemplo de operadores de comparación con condicionales es el siguiente:

```python
print("Ingresa su edad")
edad = int(input())

if (edad > 18):
    print("Eres mayor de edad")
elif (edad == 18):
    print("Tienes justo la edad de mayor de edad")
else:
    print("Eres menor de edad")
```

## Casting (Conversión de tipos de datos)

Muchas veces para poder trabajar con la información, es necesario que sean del tipo de dato necesario para hacer comparaciones, sumas y demás. 

Por defecto al usar la función `input()`, estamos esperando que el usuario digite un valor por teclado, entonces python lo reconocerá como texto. 

El Casteo o casting, se le conoce al proceso de conversión de un tipo de dato a otro. Algunas funciones para conversión de tipos son:
- **int()** Convierte de string a entero
- **float()** Convierte de string o entero a decimal
- **str()** Convierte un número a decimal

## Arreglos

Son variables que pueden almacenar más de un valor, es como guardar muchas cosas en una sola caja.

Los arreglos están formados por una colleción de datos, sean números o cadenas de caracteres, pero siempre del mismo tipo de dato.

Para declarar un arreglo se colocan dentro de corchetes.
```python
numbers = [1,2,3,4,5]

''' Imprime 1
print(numbers[0])
```

Para acceder a un valor del arreglo, debemos acceder a la posición en el que se encuentre. La posición inicia desde 0.

## Funciones

Las funciones están definidas por un conjunto de lineas de código, las cuales realizan una función específica. Las funciones nos permiten descomponer los problemas, en tareas pequeñas.

Para declarar una función, debemos usar la palabra reservada **def** seguido el nombre de la función con *()* al final de la palabra

```python
# Definicion de la función
def saludar():
    print("Hola, bienvenido al mundo de la programación")

# LLamada a la función
saludar()
```

### Los argumentos

Los argumentos nos permiten recibir valores del exterior para usarlas en las funciones.

```python
def saludo(nombre):
    return "Hola {}, bienvenido".format(nombre)

print("Ingresa tu nombre")
nombre = input()
print(saludo(nombre))
```

## Los ciclos

Son bloques de código que realizan tareas repetitivas, pueden ejecutar acciones cierto número de veces mientras una condición se cumpla

### Ciclo while

Repite un bloque de código mientras se  cumpla una condición.
```python
rep = 0
while rep <= 3:
    print("Mensaje")
    rep+=1

print("El ciclo se terminó")
```

### Ciclo For

Repite un bloque de código un determinado número de veces, dependiendo de la condición que tengamos.

```python
numbers = [1,2,3,4,5,]
nombre = "Johan Camilo"

# Imprime cada letra de la variable nombre en una nueva línea
for elemento in nombre:
    print(elemento)
```

En python, podemos usar el ciclo for, para imprimir items de un arreglo o cadenas de caracteres como en el ejemplo anterior