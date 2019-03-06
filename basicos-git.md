# Qué es Git

Version control systems (VCS) for tracking changes in computeer files

* Distributed version control
* Coordinates works between multiple developers
* Who made what change and when 
* Revert back any time 
* Local & remotes repos

## Conceptos de Git 

* Mantiene el seguimiento del código en la historia
* Toma (Snapshots) de los archivos
* Usted decide cuando hacer los snapshot a través de un commit  (Confirmación, anotación)


## Comandos básicos

En git hay 3 estados: 
1. El **working directory** Donde se va a estar trabajando con todos los archivos
2. El **staging area** Es el lugar donde prepara los archivos que va a ser guardados en el repositorio
3. **repository** Son los archivos que se guardan como snapshots

* `git init` Inicia un repositorio

* `git add <file>` Agrega un archivo a working directory

* `git status` Muestra el estado de los archivos

* `git commit` Agrega los archivos del staging area al repositorio

* `git push` Envía los cambios en tu copia local a un repositorio remoto

* `git pull` Trae los cambios de un servidor remoro

* `git clone` Copia el repositorio desde un repositorio remoto

* `git checkout -- file` Revierte los cambios de los archivos

* `git diff` Para ver las diferencias hechas en los archivos


- **ls** Lista los archivos que hay en ese directorio
- **pwd** Ver la ruta en la terminal

En el archivo **.gitignore** podemos colocar los archivos y carpetas que queremos que git ignore y no los agregue al repositorio