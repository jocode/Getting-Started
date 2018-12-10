# Instalar Lamp

> **Importante**
> El símbolo `^` el linux, significa `ctrl`, por ejemplo si aparece `^+W` es la tecla `ctrl+w`

A continuación se configura el servidor apache con los motores de base de datos MySQL, postgress y sqlite3

Primero instalaremos a instalar apache2, php7, mysql 5.6 y algunas librerías

* `sudo apt-get install apache2 mysql-server php libapache2-mod-php php-mcrypt php-mysql php-cli mcrypt php-pear`

Si por alguna razón el paquete *php-mcrypt* no está disponible, eliminarlo del comando

Otras librerías importantes

* `sudo apt-get install php-gd php-intl php-readline`

El parámetro *php-gd* para trabajar con imágenes como los captcha

Instalar mbstring

* `sudo apt-get install php-mbstring php7.0-mbstring php-gettext libapache2-mod-php7.0` 

Habilitamos el mcrypt y mbstring

* `sudo phpenmod mcrypt`
* `sudo phpenmod mbstring`

Habilitar el mod_rewrite para trabajar con urls enriquecidas

* `sudo a2endmode rewrite`


## Reiniciar el servidor Apache

Para reiniciar el servidor *apache* ejecutamos el siguiente comando.

* `service apache2 restart`

Para mysql, también podemos ejecutar ese comando para mysql.

- **start** Inicia el servicio
- **stop** Detiene el servicio que le indiquemos


### Instalar sqlite3

Para instalar sqlite y el respectivo soporte para php, lo hacemos mediante el siguiente comando

- `sudo apt-get install sqlite php-sqlite3`

### Instalar Postgresql

Para instalar postgresql, su respectivo soporte para php y la herramienta pgadmin

`sudo apt-get install postgresql postgresql-contrib pgadmin3 pgagent php-pgsql`


### Instalar soporte de MySQL para python

Para instalar el soporte de MySQL para python, lo instalamos mediante el siguiente comando.

- `sudo apt-get install python-mysqldb`


### Cambiar la carpeta de trabajo por defecto `/var/www/html`

Si deseamos cambiar la carpeta de trabajo por defecto que se encuentra en `/var/www/html` debemos modificar  el archivo de configuración de apache 

* `sudo nano /etc/apache2/apache2.conf`

Allí buscamos la directiva *Directory* y configuramos la carpeta que deseemos

```xml
<Directory /home/username/public_html/>
	Options indexes FollowSymLinks
	AllowOverride All
	Require all granted
</Directory>
```

Luego se hacer esta modificación, reiniciamos apache 

* `sudo service apache2 restart`

Es importante que en *AllowOverride* esté en All para permitir las urls amigables

Luego modificamos el archivo de sitios

* `sudo nano /etc/apache2/sites-enabled/000-default.conf`

Buscamos la línea de `DocumentRoot`, la comentamos y agregamos la nuestra

```
#DocumentRoot /var/www/html 
DocumentRoot /home/user/public_html
```

Una vez terminada la configuración p después de cualquier cambio es importante reiniciar el servidor.

* `sudo service apache2 restart`

## Dar permisos de escritura

Para permisos de escritura en linux, ejecutamos el siguiente comando en consola.

* `sudo chmod +w -R carpeta/`

El parámetro **+w** da permisos se escritura para la carpeta

El parámetro **-R** le da permiso de escritura a todas las carpetas contenidas en la carpeta raíz (Que le hemos especificado)


## Ingresar a mysql por consola

Para ingresar a mysql por consola, podemos usar el comando 

* `mysql -u root -p`

*root* es el nombre de usuario, y con *-p* le indicamos la contraseña

## Instalar phpMyAdmin

1. Instalarlo desde los repositorios

	* `sudo apt-get install phpmyadmin`

	Los paquetes recomendados
	- `php-gd`
	- `php-tcpdf`

	* `sudo apt-get install php-gd php-tcpdf`

2. Configurar apache para que tome la ruta, para eso debemos abrir el archivo `/etc/apache2/apache2.conf` y agregamos las siguientes líneas 

	* `sudo nano /etc/apache2/apache2.conf` 

	O abrir el archivo con sublime 

	* `sudo subl /etc/apache2/apache2.conf` 

```
# phpMyAdmin Configuration
Include /etc/phpmyadmin/apache.conf
```

3. Guardar el archivo y reiniciar apache 

	* `sudo service apache2 restart`


Después de eso se podrá ingresar desd *htt//localhoost/phpmyadmin*

Para instalar LAMPP se puede usar el siguiente comando 

* `sudo apt-get install mysql-server-5.6 php5 apache2 php5-mysql`


> Si por algún motivo, durante la instalación aparece el siguiente error `Access denied for user 'root'@'localhost'` podemos solucionarlo siguiendo los pasos en este enlace:

- [Access denied for user 'root'@'localhost'](https://stackoverflow.com/questions/39281594/error-1698-28000-access-denied-for-user-rootlocalhost)
- [Habilitar la contraseña para el root en Linux](http://www.conchaalviz.com/blog/como-habilitar-contrasena-para-el-root-de-mysql-en-linux/)

Por defecto, mysql no permite dejar espacio en blanco para la contraseña.

Estos errores, pueden arreglarse, al crear la contraseña e instalar los paquetes recomendados. Con eso, se garantiza una buena instalación del gestor de base de datos.



## Ver los errores de Apache 

Para ver los errores de apache, es necesario ir a la ruta `/var/log/apache2/error.log`. En este archivo, se registran todos los errores que hayan en el servidor y en los proyectos qe estemos desarrolando.

En caso de cualquier problema, puede ser por la versión de php, al incluir nuevas reglas para la programación. Para eso, copiar el error tal cual y buscarlo, porque los errores pueden ser aleatorios. 

## Ver el valor de `sql_mode` de MySQL

Esta configuración de mysql, en algunas ocasiones no deja ingresar valores vacíos en los autoincrementables

Para ver la configuración, podemos ingresar el siguiente comando 

* `mysql -u user -p` 

Ingresar el usuario, reemplazar *user* por el que tenga y escribir la contraseña 

* `mysql> SELECT @@sql_mode;` 

Luego que esté dentro, vemos la configuración de este parámetro. En algunos casos puede ser este por defecto. 

`ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION`


Para cambiar este parámetro y que nos permite ingresar datos vacíos como `' '` debemos cambiar el **sql_mode**, y lo podemos hacer de la siguiente manera


Si en la consola, ejecutamos la consulta 

* `SELECT @@GLOBAL.sql_mode;`

Nos arrojara esto:
`ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION`

Podemos cambiarlos a 

* `SET GLOBAL sql_mode = '';`

De esta manera, nos dejar+a ingresar valores vacíos en los campos, pero no es lo más recomendable.


*Ver la información* https://stackoverflow.com/questions/35037288/incorrect-decimal-integer-value-mysql#35037657

Sin embargo, con esta configuración debemos cada vez que se reinicie el servidor, se reestablecen los valores. Para solucionar esto, debemos dejar configurado este desde la configuración de mysql. 

Este archivo de configuración lo encontramos en **`/etc/mysql/my.cnf`**, en la sección *mysqlid*

Luego que estemos en este archivo, debemos colocar la siguiente sentencia, para indicar la configuración.

```sql
[mysqld]
sql-mode=""
```

Hay que estar seguros que se tenga **sql-mode** y no guiones bajos y sin comillas dobles en versiones mysql  5.7.8 or mayores.

*Para más información ver* [Configuración global de sql_mode en mysql](https://stackoverflow.com/questions/2317650/setting-global-sql-mode-in-mysql#26104070)

