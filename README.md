# [PARCIAL 1 - Javier Rodriguez Marulanda - Documentacion procesos en Linux](https://adminlte.io)

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


[!IMPORTANT]
4. Copiar default y añadir tu nuevo sitio

`cp default jrodriguez-dev.com`

5. Editar el archivo creado en este caso: jrodriguez-dev.com

`vim jrodriguez-dev.com`

[!IMPORTANT]
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
        # listen 443 ssl;
        # listen [::]:443;
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
```



# Particionado de Disco y Gestión de Almacenamiento en Linux:

# Objetivo General:

Adquirir habilidades en la partición de discos y la gestión eficiente del almacenamiento en un sistema operativo Linux a través de la línea de comandos.

# Objetivos Específicos:

1. Particionado de Disco: Familiarizarse con los conceptos fundamentales del particionado de discos, aprendiendo cómo crear y eliminar particiones utilizando herramientas de línea de comandos en Linux.

2. Redimensionamiento de Particiones: Aprender a redimensionar particiones existentes, ya sea para ampliar o reducir su tamaño. Comprender los factores que influyen en estas acciones y sus implicaciones.

3. Utilización Eficiente de las Particiones: Explorar estrategias para aprovechar al máximo las particiones creadas, incluyendo la asignación de puntos de montaje, la gestión de sistemas de archivos y la organización de datos en diferentes particiones para mejorar el rendimiento y la seguridad del sistema.

