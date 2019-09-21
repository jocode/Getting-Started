# Comandos para la terminal en Git :sunglasses:

- **`$ git init`** 
Rastrea todos los archivos que tengas en un directorio o carpera, es decir, con este comando es que creas
el inicio de git, para que funcione como un CVS


1. Agregar Usuario
	- **`$ git config --global user.name "Mi nombre"`**

2. Agregar Email de Usuario (Debe ser el que tenga en la cuenta de GitHub, para sincronizar los proyectos)
	- **`$ git config --global user.email "email"`**

3. LLaves SSH, alternativas al protocolo FTP
	- El FTP No lleva control de Versiones del Software
	- Los archivos FTP no son seguras, al enviar datos al servidor
	- Las claves SSH encripta los archivos incluso las imagenes


## Usando SSH :key:

- Para comprobar claves SSH existentes
	- `$ ls -al ~/.ssh`      -> # Lists the files in your .ssh directory, if they exist

	- `$ ssh-keygen`  -> Genera la llave

	- `$ ssh-keygen -t rsa -b 4096 -C "your_email@example.com"` Genera la llave, le indicamos el email el cuál usará para la conexión 

	- `$ cd .ssh`  -> Para ingresar a la carpeta donde se guarda la Llave SSH

	- `$ cat <file name key>`  -> Con este comando, le digo a git, que me mueste la llave, y con ella la conecto a gitHub para que sincronice los proyectos, la llave es única, e identifica al ordenador

	Copiar la llave pública (id_rsa.pub) en la cuenta de GitHub, colocar el nombre y la clave, y guardar los cambios.
	
	- `$ eval $(ssh-agent -s)` -> Es el agente que mantiene las claves publicas y privadas y verifica las claves para ese servicio 
	
	- `$ ssh-add ~/.ssh/id_rsa` -> Para agregar la contraseña y que git no la pregunte cada vez que haga un pull o push, el agente se inicia manualmente cada vez que se abre el shell o bash de git

	- `$ shh -T git@github.com`  -> Confirmar si la llave SSH está vinculada con la cuenta de GitHub

## Vincular la llave SSH con github

- `$ clip < ~/.ssh/id_rsa.pub`   -> Copies the contents of the id_rsa.pub file to your clipboard

- Luego en la cuenta de github, vamos a  `settings -> SSH and GPG keys -> New SSH key`
	- Le damos un nombre a la llave para identificar el computador que se conectar
	- Copiamos la llave en el campo "Key"
	Finalmente le damos en el botón "Add SSH key"


**_Para más información, visitar los enlaces_**	
- https://help.github.com/articles/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent/
- https://help.github.com/articles/working-with-ssh-key-passphrases/


Para auto ejecutar en **ssh-agent** en Git para windows, debemos crear un archivo `~/.profile o ~/.bashrc` 
**~** Hace referencia a la carpeta del perfil del usuario, para comprobarlo usar el comando
- `$ echo ~`

To run ssh-agent automatically add following lines  on ~/.profile o ~/.bashrc 
```bash
env=~/.ssh/agent.env

agent_load_env () { test -f "$env" && . "$env" >| /dev/null ; }

agent_start () {
	(umask 077; ssh-agent >| "$env")
	. "$env" >| /dev/null ; }

agent_load_env

# agent_run_state: 0=agent running w/ key; 1=agent w/o key; 2= agent not running
agent_run_state=$(ssh-add -l >| /dev/null 2>&1; echo $?)

if [ ! "$SSH_AUTH_SOCK" ] || [ $agent_run_state = 2 ]; then
	agent_start
	ssh-add
elif [ "$SSH_AUTH_SOCK" ] && [ $agent_run_state = 1 ]; then
	ssh-add
fi

unset env
```
Now, when you first run Git Bash, you are prompted for your passphrase:


4. Navegar por directorios y crear nuevas carpetas

	- `$ cd`  -> Current Directory
	- `$ cd ..`  -> Se sale una carpeta más
	- `$ mkdir <folder-name>`    -> Crea una nueva carpeta
    - `$ > file.ext`    -> Crea un nuevo archivo

5. Traer repositorios desde GitHub

	- `$ git remote add origin <project url>`    -> Indica la ruta del repositorio que quiero traer
	- `$ git pull`   ->  Descargo todos los archivos del repositorio remoto a la computadora


6. Conflictos con el archivo index.lock
	
	- `$ rm -f ./.git/index.lock`



**TIPS**

En algunas ocasiones git no deja trabajar porque el index esta bloqueado y al realizar commit no lo toma, porque dice que ese directorio tiene otro proceso entonces le da la solucion de que elimine ese archivo

`fatal: Unable to create '/path/my_proj/.git/index.lock': File exists.`

If no other git process is currently running, this probably means a
git process crashed in this repository earlier. Make sure no other git
process is running and remove the file manually to continue. 


[Markdown Emojis on Github :eyes:](https://gist.github.com/rxaviers/7360908)