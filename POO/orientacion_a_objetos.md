# Orientación a Objetos

## Objetos

Los Objetos son aquellos que tienen propiedades y comportamientos, también serán sustantivos.

- Pueden ser Físicos o Conceptuales

Las **Propiedades** también pueden llamarse atributos y estos también serán sustantivos. Algunos atributos o propiedades son nombre, tamaño, forma, estado, etc. Son todas las características del objeto.

Los **Comportamientos** serán todas las operaciones que el objeto puede hacer, suelen ser verbos o sustantivos y verbo. Algunos ejemplos pueden ser que el usuario pueda hacer login y logout.

## Abstracción y Clases

Una **Clase** se el modelo por el cual nuestros objetos se van a construir y nos van a permitir generar más objetos.

Analizamos Objetos para crear Clases. Las **Clases** _son los modelos sobres los cuales construiremos nuestros objetos_.

**Abstracción** es cuando separamos los datos de un objeto para generar un molde.

## Modularidad

La **modularidad** va muy relacionada con las clases y es un principio de la Programación Orientado a Objetos y va de la mano con el Diseño Modular que significa dividir un sistema en partes pequeñas y estas serán nuestros módulos pudiendo funcionar de manera independiente.

La **modularidad** de nuestro código nos va a permitir

- Evitar colapsos
- Hacer nuestro código más mantenible
- Legibilidad
- Resolución rápida de problemas

Una buena práctica es separando las clases en archivos diferentes.

## Análisis en Programación Orientada a Objetos.

1. Identificar el problema
2. Identificar los objetos
3. Definir las clases
4. Implementar las clases

Las clases se definen así en los diferentes leguajes de programación

```php
// PHP
class Person{

  $name = "";
  function walk(){}

}
```

```java
// Java
class Person {

  String name = "";
  void walk(){}

}
```

```python
# Python
class Person:

  name = "";
  def walk():

```

```js
// Javascript
function Person() {}

Person.prototype.walk() = function() {};
```

## ¿Qué es la herencia?

**Don’t repeat yourself** es una filosofía que promueve la reducción de duplicación en programación, esto nos va a inculcar que no tengamos líneas de código duplicadas.

Toda pieza de información nunca debería ser duplicada debido a que incrementa la dificultad en los cambios y evolución

La **herencia** nos permite crear nuevas clases a partir de otras, se basa en modelos y conceptos de la vida real. También tenemos una jerarquía de **padre e hijo**.

## Clases, Objetos y Método Constructor

En python de usa lowerCamelCase para nombrar los archivos, pero para los nombres de las clases se usa UpperCamelCase

Para agregar soporte de PHP en VSCode, debemos agregar el intérprete en las configuraciones del sistema.

Los dos codigos que van en la configuracion de VSCODE

- `"php.executablePath": "C:/xampp/php/php.exe"`

- `"php.validate.executablePath": "C:/xampp/php/php.exe"`

Ruta variables de entorno

- `C:\xampp\php`

## Objetos, método constructor y su sintaxis en código

Los **objetos** nos ayudan a crear instancia de una clase, el objeto es el resultado de lo que modelamos, de los parámetros declarados y usaremos los objetos para que nuestras clases cobren vida.

Los **métodos constructores** dan un estado inicial al objeto y podemos añadirle algunos datos al objeto mediante estos métodos. Los atributos o elementos que pasemos a través del constructor serán los datos mínimos que necesita el objeto para que pueda vivir.

Declaración de objetos en los diferentes lenguajes

```java
// Java
Person person = new Person();
```

```python
# Python
persona = Person()
```

```js
// Javascript
var person = new Person();
```

```php
// php
$person = new Person();
```

**Método constructor**

- Dar un estado inicial al objeto
- Tiene el mismo nombre de la clase (En algunos lenguajes)
- Son los parámetros mínimos que necesita el objeto para que pueda vivir.

Métodos constructores en distintos lenguajes

```php
// PHP
class Person{

  public $name;

  public function __construct($name){
    $this->name = name;
  }

}
```

```java
// Java
class Person {

  String name = "";

  public Person(String name){
    this.name = name;
  }

}
```

```python
# Python
class Person:

  name = "";

  def __init__(self, name):
    self.name = name;

```

```js
// Javascript
function Person(name) {
  this.name = name;
}
```

En python con **`print(vars(car))`** se imprimen todos las variables del objeto.
