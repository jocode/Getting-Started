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
