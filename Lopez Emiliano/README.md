# IndiceEspecial

### Emiliano López Prado

Dado una lista cualquiera de números ordenados, buscar un índice que cumpla la propiedad de ser igual a su valor.

### Ejemplo:
Dada la lista <-2, -1, 0, 3, 5, 7, 9, 10,13,21>

 - El índice 3 cumple la propiedad ya que a[3] = 3.

- A esto le llamamos, **índice especial**.

# Requisitos
Este programa fue escrito en java, por lo que es indispensable tener una versión de java instalada en el equipo. Para verificar la versión de java instalada, escribe en la linea de comando el siguiente comando:

    java -version

y también 

    javac -version

Para este programa se utilizó la versión 17.0.8, teorícamente solo es necesaria una versión de java mayor o igual a 8. Es importante que ambas versiones, tanto la java como la javac coincidan, de otra forma habrá problemas al ejecutar el programa o al compilarlo.

Si deseas instalar la versión de java usada para este proyecto puedes consultar el siguiente link:

    //linux
    https://www.oracle.com/java/technologies/downloads/#jdk17-linux

    //windows
    https://www.oracle.com/java/technologies/downloads/#jdk17-windows
# Compilación
Para compilar el programa, ahora es mucho más sencillo, simplemente es necesario dirigirse al directorio src dentro de la carpeta raiz y escribir el sigueinte comando:

    javac Main.java

# Ejecución

Nuestro programa estará listo para ejecutarse, por lo que será necesario realizar esto con el siguiente comando:

    java Main <-l | -a> <-c>

donde el primer parámetro del programa será que tipo de estructura usaremos para realizar el ejercicio: 

    -l //Para usar listas de java
    -a //Para usar arreglos de java

Este parámetro es méramente opcional, si no se agrega ningúna de las opciones o bien, agrega una que no es conocida para el programa, se usarán listas por default.

## Color

Este programa admite colores dentro de la terminal, pero esto puede o no funcionar en todas las terminales, por lo que por default está opción está desactivada, si desea agregar pequeños colores sutiles para mejorar la experiencia, puede agregar la bandera

    -c 

Al final de los parámetros

# Ejemplo de ejecución:
Usaremos el mismo ejemplo de antes: <-2, -1, 0, 3, 5, 7, 9, 10,13,21>

Este ejemplo viene escrito dentro del archivo de texto: Ejemplar.txt, más adelante hablaremos de eso.

Para ejecutar el programa usando listas y colores, escribiríamos lo siguiente:

    javac Main.java

    java Main -l -c

y esto nos generaría el siguiente resultado:

![Resutlado1](/Lopez%20Emiliano/READMEImg/ej1.png)

# Posibles errores
El programa tiene cierto nivel de manejo de errores, centrandose principalmente en evitar que no se encuentre el archivo Ejemplar.txt, ya que ahí es de donde se sacará un ejemplar para el programa.

En el caso de que se haya eliminado dicho archivo, el programa automáticamente vuelve a crear el archivo y lo llenará con un ejemplar completamente aleatorio, lo mismo sucede si resulta que el archivo está vacío.

Esta **no es una invitación** a pasar varios minutos tratando de romper mi programa, por favor :c