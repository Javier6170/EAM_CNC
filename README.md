# [PARCIAL 1 - Javier Rodriguez Marulanda - Documentacion procesos en Linux](https://github.com/Javier6170/EAM_CNC/blob/main/README.md)

## Introducción

El primer proceso nos llevará a través de los pasos necesarios para crear un entorno de servidor web local utilizando una máquina virtual. Aprenderemos cómo instalar y configurar Nginx, un servidor web de código abierto ampliamente utilizado, y cómo utilizarlo para crear nuestra primera página web. Además, exploraremos cómo establecer un dominio de pruebas en el entorno local, permitiéndonos simular una experiencia real en la web mientras experimentamos en un entorno controlado.

En el segundo proceso, nos sumergiremos en el mundo de la administración de sistemas Linux, específicamente en el ámbito de la gestión de almacenamiento. Aprenderemos cómo particionar un disco duro utilizando la línea de comandos de Linux. Las particiones son esenciales para organizar y gestionar eficientemente el espacio de almacenamiento en un sistema. Descubriremos cómo crear, eliminar y redimensionar particiones, y cómo estas acciones pueden impactar en la utilización general del disco. Además, exploraremos cómo podemos aprovechar estas particiones recién creadas para optimizar el uso del almacenamiento y mejorar la administración de datos en nuestro sistema.

# Creación de un Servidor Web con Nginx y Configuración de un Dominio de Pruebas:

# Objetivo General:

Aprender a configurar un servidor web utilizando Nginx en una máquina virtual, junto con la creación y configuración de un dominio de pruebas en el entorno local.

# Objetivos Específicos:

1. Instalación y Configuración de Nginx: Dominar el proceso de instalación de Nginx en una máquina virtual, comprendiendo los pasos necesarios para configurar y asegurar el servidor web.

2. Creación de una Página Web Inicial: Diseñar y desarrollar una página web básica para ser alojada en el servidor Nginx. Aprender a estructurar el contenido y a configurar adecuadamente los archivos para el funcionamiento del sitio web.

3. Configuración del Dominio de Pruebas: Explorar la configuración de un dominio de pruebas en el entorno local, incluyendo la edición de archivos de hosts y la asignación adecuada de nombres de dominio a direcciones IP locales. Comprender cómo este proceso simula la experiencia de un dominio real en la web.

# Procesos para crear un servidor en Nginx:

1. Primero debes instalar el servidor de Nginx en tu maquina de esta forma:

`sudo apt-get install nginx`

2. Automaticamente se genera la carpeta /nginx en tu maquina para acceder a este debes ejecutar:

`cd /etc/ngnix`

También puedes ver las carpetas que tiene este directorio

`ll`

Por ejemplo:

[![directory-nginx.png](https://i.postimg.cc/FsdLnRSL/directory-nginx.png)](https://postimg.cc/bsPrZq3y)


3. Cambiamos al directorio llamado /sites-available

`cd sites-available`

Veras que por defecto estara un archivo llamado `default`


4. Copiar default y añadir tu nuevo sitio

`cp default jrodriguez-dev.com`

5. Editar el archivo creado en este caso: jrodriguez-dev.com

`vim jrodriguez-dev.com`

Presionamos la letra i para editar 

lo que nos debe aparecer es algo como esto:

```
##
# You should look at the following URL's in order to grasp a solid understanding
# of Nginx configuration files in order to fully unleash the power of Nginx.
# https://www.nginx.com/resources/wiki/start/
# https://www.nginx.com/resources/wiki/start/topics/tutorials/config_pitfalls/
# https://wiki.debian.org/Nginx/DirectoryStructure
#
# In most cases, administrators will remove this file from sites-enabled/ and
# leave it as reference inside of sites-available where it will continue to be
# updated by the nginx packaging team.
#
# This file will automatically load configuration files provided by other
# applications, such as Drupal or Wordpress. These applications will be made
# available underneath a path with that package name, such as /drupal8.
#
# Please see /usr/share/doc/nginx-doc/examples/ for more detailed examples.
##

# Default server configuration
#
server {
        listen 80 default_server;
        listen [::]:80 default_server;

        # SSL configuration
        #
        # listen 443 ssl default_server;
        # listen [::]:443 default_server;
        #
        # Note: You should disable gzip for SSL traffic.
        # See: https://bugs.debian.org/773332
        #
        # Read up on ssl_ciphers to ensure a secure configuration.
        # See: https://bugs.debian.org/765782
        #
        # Self signed certs generated by the ssl-cert package
        # Don't use them in a production server!

        #
        # include snippets/snakeoil.conf;

        root /var/www/jrodriguez-dev;

        # Add index.php to the list if you are using PHP
        index index.html index.htm index.nginx-debian.html;

        server_name jrodriguez-dev.com;

        location / {
                # First attempt to serve request as file, then
                # as directory, then fall back to displaying a 404.
                try_files $uri $uri/ =404;
        }

        # pass PHP scripts to FastCGI server
        #
        #location ~ \.php$ {
        #       include snippets/fastcgi-php.conf;
        #
        #       # With php-fpm (or other unix sockets):
        #       fastcgi_pass unix:/run/php/php7.4-fpm.sock;
        #       # With php-cgi (or other tcp sockets):
        #       fastcgi_pass 127.0.0.1:9000;
        #}

        # deny access to .htaccess files, if Apache's document root
        # concurs with nginx's one
        #
        #location ~ /\.ht {
        #       deny all;
        #}
}
# Virtual Host configuration for example.com
#
# You can move that to a different file under sites-available/ and symlink that
# to sites-enabled/ to enable it.
#
#server {
#       listen 80;
#       listen [::]:80;
#
#       server_name example.com;
#
#       root /var/www/example.com;
#       index index.html;
#
#       location / {
#               try_files $uri $uri/ =404;
#       }
#}
```

6. Eliminamos el la linea default_server de la siguiente forma:

```
server {
        listen 80 default_server <- Eliminamos esto para que quede liesten 80;
        listen [::]:80 default_server <- Igual en este caso;
        # SSL configuration
        #
        # listen 443 ssl default_server <- Eliminamos;
        # listen [::]:443 default_server <- Eliminamos;
```
7. Siguiendo en el mismo archivo debemos hacer otras ediciones 


```
    root /var/www/jrodriguez-dev <- En la parte de root por defecto viene como html pero la debes editar y poner tu pagina ;

    server_name jrodriguez-dev.com <- Colocas como quieres llamar tu dominio de pruebas;
```


8. En caso de que no te deje copiar el archivo default puedes intentar:

- `sudo su`

- `chmod 777 defualt`

9.   Ahora entramos en el directorio /sites-enabled

- podemos ejecutar el comando `ll` y vemos lo siguiente:

[![directory-sites-enabled.png](https://i.postimg.cc/c4jtw8Fz/directory-sites-enabled.png)](https://postimg.cc/Mv7G8X20)

10. debemos crear un link simbolico y ponerlo en la ruta que tenemos actualmente de la siguiente manera:

`ln -s ../sites-available/jrodriguez.com .`

11. Ahora debemos recarcar nginx para que cargue esta configuración nueva:

`nginx -s reload`

12. Ahora editamos /etc/hosts para por decir asi engañar al servidor de que estamos entrando a jrodriguez.com desde nuestra ip de maquina de la siguiente manera:

`vim /etc/hosts`

```
    127.0.0.1       localhost
    127.0.1.1       javier-virtual-machine
    192.168.136.128 jrodriguez-dev.com 
```

colocamos la ip de nuestra maquina

- Si no sabes la ip de tu maquina puedes usar el comando `ifconfig`

13. Ahora crearemos nuestra pagina web entrando al directorio /var/www entonces:


`cd /var/www`

`ls`

`mkdir jrodriguez-dev`

`vim index.html`

- Puedes colocar como ejemplo lo siguiente

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>jrodriguez</title>
</head>
<body>
    <h1>Javier Rodriguez Marulanda</h1>
    <p>Estudiante Ing. Software</p>
</body>
</html>
```

14. Para persistir el proceso del servidor de nginx es facil solo debes ejecutar las siguientes lineas de instrucciones en tu maquina de linux en este caso ustoy usando Ubuntu:

`systemctl start nginx`




# Particionado de Disco y Gestión de Almacenamiento en Linux (ununtu LTS 18.0.0):

# Objetivo General:

Adquirir habilidades en la partición de discos y la gestión eficiente del almacenamiento en un sistema operativo Linux a través de la línea de comandos.

# Objetivos Específicos:

1. Particionado de Disco: Familiarizarse con los conceptos fundamentales del particionado de discos, aprendiendo cómo crear y eliminar particiones utilizando herramientas de línea de comandos en Linux.

2. Redimensionamiento de Particiones: Aprender a redimensionar particiones existentes, ya sea para ampliar o reducir su tamaño. Comprender los factores que influyen en estas acciones y sus implicaciones.

3. Utilización Eficiente de las Particiones: Explorar estrategias para aprovechar al máximo las particiones creadas, incluyendo la asignación de puntos de montaje, la gestión de sistemas de archivos y la organización de datos en diferentes particiones para mejorar el rendimiento y la seguridad del sistema.

# Procesos para crear particion de disco en VMware

1. Primero debes tener creada tu maquina virtual en mi caso la tengo creada con linux

[![vmware-inicio.png](https://i.postimg.cc/PJHWP7v1/vmware-inicio.png)](https://postimg.cc/qhmhFjL7)

2. Damos click derecho en la maquina 

[![vmware-click-derecho.png](https://i.postimg.cc/mkrrX300/vmware-click-derecho.png)](https://postimg.cc/xJWYqmjR)

3. Entramos a las configuraciónes luego le damos a Hard Disk (SCSI)

[![vmware-hardisk.png](https://i.postimg.cc/zfXXXFf3/vmware-hardisk.png)](https://postimg.cc/xXhS6HMS)

4. Le damos añadir 

[![add-vmware-hardisk.png](https://i.postimg.cc/m2ysz1J9/add-vmware-hardisk.png)](https://postimg.cc/dL3Xg3qQ)

5. Luego escogemos SCSI 

- Luego le damos donde dice `create a new virtual_machine`

[![add-vmware-hardisk-scsi-create.png](https://i.postimg.cc/nL8YyMVd/add-vmware-hardisk-scsi-create.png)](https://postimg.cc/QFbT58T5)

6. Escogemos el tamaño del disco de la siguiente manera y le damos siguiente

[![add-vmware-hardisk-scsi-size.png](https://i.postimg.cc/26SqMfWc/add-vmware-hardisk-scsi-size.png)](https://postimg.cc/7CjYJdm0)

7. Escogemos en cual de nuestras maquinas virtuales queremos crear nuestro disco  y finalizamos la creación del nuevo disco

[![add-vmware-hardisk-scsi-distribution.png](https://i.postimg.cc/6qLppjC2/add-vmware-hardisk-scsi-distribution.png)](https://postimg.cc/y3xHfTQs)

8. Entramos a nuestra maquina virtual, entramos a nuestra terminal y comprobamos la existencia del nuevo disco:

[![vm-lsblk.png](https://i.postimg.cc/c4zfy61p/vm-lsblk.png)](https://postimg.cc/PPmC1Xwy)

9. Luego hacemos el siguiente proceso para hacer la particion al disco:

`fdisk /dev/sdb`

10. Le puedes dar a la m para ver todas las configuraciones:

 ```
Command (m for help): m

Help:

  DOS (MBR)
   a   toggle a bootable flag
   b   edit nested BSD disklabel
   c   toggle the dos compatibility flag

  Generic
   d   delete a partition
   F   list free unpartitioned space
   l   list known partition types
   n   add a new partition
   p   print the partition table
   t   change a partition type
   v   verify the partition table
   i   print information about a partition

  Misc
   m   print this menu
   u   change display/entry units
   x   extra functionality (experts only)

  Script
   I   load disk layout from sfdisk script file
   O   dump disk layout to sfdisk script file

  Save & Exit
   w   write table to disk and exit
   q   quit without saving changes

  Create a new label
   g   create a new empty GPT partition table
   G   create a new empty SGI (IRIX) partition table
   o   create a new empty DOS partition table
   s   create a new empty Sun partition table
```

11. Luego das el comando n para crear una nueva particion

`n`

12. Te aparecera esto:

[![vm-partition.png](https://i.postimg.cc/jjJzxfSV/vm-partition.png)](https://postimg.cc/qt4tQzKQ)

13. El siguiente paso es crear como particion primaria con el comando  `p` puedes crear hasta 4 particiones


```
root@javier-virtual-machine:/home/javier# fdisk /dev/sdb

Welcome to fdisk (util-linux 2.37.2).
Changes will remain in memory only, until you decide to write them.
Be careful before using the write command.


Command (m for help): n
Partition type
   p   primary (1 primary, 0 extended, 3 free)
   e   extended (container for logical partitions)
Select (default p): p
Partition number (2-4, default 2): 2
```

14. Siguiente paso dar Enter

15. Escogemos el tamaño de la particion que deseamos crear  por ejemplo `+1GB`


```
root@javier-virtual-machine:/home/javier# fdisk /dev/sdb

Welcome to fdisk (util-linux 2.37.2).
Changes will remain in memory only, until you decide to write them.
Be careful before using the write command.


Command (m for help): n
Partition type
   p   primary (1 primary, 0 extended, 3 free)
   e   extended (container for logical partitions)
Select (default p): p
Partition number (2-4, default 2): 2
First sector (3907584-10485759, default 3907584):
Last sector, +/-sectors or +/-size{K,M,G,T,P} (3907584-10485759, default 10485759): +1GB
```

16. Te debe aparecer un mensaje de exito en mi caso:

`Created a new partition 2 of type 'Linux' and of size 954 MiB.`

17. Debemos guardar con el comando:

`w`

18. podemos verificar la exitencia de la nueva partición

[![vm-partition-ver.png](https://i.postimg.cc/yxwDrQ0k/vm-partition-ver.png)](https://postimg.cc/H89WrtZg)

- Como podemos observar creamos una nueva partición de 1GB ya tenia creado uno de 2GB antes entonces por eso aparecen dos particiones

## Crear un sistema de archivos ext4 linux

19. Despues de haber creado la particion de tu disco lunux, puedes crear un sistema de archivos ext4 de la soguiente forma: 

`mkfs.ext4 /dev/sdb2`

20. Creamos una carpeta llamada /mnt/ext4 para montar el sistema de archivos

`mkdir /mnt/ext4`

12. Una vez creada montamos el sistema de archivos en nuestra particion de la siguiente forma:

`mount /dev/sdb2 /mnt/ext4`

13. De esta forma quedaria montado el sistema de archivos en nuestra partición.
