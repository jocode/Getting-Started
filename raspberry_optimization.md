# Optimizando OpenCV en la Raspberry Pi

:octocat: https://github.com/opencv/opencv_contrib/releases

- :star: [Install OpenCV 4 on your Raspberry Pi](https://www.pyimagesearch.com/2018/09/26/install-opencv-4-on-your-raspberry-pi/)
- :star: [Optimizing OpenCV on the Raspberry Pi](https://www.pyimagesearch.com/2017/10/09/optimizing-opencv-on-the-raspberry-pi/)
- [Raspbian Stretch: Install OpenCV 3 + Python on your Raspberry Pi](https://www.pyimagesearch.com/2017/09/04/raspbian-stretch-install-opencv-3-python-on-your-raspberry-pi/)
- [Building a Raspberry Pi security camera with OpenCV](https://www.pyimagesearch.com/2019/03/25/building-a-raspberry-pi-security-camera-with-opencv/)
- [Home surveillance and motion detection with the Raspberry Pi, Python, OpenCV, and Dropbox](https://www.pyimagesearch.com/2015/06/01/home-surveillance-and-motion-detection-with-the-raspberry-pi-python-and-opencv/)
- [Tutorial de python Virtualenv](https://rukbottoland.com/blog/tutorial-de-python-virtualenv/)

# NEON and FVPV3

ARM NEON es una extensión de arquitectura de optimización para procesadores ARM. Fue diseñado por los ingenieros de ARM específicamente para un procesamiento de video, procesamiento de imágenes, reconocimiento de voz y aprendizaje automático más rápido. Esta optimización admite datos múltiples de instrucción única (SIMD) (a diferencia de SISD, MISD, MIMD), que describe una arquitectura en la que múltiples elementos de procesamiento en la tubería realizan operaciones en múltiples puntos de datos (hardware) todos ejecutados con una sola instrucción.

Los ingenieros de ARM también incorporaron VFPV3, una optimización de punto flotante, en el chip que utiliza nuestro Raspberry Pi 3. La página ARM vinculada aquí describe las características incluidas en esta optimización, como los modos de redondeo configurables y el comportamiento personalizable predeterminado, no un número (NaN).

Lo que esto significa para nosotros es que es probable que nuestra red neuronal funcione más rápido porque el procesador ARM en la Raspberry Pi 3 tiene optimizaciones de hardware que podemos aprovechar con el procesador 4 × ARM Cortex-A53, 1.2GHz.

Creo que quedará realmente impresionado con los resultados, así que sigamos adelante y obtenga su OpenCV optimizado instalado en la Raspberry Pi.

# Paso # 1: expanda el sistema de archivos y reclame espacio

Para el resto de este tutorial haré los siguientes supuestos:

1. Estás trabajando con una nueva instalación nueva de Raspbian Stretch.
2. Esta no es la primera vez que instala OpenCV en Raspberry Pi usando entornos virtuales Python. Si es así, moje sus pies usando una de mis guías introductorias de instalación de OpenCV.
3. Te sientes cómodo con la línea de comandos y los entornos Unix.
4. Sabe cómo depurar la salida de CMake para errores comunes (entorno virtual de Python no encontrado, bibliotecas de Python faltantes, etc.).

Una vez más, este tutorial es una guía avanzada, por lo que presentaré los comandos y solo proporcionaré una explicación si es pertinente; en general, debe saber qué hacen estos comandos antes de ejecutarlos.

El primer paso es ejecutar, `raspi-config` y expandir su sistema de archivos:

- **`sudo raspi-config`**
- **`sudo reboot`**

A partir de ahí, elimine Wolfram Engine y LibreOffice para recuperar ~ 1GB de espacio en su Raspberry Pi:

```
$ sudo apt-get purge wolfram-engine
$ sudo apt-get purge libreoffice*
$ sudo apt-get clean
$ sudo apt-get autoremove
```

# Paso # 2: Instalar dependencias

Los siguientes comandos actualizarán y actualizarán cualquier paquete existente, seguido de la instalación de dependencias, bibliotecas de E / S y paquetes de optimización para OpenCV:

```
$ sudo apt-get update && sudo apt-get upgrade
$ sudo apt-get install build-essential cmake pkg-config
$ sudo apt-get install libjpeg-dev libtiff5-dev libjasper-dev libpng12-dev
$ sudo apt-get install libavcodec-dev libavformat-dev libswscale-dev libv4l-dev
$ sudo apt-get install libxvidcore-dev libx264-dev
$ sudo apt-get install libgtk2.0-dev libgtk-3-dev
$ sudo apt-get install libcanberra-gtk*
$ sudo apt-get install libatlas-base-dev gfortran
$ sudo apt-get install python2.7-dev python3-dev
```

Todo este proceso debería tomar unos 5 minutos.

**Nota**: agregué libcanberra-gtk \* que toma el GTK específico de ARM para evitar las advertencias GTK (no errores; advertencias) que puede encontrar al ejecutar scripts Python + OpenCV en la Raspberry Pi.

# Paso # 3: descargue el código fuente de OpenCV

A continuación, descargue el código fuente de OpenCV para los repositorios opencv y opencv_contrib, y luego descomprimalos:

```
$ cd ~
$ wget -O opencv.zip https://github.com/opencv/opencv/archive/4.3.0.zip
$ unzip opencv.zip
$ wget -O opencv_contrib.zip https://github.com/opencv/opencv_contrib/archive/4.3.0.zip
$ unzip opencv_contrib.zip
```

**NOTA:** Para esta publicación de blog, utilizaremos OpenCV 4.3.0; sin embargo, a medida que se lanzan versiones más nuevas de OpenCV, puede actualizar los números de versión correspondientes.

Ver las versiones en:

- :start: [opencv](https://github.com/opencv/opencv/releases)
- :start: [opencv contrib](https://github.com/opencv/opencv_contrib/releases)

# Paso 4: crea tu entorno virtual de Python e instala NumPy

Utilizaremos entornos virtuales de Python, una práctica recomendada cuando trabajemos con Python.

Puede instalar pip, `virtualenv` y `virtualenvwrapper` usando los siguientes comandos:

```
$ sudo pip3 install virtualenv virtualenvwrapper
$ sudo rm -rf ~/.cache/pip
```

Una vez que se hayan instalado `virtualenv` y `virtualenvwrapper`, abra su `~ / .bashrc` y agregue las siguientes líneas al final del archivo, utilizando su editor de texto basado en terminal favorito, como vim, emacs o nano:

```
# virtualenv and virtualenvwrapper
export WORKON_HOME=$HOME/.virtualenvs
export VIRTUALENVWRAPPER_PYTHON=/usr/bin/python3
export VIRTUALENVWRAPPER_VIRTUALENV=/usr/local/bin/virtualenv
source /usr/local/bin/virtualenvwrapper.sh
export VIRTUALENVWRAPPER_ENV_BIN_DIR=bin
```

- **`nano ~/.profile`**

Deberá ejecutar `source ~ / .bashrc` **cada vez** que abra un nuevo terminal / SSH en su Pi para asegurarse de que las variables del sistema se hayan configurado correctamente (también carga este archivo en el arranque).

A continuación, cree su entorno virtual Python 3:

- **`mkvirtualenv cv -p python3`**

Aquí estoy creando un entorno virtual de Python llamado _cv_ usando Python 3 (alternativamente, también puede usar Python 2.7 cambiando el interruptor `-p` a `python2`).

Puedes nombrar el entorno virtual como quieras, pero yo uso **`cv`** como la convención de nomenclatura estándar aquí en PyImageSearch.

Finalmente, instale NumPy en el entorno virtual de Python:

- **`pip install numpy`**

# Paso 5: compila e instala la biblioteca OpenCV optimizada para Raspberry Pi

Ahora estamos listos para compilar e instalar la versión optimizada de Raspberry Pi.

Asegúrese de estar en el entorno virtual de `cv` con el comando `workon`:

- **`workon cv`**
