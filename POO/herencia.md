# Herencia

La **herencia** nos permite crear nuevas clases a partir de otras, se basa en modelos y conceptos de la vida real. También tenemos una jerarquía de **padre e hijo**.

La herencia permite tener las mismas propiedades de un objeto en particular. Es como si tu papá tiene color cafés, tu posiblemente heredes esta misma característica. La herencia es importante tenerla cuando los objetos tienen propiedades y funcionaliadades similares, esto nos permite matener un código limpio y poco redundante.

El **Encapsulamiento** es hacer que un dato sea inviolable, inalterable cuando se le asigne un modificador de acceso.

```java
// Java
class Student extends Person {

}
```

```php
// PHP
class Student extends Person {

}
```

```js
// Javascript
student.prototype = new Person();
```

```python
# Python
class Student(Person):
```

## Encapsulamiento

El **Encapsulamiento** es hacer que un dato sea inviolable, inalterable cuando se le asigne un **_modificador de acceso_**.

Un sinónimo de encapsulamiento es esconder algo, es decir evitar que un dato sea accedido desde otra parte.

**Los modificadores de acceso son**:

- **`public`** Todas las clases
- **`protected`** Clases, paquetes y subclases
- **`default`** Clases y paquetes
- **`private`** Clases

## Generando polimorfismo

**Polimorfismo**: Muchas formas. Poli = muchas, morfismo = formas. _NO es Poliformismo_

_**Es construir métodos con el mismo nombre pero con comportamiento diferente.**_

Son comportamientos diferentes que tienen las clases, donde un método se comparte entre varias clases y cada una lo implementa como lo requiera.

- Muchas formas
- Construir métodos con el mismo nombre pero con un comportamiento diferente.

> Al sobreescribir un método `@Override` es pieza clave que estamos usando polimorfimo

## En Resumen

- **Asociación**

Como su nombre lo dice, notarás que cada vez que esté referenciada este tipo de flecha significará que ese elemento contiene al otro en su definición. Si recuerdas la clase Car, este contenía una instancia de Driver. La flecha apuntará hacia la dependencia.

- **Herencia**

Siempre que veamos este tipo de flecha se estará expresando la herencia.
En nuestro diagrama tuvimos al menos tres familias conviviendo. La dirección de la flecha irá desde el hijo hasta el padre.

Al grupo de la superclase se puede llamar familia carro, persona, pago, etc-

- **Composición**

Pasemos a una de nuestras piezas claves, pues notarás en el centro del diagrama la clase Trip que está vinculada a User, Car, Route y Payment. La composición va a significar una asociación entre estas clases con la diferencia de que para que esta clase pueda vivir forzosamente necesita a las demás. Es decir que estas clases son obligatorias para que la clase Trip pueda existir, esta dependencia obligatoria podríamos expresarla en el método constructor de la clase Trip, pues para que un objeto pueda ser creado dependerá de que los demás existan.
