#!/bin/bash


#documentation

variable=${1}

mensajes() {
echo "Hackeando la nasa......................................"
echo "Accediendo a los sistemas......"
echo "obteniendo informacion bancaria"
echo "el numeor ingresado es" $variable
}

dateFunction() {
echo "Obteniendo fecha"
date
}

mensajes
dateFunction

# leer archivo de los usuarios
cat /etc/passwd

