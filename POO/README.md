# Programación Orientada a Objetos: POO

Para resolver un problema como desarrollador es de gran utilidad dividirlo en subproblemas y generar un modelo que te permita implementar las soluciones en código. A lo largo de este curso vas a analizar Uber, una de las aplicaciones más usadas en el mundo, para entender cómo está construida. A partir de este análisis harás la extracción y definición de los objetos, clases y métodos que conforman la aplicación, usarás UML para modelarla y, finalmente, usando diferentes lenguajes como Java, PHP y Python harás la implementación de las clases y objetos de la aplicación.

## ¿Por qué aprender Programación Orientada a Objetos?

- **Vas a programar más rápido**. Tener un análisis previo de lo que estás realizando te ayudará a generar código mucho más veloz

-**Dejas de ser Programador Jr**. Podrás responder preguntas como ¿Qué es encapsulamiento?, ¿Qué es Abstracción?, ¿Qué es Herencia?, ¿Qué es Polimorfismo? en futuras entrevistas de trabajo

- Dejar de Copiar y Pegar Código.

- **Analizar** Problemas
  - Observación
  - Entendimiento
  - Lectura
- **Plasmar** Análisis de problemas
  - Diagramas
- **Programar**
- Lenguajes de programación

### ¿Qué resuelve la Programación Orientación a Objetos?

La programación Orientada a Objetos nace de los problemas creados por la programación estructurada y nos ayuda a resolver cierto problemas como:

- **Código muy largo**: A medida que un sistema va creciendo y se hace más robusta el código generado se vuelve muy extenso haciéndose difícil de leer, depurar, mantener.

- **Si algo falla, todo se rompe**: Ya que con la programación estructurada el código se ejecuta secuencialmente al momento de que una de esas líneas fallara todo lo demás deja de funcionar.

- Difícil de mantener.

Para más información ver [Programación orientada a objetos](https://static.platzi.com/media/public/uploads/programacion-orientada-a-objetos-poo_c4774196-cfdb-412e-bae5-210a97d78f8b.pdf)

## Paradigma Orientado a Objetos

La Programación Orientada a Objetos viene de una filosofía o forma de pensar que es la Orientación a Objetos y esto surge a partir de los problemas que necesitamos plasmar en código.

_**Es analizar un problema en forma de objetos para después llevarlo a código, eso es la Orientación a Objetos.**_

Un **paradigma** es una teoría que suministra la base y modelo para resolver problemas.

El paradigma de Programación Orientada a Objetos se compone de **4 elementos**:

- Clases
- Propiedades
- Métodos
- Objetos

Y **4 Pilares**:

- Encapsulamiento
- Abstracción
- Herencia
- Polimorfismo

## Lenguajes Orientados a Objetos

- **Java**:
  – Orientado a Objetos naturalmente
  – Es muy útilizado en Android
  – Y es usado del lado del servidor o Server Side
- **PHP**
  – Lenguaje interpretado
  – Pensado para la Web
- **Python**
  – Diseñado para ser fácil de usar
  – Múltiples usos: Web, Server Side, Análisis de Datos, Machine Learning, etc
- **Javascript**
  – Lenguaje interpretado
  – Orientado a Objetos pero basado en prototipos
  – Pensado para la Web
- C#
- Ruby
- Kotlin

## Instalando y configurando VSCode

Descargar el editor de código desde el sitio web oficial [Visual Studio Code](https://code.visualstudio.com/download). Seleccionar el paquete adecuado para el SO y seguir el proceso de instalación.

Para soportar cualquier lenguaje visitar [Programming Languages](https://code.visualstudio.com/docs/languages/overview)

**Plugins for VSCode**

- **Java**
  - Java Extension Pack
  - Debugger for Java

> Para Java es necesario descargar el OpenJDK

- **Python**
- **PHP**
  - PHP Server: Serve your Project with PHP
- **JS**
  VSCode como está construido con JS, se integra muy bien y no hay necesidad de instalar nada.

## Diagramas de Modelado

- **OMT**: Object Modeling Techniques. Es una metodología para el análisis orientado a objetos.

- **UML**: Unified Modeling Language o Lenguaje de Modelado Unificado. Tomó las bases y técnicas de OMT unificándolas. Tenemos más opciones de diagramas como lo son Clases, Casos de Uso, Objetos, Actividades, Iteración, Estados, Implementación.

## UML

Como ya viste UML significa Unified Modeling Language el cual es un lenguaje estándar de modelado de sistemas orientados a objetos.

![UML](https://static.platzi.com/media/user_upload/220px-UML_logo.svg-ffd3a6a7-ac1d-43df-8648-265767507c9a.jpg)

Las clases se representan así:

![Representación de clases](https://static.platzi.com/media/user_upload/clase-1897e6cf-84b3-4432-926b-aff4fc4db122.jpg)

En la parte superior se colocan los atributos o propiedades, y debajo las operciones de la clase. Notarás que el primer caractér con el que empiezan es un símbolo. Este denotará la visibilidad del atributo o método, esto es un termino que tiene que ver con Encapsulamiento y veremos más adelante a detalle.

Estos son los niveles de visibilidad que puedes tener:

- `- private`
- `+ public`
- `# protected`
- `~ default`

Una forma de representar las relaciones que tendrá un elemento con otro es a través de las flechas en UML, y aquí tenemos varios tipos, estos son los más comunes:

**Asociación**

![Asociación en UML](https://static.platzi.com/media/user_upload/associacion-d2e1b691-b6e9-4854-85e2-d3ffdf0a9049.jpg)

Como su nombre lo dice, notarás que cada vez que esté referenciada este tipo de flecha significará que ese elemento contiene al otro en su definición. La flecha apuntará hacia la dependencia.

Con esto vemos que la ClaseA está asociada y depende de la ClaseB.

**Herencia**

![Herencia](https://static.platzi.com/media/user_upload/herencia-2eb98d5e-bcad-4162-b236-aa87eba20e76.jpg)

Siempre que veamos este tipo de fecha se estará expresando la herencia.
La dirección de la flecha irá desde el hijo hasta el padre.

![Herencia en UML](https://static.platzi.com/media/user_upload/herencia-clases-53cb3117-def7-433f-adc5-4ad183d6b5e7.jpg)

Con esto vemos que la ClaseB hereda de la ClaseA

**Agregación**

![Agregación en UML](https://static.platzi.com/media/user_upload/agregacion-6489d946-cc06-4e3c-a976-f6435531b4f2.jpg)

Este se parece a la asociación en que un elemento dependerá del otro, pero en este caso será: Un elemento dependerá de muchos otros. Aquí tomamos como referencia la multiplicidad del elemento. Lo que comúnmente conocerías en Bases de Datos como Relaciones uno a muchos.

![Agregración](https://static.platzi.com/media/user_upload/uml-relacion-agregacion-adb20be8-d6c2-41d1-b002-2cfa37639240.jpg)

**Composición**

![Composición](https://static.platzi.com/media/user_upload/composicion-1da1dd19-6925-42d9-9727-7fd8cb031b0c.jpg)

Este es similar al anterior solo que su relación es totalmente compenetrada de tal modo que conceptualmente una de estás clases no podría vivir si no existiera la otra.

!(Composición)[https://static.platzi.com/media/user_upload/uml-relacion-composicion-2d4cb1fa-5422-44e3-849b-3a3e2d276733.jpg]

Estos son los conceptos básicos del Lenguaje de Modelado unificado y las representaciones que tienen sus figuras.

Para seguir los conceptos de UML y POO, ver los siguientes temas

- Orientación a Objetos
- Programación Orientada a Objetos. Análisis
- Clases, Objetos y Método Constructor
- Herencia
- Encapsulamiento
- Polimorfismo
