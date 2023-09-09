#Download base image ubuntu 20.04
FROM ubuntu:20.04

# LABEL about the custom image
LABEL maintainer="javicode"
LABEL version="0.1"
LABEL description="This is custom Docker Image for the Apache Services."

ENV CONTAINER_TIMEZONE="America/Bogota"
ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /var/log/apache2
ENV APACHE_RUN_DIR /var/www/html

RUN ln -snf /usr/share/zoneinfo/$CONTAINER_TIMEZONE /etc/localtime && echo $CONTAINER_TIMEZONE > /etc/timezone

# Update Ubuntu Software repository
RUN apt update

# Install apache
RUN apt install -y apache2

# Copy file index.html   
COPY index.html /var/www/html/

# Define default command for the container
CMD ["/usr/sbin/apache2", "-D", "FOREGROUND"]

# Expose Port for the Application 
EXPOSE 80

