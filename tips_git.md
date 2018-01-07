	
# TIPS GIT

_Son comandos generales usados en git, aquí están para recordarlos fácilmente y tenerlos a la mano._

- **git config --global color.ui true** // Configuramos el color de git, parahacerlo más didáctico

- **cd** -> Nos permite movernos dentro de carpetas. 
- **cd..** -> Salimos de la captea
- **mkdir name-folder** -> Crea una carpeta
- **ls** -> Muestra el listado de las carpetas
- **clear** -> Limpia la terminal
- **Ctrl + L** -> Limpia la terminal
- **touch name-file** -> Permite crear archivos
- **rm name-file** -> Elimina archivos
- **rm -rf name-folder** -> Elimina la carpeta

- **:wq** -> Guarda los cambios de los archivos cuando se trabaja con vim

__*Nunca usar rm -rf / o se despiden de su pc*__

## VIM 
**i** = para poder editar

**:wq** = para guardar y salir

**:q!** = para salir sin guardar 

- **git init name_repositorio** -> Crea el repositorio con un nombre en específico
- **git status** -> Vemos el estado de los archivos 

    Untracked files -> Archivos en el working directory, no han sido agregados a git

- **git add -A** -> Agrega todos los archivos del working directory al staging area
- **git add name_file** -> Deja los archivos listos para agregarlos al repositotio (Staging area)
- **git rm --cached [file]** -> Quita el archivo del area de preparacion
	git rm -f <file> -> Elimina los archivos del area de trabajo y el area de preparacion

- **git commit -m [message]**  -> Confirmamos los cambios para agregar los archivos al repositorio
- **start [filename]** -> Abrimos un archivo con el programa que tengamos predefinido en el SO

- **git commit --amend** -> Concatena un commit anterior con el nuevo, dejando solo uno en caso de que te hayas olvidado agregar un archivo

## Etiquetas (git tag) 
Hay dos tipos de etiquetas
* Ligeras
* Anotadas

- **git tag [version]** -> Etiqueta ligera
- **git tag -a [version] -m [mensaje]**  -> Etiqueta anotada
- **git tag -l** -> Muestra el listado de las etiquetas


## Etiquetar un commit 
- **git tag [version] [SHA-1 Commit]**
- **git tag -d [name tag]** -> Elimina la etiqueta
- **git tag -f -a [name tag] -m [mensaje]** -> Renombra la etiqueta

## Historia de nuestro proyecto (git log)
- **git log** -> Muestra los registros de los commits
- **git log --oneline** -> Muestra solo el mensaje del commit
- **git log --oneline --graph** -> Muestra los gradicos de la historia de los commits
- **git log -[numero]** -> Muestra los ultimos registros de los commits
- **git log --oneline --graph --decorate** -> Muestra los gráficos del historial y los nombres de las ramas

## Revisando Cambio entre versiones (git diff)
Compara el estado inicial con el estado que queremos comparar

- **git diff [SHA-1]**
- **git diff [SHA-1] [SHA-1]**

## Quita un cambio (commits), y lo deja en el staging area (git reset --soft) 
* --soft
* --mixed
* --hard

- **git reset --soft [SHA 1]**: elimina los cambios hasta el staging area
- **git reset --mixed [SHA 1]**: elimina los cambios hasta el working area
- **git reset --hard [SHA 1]**: regresa hasta el commit del [SHA 1]

Es importante conocer los SHA-1, en el caso de borrar los registros con git reset--hard, 
también podemos recuperar los registros con este mismo comando, usando el SHA-1, mas reciente

## Configurar otro editor de texto en Git 
- **git config --global core.editor "subl --wait"** Configurar sublime como editor por defecto de git

## Ramas (Multiples variantes del repositorios) git branch 
- **git branch [name]** -> Crea una rama
- **git branch -l** -> Muestra todas las ramas
- **git branch -d [name]** -> Elimina una rama
- **git branch -D [name]** -> Forza el borrado de una rama
- **git branch -m [name] [new name]** -> Renombra las ramas

## Moviéndonos entre ramas  y versiones (git checkout) 
- **git checkout [branch/tag/SHA-1]** -> Cambiamos de rama, commit, o etiqueta
- **git checkout -b [name]** -> Crea y cambiamos a esa rama


## Mezclando ramas y resolviendo conflictos (git merge) 
Para mezclar los cambios deberíamos usar el comando git merge. Las instrucciones sería pararnos desde la rama que queremos mezclar y hacer un git merge con la rama que pretendemos usar.

- **git merge [branch]**

## Reescribe la historia de tu proyecto (git rebase)
- **git rebase [branch]** -> hace prácticamente lo mismo que merge, cambiamos la historia de nuestro proyecto sin crear bifurcaciones del proyecto. Es mejor usar merge
- **git rebase -i [branch]** -> de manera interactiva, nos abrira el editor que tengamos definido en la configuración de git.

## Guardando cambios temporalmente (git stash) 
Stash es un estado que tenemos como intermedio. Para esto debemos ir a alguna de nuestras ramas y usando 
el comando git stash que nos permite hacer cambios, pero no confirmarlos.

- **git stash** -> Es otro de los limbos, como el staging area. Para agregar los cambios estos deben estar en el staging area.
- **git stash list** -> nos muestra la lista de stash que tengamos.
- **git stash drop stash@{numero}** -> nos permite borrar un stash.
- **git stash apply** -> aplicamos el último cambio
- **git stash apply <stash@{numero}>** -> Aplica el cambio seleccionado

## Eligiendo commits selectivamente (Cherry pick) 
Si estás trabajando en una rama, pero de repente notas que hiciste un cambio en la rama que no debías,
para esto podemos usar cherry pick. Este comando nos puede salvar la vida, ya que nos permite sacar 
cambios específicos de una rama y mezclarlos en otra.

- **git cherry-pick [SHA1]** -> Cambia un commit a otra rama, lo copia

## Clonando Repositorios Remotos 

- **git clone [HTTPS/SSH]**

## Generar clave ssh 
	
- **ssh-keygen -t rsa -b 4096 -C "email@email.com"** -> Genera una clave SSH
- **clip < ~/.ssh/id_rsa.pub**  -> Copia la clave pública

## Repositorios Locales y remotos 

- **git remote add [origin] [SSH/HTTPS]** -> Conecta un repositorio con nuestro equipo local.
- **git remote -v** -> Lista las conexiones existentes.
- **git remote remove [origin]** -> Elimina una conexión con algún repositorio.

## Trayendo cambios desde el repositorio remoto 

- **git fetch [origin] [master]** -> Descarga los cambios a una rama generalmente llamada origin/master, seguido de esto tienes que fuisonar esa rama
- **git pull [origin] [master]** Es como ejecutar los 2 pasos anteriores(fetch y merge) en uno solo
- **git merge origin/master --allow-unrelated-histories**  -> Mezcla la rama master del repositorio remoto con la de nuestro repositorio, esto se hace cuando usamos el comando git fetch

## Enviando cambios al repositorio remoto 

- **git push origin master**  -> Enviamos los cambios que tengamos en nuestro repositorio local
- **git push origin --tags**  -> Enviamos las etiquetas que tengamos
- **git push origin [branch]** -> Enviamos una rama

## Creando un template para Pull Request 
	
1. Crear archivo llamado pull_request_template.md
2. Definir los lineamientos usando sintaxis markdown
3. Hacer commit

## Creando un template para issues 
Lo ideal es que siempre que creemos un proyecto tengamos un template para enviar pull requests o cuando tengamos issues.

**issue_template.md**


## .gitignore (Ignorando archivos no deseados) 

Si tienes archivos que no pueden ser públicos, como archivos de configuración con contraseñas, lo ideal es que no los subas a tu repositorio, estos archivos los puedes poner en el archivo .gitignore.
https://www.gitignore.io/

## Issues y Milestones (Reportando y monitoreando errores eficientemente) 
- **Issues:** Sirve para reportar un problema o sugerir algún cambio que para el repositorio.
- **Milestones:** Forma para agrupar Issues o Pull Request.

## Dominios personalizados en Github 

GitHub me permite personalizar la URL de mi GitHub Pages, primero debo comprar el dominio, nosotros usamos namecheap.com.
En el dashboard de namecheap vamos a manage nuestro dominio, vamos a configurar los DNS.
En GitHub vamos a settings y creamos un custom URL.
Creamos en el proyecto el archivo CNAME y en el ponemos la URL del dominio que compramos.

- **ping tuUserName.github.io**  -> Para verificar la ip asignada (CMD)
- **nslookup TuUserName.github.io** -> Verifica la ip

La ip de GitHub es 192.168.252.153 - 192.168.252.154.

