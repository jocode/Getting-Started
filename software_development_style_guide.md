# Guías de Estilo (Convenciones de Nombres)

Uso de escritura en tipo CamelCase.
* __UpperCamelCase__ Cuando la primera letra de cada una de las palabras es mayúscula. Ejemplo: `EjemploDeUpperCamelCase`.
* __lowerCamelCase__ Igual que la anterior con la excepción de que la primera letra es minúscula. Ejemplo: `ejemploDeLowerCamelCase`.
* __lowercase__ Todas las palabras en minúsculas. Ejemplo: `ejemplodelowercase`
* __uppercase__ Toas las palabras en mayúsculas. Ejemplo: `EJEMPLODEUPPERCASE`

Para los dos últimos casos, es importante separar cada palabra con guión bajo `_`, por ejemplo `ejemplo_de_lowercase` y `EJEMPLO_DE_UPPERCASE`, de esta forma se podrá leer mejor.

## Bases de Datos 

Algunos prefijos usados en bases de datos son:
* __PK__: Primary key
* __DF__: Default
* __CK__: Check constraint
* __FK__: Foreign Key


Generalmente hay un debate en las convenciones de nombres. Cada uno de ellos son subjetivos dependiendo de la empresa o gustos personales.

En este caso estableceremos algunas convenciones para las bases de datos.

* **Reglas Generales**
	- Evitar espacios en blanco
	- No usar palabras clave reservadas por el motor de base de datos, en el nombre se las entidades o campos.
	- Evitar nombrar campos con valores de tipos de datos (text...)
	- Ser explícito en el nombrado de datos.
	- Usar inglés en el nombrado, por ser más compacto y no tener caracteres especiales.

* **Tablas y Vistas**
	- Usar sustantivos (Nombres) en singular, y con la estructura UpperCamelCase
	  _Person_, _User_, etc. Para las entidades.
	- Evitar el uso de prefijos y sufijos, porque son redundantes y resultan difíciles para determinar el objeto rápidamente.

* **Claves y campos**
	- **Clave Primaria** Nombrar la columna de clave primaria con un simple `id`
	- **Clave foránea** Nombrar el campo con el nombre de la tabla referenciada y el id. Por ejemplo `person_id`
	- Para el nombrado de campos usar lowercase con uso de guines bajos, separando cada palabra. Por ejemplo `expiration_date`

* **Restricciones (Relaciones)**
	- Usar una mezcla de prefijo, nombre de tabla y nombre de campo, usando UpperCamelCase, con guiones bajos. Por ejemplo: `FK_Order_CustomerId`

De esta manera estamos indicando la relación a la llave foránea, indicando la tabla referenciada y el campo que almacena la clave foránea de la tabla.

* **Procedimientos almacenados y funciones**
	- En estos casos, mezclar el nombre del objeto (Entidad o Tabla) en combinación con un verbo separado por guión bajo, usando UpperCamelCase.
	Por ejemplo: `Customer_GetAll`  `Customer_Insert`

