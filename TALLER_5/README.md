# [Documentacion de Drupal - CMS](https://github.com/Javier6170/EAM_CNC/tree/develop/TALLER_5/README.md)

## Que es Drupla ?

Drupal es un sistema de gestión de contenido (CMS) de código abierto que se utiliza para crear y administrar sitios web y aplicaciones web. Como estudiante de ingeniería de software, es importante que comprendas que Drupal es una plataforma altamente personalizable que se basa en PHP y utiliza una base de datos, generalmente MySQL, para almacenar contenido y configuraciones del sitio.

Algunas de las características clave de Drupal incluyen:

1. Gestión de Contenido: Drupal proporciona un sistema robusto para crear, editar y organizar contenido de manera efectiva. Puedes crear tipos de contenido personalizados y definir cómo se muestra cada uno.

2. Extensibilidad: Drupal tiene una amplia variedad de módulos y temas que puedes utilizar para ampliar su funcionalidad y personalizar la apariencia de tu sitio.

3. Seguridad: Drupal es conocido por su enfoque en la seguridad. Se lanzan actualizaciones regulares para abordar posibles vulnerabilidades.

4. Comunidad Activa: Drupal cuenta con una comunidad de desarrolladores y usuarios activa que comparten recursos, módulos y temas, y brindan soporte técnico.

5. Flexibilidad: Puedes utilizar Drupal para una amplia gama de proyectos, desde sitios web simples hasta aplicaciones web complejas y plataformas de comercio electrónico.

6. Gestión de Usuarios: Drupal permite administrar roles de usuario y permisos, lo que facilita la creación de sitios con múltiples usuarios y niveles de acceso.

## Creando contenedor 

 - Crear un `docker-compose.yml` para creae el contenedor de drupal 

```
# Drupal with PostgreSQL
#
# Access via "http://localhost:8080"
#   (or "http://$(docker-machine ip):8080" if using docker-machine)
#
# During initial Drupal setup,
# Database type: PostgreSQL
# Database name: postgres
# Database username: postgres
# Database password: example
# ADVANCED OPTIONS; Database host: postgres

version: '3.1'

services:

  drupal:
    image: drupal:8-apache
    ports:
      - 8080:80
    volumes:
      - drupal:/var/www/html
    restart: always

  postgres:
    image: postgres:10
    environment:
      POSTGRES_PASSWORD: example
    volumes:
      - $PWD/pgdata:/var/lib/postgresql/data
    restart: always

volumes:
  drupal:
```

1. En las primeras 11 lineas son comentarios a tener en cuanta cuando se nos ejecute instancia de drupal en el puerto 8080 usaremos esas credenciales para nuestra base de datos en posgreSQL: donde nos dice, usuario, base de datos, y contraseña

2. `version: '3.1'` Esta línea especifica la versión de Docker Compose que se está utilizando. En este caso, se está utilizando la versión 3.1 de Docker Compose, que es la versión de la sintaxis del archivo de configuración.

3. `volumes` Esta sección define los servicios que compondrán la aplicación. En este caso, tienes dos servicios: drupal y postgres.

4. `drupal` Este servicio utiliza la imagen de Docker `drupal:8-apache` , que es una imagen que contiene la plataforma Drupal 8 con un servidor web Apache preconfigurado. Luego, se especifican algunos puertos y volúmenes para este servicio.

 - `porst` Esta línea mapea el puerto 80 del contenedor al puerto 8080 del host, lo que significa que puedes acceder a la aplicación Drupal a través del puerto 8080.

 - `volumes` Aquí se define un volumen llamado `drupal` que está vinculado al directorio `/var/www/html` dentro del contenedor. Esto se hace para persistir los datos de Drupal, como configuraciones y archivos, incluso si el contenedor se detiene o se elimina.

 - `restart: always`  Esta línea indica que el servicio `drupal` se reiniciará automáticamente si se detiene por alguna razón.

5. `postgres` Este servicio utiliza la imagen de Docker `postgres:10`, que es una imagen de PostgreSQL en su versión 10. Se establece la contraseña de la base de datos en "example" a través de la variable de entorno `POSTGRES_PASSWORD`. También se define un volumen para persistir los datos de la base de datos PostgreSQL en la ruta `$PWD/pgdata` en el host.


## Resumend de la eejcución

En resumen, este archivo de Docker Compose define dos servicios: uno para Drupal y otro para PostgreSQL. Drupal se ejecutará en el puerto 8080 de tu máquina, y PostgreSQL se utilizará como base de datos para Drupal. Los volúmenes se utilizan para garantizar la persistencia de los datos en ambos servicios, y se especifica la versión de Docker Compose utilizada en el archivo.


## Una vez en ejecución 

[![Screenshot-from-2023-09-22-13-11-35.png](https://i.postimg.cc/ZnmJFfXR/Screenshot-from-2023-09-22-13-11-35.png)](https://postimg.cc/478CX1fk)