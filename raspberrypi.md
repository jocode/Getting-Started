# :rocket: Guía de instalación para Raspberry PI :white_check_mark:

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

- Ver la guía [Cómo configurar Raspberry Pi Zero W en modo Headless vía WiFi](https://mecatronicauno.com/configurar-raspberry-pi-zero-w-modo-headless-via-wifi/)
- Recomendado: [Cómo instalar Raspbian en Raspberry](www.youtube.com/watch?v=fFj3a4qtTkA)

Para ello necesitamos algunos programas **nmap**, que lo usaremos para escanear que dispositivos están conectados a la red para saber la IP del dispositivo.

En linux podemos instalarlo usando

- **`sudo apt-get install nmap`**

Para escanear las IPs usamos

- `nmap -sn 192.168.0.0/24` Escanea los primeros 24 dispositivos

Para escanear las IPs de la red local usamos

- `nmap -sn 192.168.0.0/24 -oG-`

O descargar el programa [Advanced IP Scanner](https://www.advanced-ip-scanner.com/es/) Es un software grafico que escanea una red en cuestión de segundos

### Putty

Para conectarnos por SSH podemos usar Putty para windows o usar git bash si tienen instalado git.

GPIO Hammer Header (Solderless) - Para la conexión en Raspberry Pi Zero W

[VNC-Connect-and-Raspberry Pi](https://help.realvnc.com/hc/en-us/articles/360002249917-VNC-Connect-and-Raspberry-Pi#operating-vnc-server-at-the-command-line-0-6)

## :zap: Configurando Raspberry Pi para conexión por SSH

> Por defecto la conexión **ssh** no está habilitada en la raspberry Pi. Para ello debemos habilitar la opción usando.

1. Insertamos la memoria microSD en el PC y vamos a la carpeta **boot**
2. Creamos una archivo **ssh** sin extensión. Con windows podemos usar PowerShell y escribir

- `type nul > ssh` (Ésto nos creará el archivo con nombre ssh)

3. Desconectamos la tarjeta y la insertamos en la Raspberry Pi.

**_Es importante ver la guía 'Cómo configurar Raspberry Pi Zero W en modo Headless vía WiFi, esto nos permitirá conectar la tarjeta a la red WiFi para poder identificarla sin tener que usar monitor, teclado y mouse._**

Sin para conectarla por wifi, sólo debemos crear el siguiente archivo en la misma carpeta donde se ha colocado el archivo `ssh`. Este archivo lleva el nombre de **`wpa_supplicant.conf`**

```
country=CO
ctrl_interface=DIR=/var/run/wpa_supplicant GROUP=netdev
update_config=1
network={
ssid="NombreDeMiRedWiFi"
psk="ContraseñaDeMiRedWiFi"
key_mgmt=WPA-PSK
}
```

Donde debemos cambiar el país (**Country**) y el nombre y contraseña de la red a la cual estamos conectados. (Esto es si no se tiene un cable ethernet, o si si se quiere conectar vía WIFI para evitar cables)

Con esto, al conectar la Raspberry se conectará a la red ya podrá ver el dispositivo conectado.

Si lo deseas, puedes incluir más de una red _wpa_supplicant_ seleccionará la red que califica como la mejor opción basada en:

- Orden de redes en el archivo wpa_supplicant.conf
- Nivel de seguridad (se prefiere WPA2)
- Intensidad de señal
  Al hacerlo se verá algo como esto:

```
# Red 1
network={
ssid="SSID1"
psk="password1"
key_mgmt=WPA-PSK
}

# Red 2
network={
ssid="SSID2"
psk="password2"
key_mgmt=WPA-PSK
}
```

### :lock: Conexión SSH

Para conectar por SSH podemos usar la terminal de Windows CMD, o usar Putty, (Es un programa que debemos descargar) o mediante GitBash si tienen git instalado.

En putty, escribimos la ip a la cual está conectada la tarjeta y las contraseña por defecto es **raspberry**

Usando la terminal, bien sea CMD, o la del sistema operativo que tengamos, digitamos **SSH** y colocamos los siguientes comandos. Recordar que por defecto raspberry tiene el usuario **pi**:

- **`ssh pi@192.168.0.x`**
- Ingresamos la contraseña, por defecto es **_raspberry_**

* **`sudo apt-get install screenfetch`** Instala in programa que nos permite ver las características del dispositivo

Para **cambiar las configuraciones en la raspberry**, de puede acceder a:

- **`sudo raspi-config`**

Esto nos abrirá las opciones para configurar raspberry pi

:star: Para hablitar la opción de VNC (Para ver la interfaz desde otro computador), debemos seleccionar la opción

- Interface Option
  - VNC (Habilitar o deshabilitar la opción gráfica remota)

Aquí se puedes cambiar otras opciones como la contraseña o el usuario de la tarjeta conectada a la red.

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

## :eyes: :star: Instalando OpenCV en Raspberry Pi

**REF** [Cómo instalar OpenCV en Raspberry Pi](https://omes-va.com/como-instalar-opencv-en-raspberry-pi/)

Previo a la instalación de OpenCV en python 3, necesitamos instalar algunos paquetes, esto lo haremos a través de la siguiente línea:

- `sudo apt-get install libhdf5-dev libhdf5-serial-dev libatlas-base-dev libjasper-dev libqtgui4 libqt4-test`

> Es importante ejecutar la línea anterior para un correcto funcionamiento

### Instalando OpenCV 4 en Raspberry Pi

Vamos a instalar la versión de OpenCV 4.1.0.25. Usamos pip3 install `opencv-contrib-python`, tal y como lo hicimos en la instalación de OpenCV en Windows, empleamos contrib para que se instalen los módulos principales y extras.

- `pip3 install opencv-contrib-python==4.1.0.25`

## Comprobar que OpenCV 4 se ha instalado correctamente en la Raspberry Pi

Para comprobar que se ha instalado OpenCV, digitamos python3 en el terminal e importamos OpenCV para finalmente imprimir la versión instalada.

Digitamos python3 y escribimos los siguiente. Esto nos debería arrojar

```py
import cv2
cv2.__version__
# 4.1.0
```

- **Probando con una imagen**

```py
import cv2

image = cv2.imread('nombreimagen.jpg')
cv2.imshow('Imagen', image)
cv2.waitKey(0)
cv2.destroyAllWindows()
```

- **Reproducir un vídeo**

```py
import cv2

cap = cv2.VideoCapture('nombrevideo.avi')

while (cap.isOpened()):
  ret, frame = cap.read()

  cv2.imshow('Video', frame)

  if cv2.waitKey(25) & 0xFF == 27: # Si se presiona ESC cerramos el ciclo
    break

cap.release()
cv2.destroyAllWindows()
```

## Extras para mejor funcionamiento en Raspberry Pi Zero W

**REF** [Installing OpenCV in PiZeroW](https://towardsdatascience.com/installing-opencv-in-pizero-w-8e46bd42a3d3)

1. Expander el sistema de archivos

Expandemos el sistema de archivos para no tener problemas de espacio de almacenamiento

- **`sudo raspi-config --expand-rootfs`**

2. Aumentar espacio de intercambio

El espacio de intercambio es una parte de una unidad de disco duro (HDD) que se utiliza para la memoria virtual. Tener un archivo de intercambio permite que el sistema operativo de su computadora simule que tiene más RAM de la que realmente tiene. Esto aumentará el proceso de compilación de openCV. De lo contrario, terminará con un error de memoria agotada.
Para aumentar el tamaño de Swapsize, abra el archivo de intercambio de su pi zero con el siguiente comando:

- **`sudo nano /etc/dphys-swapfile`**

Vaya a Cambiar tamaño y cámbielo a 2048 desde 100. como se muestra a continuación.

```
.
# where we want the swapfile to be, this is the default
#CONF_SWAPFILE=/var/swap
# set size to absolute value, leaving empty (default) then uses computed value
#   you most likely don't want this, unless you have an special disk situation
#CONF_SWAPSIZE=100
CONF_SWAPSIZE=2048
.
```

**_Reiniciamos el sistema_**

- **`sudo reboot`**

## Installing dependencies

Primero vamos a actualizar y actualizar los paquetes existentes:

- **`sudo apt-get update`**
- **`sudo apt-get upgrade`**

Si está utilizando **Raspbian Buster**, ejecute el siguiente comando:

- **`sudo apt update`**
- **`sudo apt upgrade`**

Instalar las herramientas de desarrollo

- **`sudo apt-get install build-essential cmake pkg-config`**

Instale los paquetes IO:

- **`sudo apt-get install libjpeg-dev libtiff5-dev libjasper-dev libpng12-dev`**

Junto con algunos paquetes de E / S de video (aunque es poco probable que realice un gran procesamiento de video con Raspberry Pi Zero):

- **`sudo apt-get install libavcodec-dev libavformat-dev libswscale-dev libv4l-dev`**
- **`sudo apt-get install libxvidcore-dev libx264-dev`**

Necesitaremos instalar la biblioteca de desarrollo GTK para la interfaz GUI de OpenCV:

- **`sudo apt-get install libgtk2.0-dev`**

Y paquetes de optimización de rutina apalancados por OpenCV:

- **`sudo apt-get install libatlas-base-dev gfortran`**

El único requisito para construir enlaces de Python + OpenCV es tener instalado NumPy, así que instale NumPy usando pip:

- **`pip3 install numpy`**

Finalmente todos los comandos son:

```
1. sudo apt-get update & sudo apt-get upgrade & sudo rpi-update
2. sudo nano /etc/dphys-swapfile
    CONF_SWAPSIZE=2048
3. sudo apt-get install build-essential cmake pkg-config
4. sudo apt-get install libjpeg-dev libtiff5-dev libjasper-dev libpng12-dev
5. sudo apt-get install libavcodec-dev libavformat-dev libswscale-dev libv4l-dev
6. sudo apt-get install libxvidcore-dev libx264-dev
7. sudo apt-get install libgtk2.0-dev libgtk-3-dev
8. sudo apt-get install libatlas-base-dev gfortran
- sudo apt install libqtgui4  (Por si lanza error en ImportError: libQtGui.so.4)
```

**Prerrequisitos** :star: [`pip install opencv`](https://www.pyimagesearch.com/2018/09/19/pip-install-opencv/#download-the-code)

```
$ sudo apt-get install libhdf5-dev libhdf5-serial-dev libhdf5-100
$ sudo apt-get install libqtgui4 libqtwebkit4 libqt4-test python3-pyqt5
$ sudo apt-get install libatlas-base-dev
$ sudo apt-get install libjasper-dev
```

:star: **REF** [Install OpenCV 4 on Raspberry Pi 4](https://www.pyimagesearch.com/2019/09/16/install-opencv-4-on-raspberry-pi-4-and-raspbian-buster/)

Si tiene un módulo de cámara Raspberry Pi conectado a su RPi, también debe instalar la API PiCamera ahora:

- **`pip3 install "picamera[array]"`**

- **`pip3 install opencv-contrib-python==4.1.0.25`**

**NOTA** No haga este paso si ha realizado el anterior

Avancemos y descarguemos el código fuente de OpenCV para los repositorios opencv y opencv_contrib, seguido de desarchivarlos:

```
- $ cd ~
- $ wget -O opencv.zip https://github.com/opencv/opencv/archive/4.1.1.zip
- $ wget -O opencv_contrib.zip https://github.com/opencv/opencv_contrib/archive/4.1.1.zip
- $ unzip opencv.zip
- $ unzip opencv_contrib.zip
- $ mv opencv-4.1.1 opencv
- $ mv opencv_contrib-4.1.1 opencv_contrib
```

Y... eso es todo amigos :octocat:
