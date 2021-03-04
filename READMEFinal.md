# ProyectoFravegaDegani
Instructivo configuración de repositorio local para pruebas automatizadas en Karate
 Pre instalaciones necesarias: 
• Java jdk: https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html 
• Git: https://git-scm.com/downloads
• Maven: http://maven.apache.org/download.cgi#Installation
• Eclipse: https://www.eclipse.org/downloads/ 
Instalar el JDK
Para instalar el programa solo deberás dale doble clic sobre el archivo descargado y darle siguiente a todas las opciones.
 
 
 
Añadir JDK en las variables de entorno
En la barra de búsqueda escribe variables de entorno y selecciona la opción que llamada Editar las variables de entorno del sistema.
 
Se abrirá una ventana llamada propiedades del sistema, presiona el botón llamado variables de entorno.
 
Se abrirá otra ventana en la cual en el aparatado que se llama variables del sistema presiona el botón llamado Nueva...
 
Se abrirá un formulario el cual se deberá llenar de la siguiente manera en el nombre de la variable digita JAVA_HOME y en valor de la variable digita la ruta donde está instalado Java. Presiona el botón aceptar.
 
Ahora hay que editar la variable de entorno llamado path y añade “%JAVA_HOME%\bin” , en la lista
 
 
Ahora probemos si la instalación fue exitosa para ello es necesario abril la consola de comandos ,presiona CTR +R y en la ventana que parece digita cmd y presiona aceptar .
 
En terminal digita “java -version” si la instalación fue exitosa te aparecerá la versión de lo contrario revisa los pasos anteriores.
 
Instalar Maven
Primero descomprime el archivo y copia la carpeta en el disco C o donde prefieras
 
Ahora hay que añadir a las variables de entorno a Maven,para ello en la barra de búsqueda escribe variables de entorno y selecciona la opción que llamada Editar las variables de entorno del sistema.
 
Se abrirá una ventana llamada propiedades del sistema, presiona el botón llamado variables de entorno .
 
Se abrirá otra ventana en la cual en el aparatado que se llama variables del sistema presiona el botón llamado Nueva…
 
Se abrirá un formulario el cual se deberá llenar de la siguiente manera en el nombre de la variable digita MAVEN_HOME y en valor de la variable digita la ruta donde esta la carpeta de maven que se descomprimio. Presiona el botón aceptar .
 
Ahora hay que editar la variable de entorno llamado path y añade “%MAVEN_HOME%\bin” en la lista
 
 
Ahora probemos si la intalacion fue exitosa para ello es neesario abril la consola de comados ,presiona CTR +R y en la ventana que parece digita cmd y presiona aceptar .
 
En terminal digita “mvn -v” si la instalacion fue exitosa te aparecera la version de lo contrario revisa los pasos anteriores.
 
Instalar ambas en sus últimas versiones estables en caso de no tenerlas. 
GIT
Repositorio de Proyecto
1)	Elegir y crear una carpeta en nuestro sistema de archivos donde queramos descargar nuestro repositorio local. Abrimos cmd, la consola de windows y nos posicionamos en la ruta de la carpeta nueva que creamos.

Abrir CMD la consola de comando
 Ejemplo:
 
https://github.com/lucianodegani/ProyectoFravegaDegani.git
es la versión con la implementación de los dos ejercicios tanto de front para la tienda de Fravega como para el servicio de bebidas
 
2)	Elegir y crear una carpeta en nuestro sistema de archivos donde queramos descargar nuestro repositorio local. 
3)	Abrimos cmd o una consola de windows y nos posicionamos en la ruta de la carpeta nueva que creamos. Ejemplo: C:\FravegaProyectoTienda

Abrimos https://github.com/lucianodegani/ProyectoFravegaDegani

Y elegimos el repositorio que se quiere clonar en code
Damos click en la opción Code y copiamos la dirección http que nos indica.
 
En este caso es https://github.com/lucianodegani/ProyectoFravegaDegani.git

En la consola abierta previamente ponemos lo siguiente: git clone seguido de la url que copiamos. Ej: git clone https://github.com/lucianodegani/ProyectoFravegaDegani.git Esto hará que se comience a clonar el repositorio indicado en la carpeta que hemos creado.
 
Para iniciar las pruebas podemos ejecutarlo desde el IDE Eclipse abriendo el folder del proyecto clonado
 
 
4)	El Proyecto se abrirá
 

5)	Los test se encuentran en el package Test y las páginas del ejercicio 1 con la implementación del Page Object Model se encuentran en el package pages

6)	Antes de iniciar haremos que Maven baje las dependencias del proyecto y haremos un Clean and Build del proyecto
 
 

 


7)	En caso de que aparezca este error al hacer clean and build
 
Sacamos esa carpeta del path
 
 


8)	Para ejecutar los tests seleccionamos el test a ejecutar y pones run as 
 
En este caso es el segundo caso de probar el servicio con Rest assure
 
 

El primer ejercicio se llama Demo.java que se encuentra en el package test
   

 
Puede haber problemas con javascript en la página de fravega y el browser Firefox ejecutar nuevamente el test
	 
