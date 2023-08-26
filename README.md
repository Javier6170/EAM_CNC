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




# Particionado de Disco y Gestión de Almacenamiento en Linux:

# Objetivo General:

Adquirir habilidades en la partición de discos y la gestión eficiente del almacenamiento en un sistema operativo Linux a través de la línea de comandos.

# Objetivos Específicos:

1. Particionado de Disco: Familiarizarse con los conceptos fundamentales del particionado de discos, aprendiendo cómo crear y eliminar particiones utilizando herramientas de línea de comandos en Linux.

2. Redimensionamiento de Particiones: Aprender a redimensionar particiones existentes, ya sea para ampliar o reducir su tamaño. Comprender los factores que influyen en estas acciones y sus implicaciones.

3. Utilización Eficiente de las Particiones: Explorar estrategias para aprovechar al máximo las particiones creadas, incluyendo la asignación de puntos de montaje, la gestión de sistemas de archivos y la organización de datos en diferentes particiones para mejorar el rendimiento y la seguridad del sistema.

