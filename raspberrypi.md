# Guía de instalación para Raspberry PI

## Instalando el SO para la tarjeta microSD

Vamos a la [página oficial](https://www.raspberrypi.org/downloads/) de Raspberry en el apartado de descargas y tenemos 2 opciones:

- Descargar el **_Raspberry Pi Imager_**, esta aplicación nos facilita el proceso de descarga y escritura del SO en la tarjeta SD (Así como Media Creation Tools de windows)
- Descargar las imágenes del sistema operativo que deseemos usar e instalar el SO en la tarjeta SD mediante programas como [Rufus](https://rufus.ie/) (Más ligero que el siguiente pero sólo funciona para Windows) o [balenaEtcher](https://www.balena.io/etcher/)
  - Raspberry OS (Antes llamado Raspbian) es el sistema operativo de Raspberry y existen [3 alternativas](https://www.raspberrypi.org/downloads/raspberry-pi-os/)
    - Raspberry Pi OS (32 bits) con escritorio y software recomendado
    - Raspberry Pi OS (32-bit) with desktop (Mejor relación)
    - Raspberry Pi OS (32-bit) Lite

También podemos seguir la [guía oficial](https://projects.raspberrypi.org/en/projects/raspberry-pi-setting-up)

## Conectando la Tarjeta

Para ello necesitamos

- Raspberry Pi
- Fuente de alimentación
- Tarjeta micro SD con Raspbian instalado
- Teclado y Mouse
- Cable HDMI

Luego seguimos el proceso de configuración del sistema operativo como el idioma deseado y la conexión a red wifi.

Para actualizar los repositorios usamos los comandos (Recordar que Raspberry OS funciona con Debian, una distribución de Linux)

- `sudo apt-get update`
- `sudo apt-get upgrade`

- **`clear`** Limpia la terminal

Por defecto, Raspberry OS crea un usuario llamado **pi** `pi@raspberrypi`

- **`pwd`** (print working directory) Muestra la ruta donde esta ubicado actualmente

- **`ls`** Mustra los archivos que hay en una carpeta

- **`cd ..`** (cd => change directory) Sube un nivel en la carpetas

- **`cd home`** Cambia de directorio a la carpeta especificada 'home'

- **`mkdir micarpeta`** (mkdir => Make Directory) Crea una carpeta con el nombre 'micarpeta'

- **`rmdir micarpeta`** Elimina la capeta 'micarpeta'

- **`touch miarchivo.txt`** Creamos un archivo llamado 'miarchivo.txt'

- **`rm miarchivo.txt`** Eliminamos el archivo con el nombre 'miarchivo.txt'

- **`nano texto.txt`** Abre un programa editor en la terminal en dónde podemos editar el contenido

`nano` no es l único editor, también está vim p `imacs`

- **`cat texto.txt`** Vemos el contenido que hay dentro de un archivo

- **`history`** Muestra el historial de los comandos digitados (Con las flechas del teclado arriba y abajo podemos navegar entre ellos)

- **`rm -rf micarpeta`** Elimina una carpeta que contiene archivos

## **`apt`** Advance Packaging Tool

Raspberry OS es basado en Debian. El administrador de paquetes en un programa que administra otros paquetes. Con él podemos instalar y remover paquetes de software.

- **`sudo`** (SuperUser DO) Debemos digitar este comando cuando deseemos instalar paquetes que requieran privilegios

- **`sudo apt-get dist-upgrade`** Actualiza y remueve los programas que ya están obsoletis

- **`sudo apt-get install screenfetch`** Con este comando instalamos programas, éste programa **screenfetch** se ejecuta desde consola y muestra las propiedades del sistema Operativo

Como Raspberry en un mini computador, podremos programar en él.

## **Headless Mode** Modo sin periféricos

Apagamos la Raspberry Pi. Luego de apagado se puede desconectar.

Ver la guía [Cómo configurar Raspberry Pi Zero W en modo Headless vía WiFi](https://mecatronicauno.com/configurar-raspberry-pi-zero-w-modo-headless-via-wifi/)

Para ello necesitamos algunos programas **nmap**, que lo usaremos para escanear que dispositivos están conectados a la red para saber la IP del dispositivo.

En linux podemos instalarlo usando

- **`sudo apt-get install nmap`**

Para escanear las IPs usamos

- `nmap -sn 192.168.1.0/24` Escanea los primeros 24 dispositivos

Para escanear las IPs de la red local usamos

- `nmap -sn 192.168.1.0/24 -oG-`

### Putty

Para conectarnos por SSH podemos usar Putty para windows o usar git bash si tienen instalado git.

GPIO Hammer Header (Solderless) - Para la conexión en Raspberry Pi Zero W

[VNC-Connect-and-Raspberry Pi](https://help.realvnc.com/hc/en-us/articles/360002249917-VNC-Connect-and-Raspberry-Pi#operating-vnc-server-at-the-command-line-0-6)

## Conectando Raspberry Pi por SSH

> Por defecto la conexión **ssh** no está habilitada en la raspberry Pi. Para ello debemos habilitar la opción usando.

1. Insertamos la memoria microSD en el PC y vamos a la carpeta **boot**
2. Creamos una archivo **ssh** sin extensión. Con windows podemos usar PowerShell y escribir

- `type nul > ssh` (Ésto nos creará el archivo con nombre ssh)

3. Desconectamos la tarjeta y la insertamos en la Raspberry Pi.

**_Es importante ver la guía ''Cómo configurar Raspberry Pi Zero W en modo Headless vía WiFi, esto nos permitirá conectar la tarjeta a la red WiFi para poder identificarla sin tener que usar monitor, teclado y mouse._**

Para conectar por SSH podemos usar Putty, que es un programa que debemos descargar, o han trabajado con Git, se puede hacer mediante GitBash

Eb putty, escribimos la ip a la cual está conectada la tarjeta y las contraseña por defecto es **raspberry**

En **SSH** usando GitBash colocamos los siguientes comandos, recordar que por defecto raspberry tiene el usuario **pi**:

- **`ssh pi@192.168.0.x`**
- Ingresamos la contraseña, por defecto es **_raspberry_**

Para cambiar las configuraciones en la raspberry, de puede acceder a:

- **`sudo raspi-config`**

Esto nos abrirá las opciones para configurar raspberry pi

Para hablitar la opción de VNV (Para ver la interfaz desde otro computador), debemos seleccionar la opción

- Interface Option
  - VNC (Habilitar o deshabilitar la opción gráfica remota)

### Instalando VNC en Raspberry Pi

Debemos tener instalado el programa que nos permite realizar la conexión remota. Para ello debemos instalar el paquete en linux mediante

- `sudo apt-get install -y realvnc-vnc-server realvnc-vnc-viewer`

Esto nos descargará los archivos necesarios para realizar la conexión y ver la interfaz gráfica.

- `vncserver` (Con este comando ejecutamos el programa)

Este programa ejecuta el programa y nos muestra las opciones para poder conectarnos desde el otro ordenador.

### Instalando VNC Viewer en el PC

Se necesita descargar el programa en el PC para poder realizar la conexión. Luego de tenerlo instalado, lo abrimos y vamos a la opción

- Archivo
  - Nueva Conexión

Esto nos arbirá una ventana donde debemos ingresar los datos que nos ha proporcionado la Raspberry Pi

## Apagar la Raspberry Pi usando la consola

Para apagar la raspberry Pi (Recordar que estamos trabajando con una versión de Linux), podemos ejecutar la siguientes instrucciones:

- **`sudo power off`** Apaga inmediatamente

- **`sudo poweroff`** Pregunta la contraseña del super usuario como confirmación para apagar el sistema.
