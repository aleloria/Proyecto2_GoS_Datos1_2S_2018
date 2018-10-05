# Proyecto 2 Datos 1 2S_2018
# Game of Sorts (GoS) 

# Objetivo General

- Diseñar e implementar un juego que utiliza árboles y algoritmos de ordemanimiento intensivamente.

# Objetivos Espécificos

- Implementar algoritmos de ordenamiento y árboles en JAVA.
- Investigar y desarrollar una aplicación en el lenguaje de programación JAVA.
- Investigar acerca de programación orientada a objetos en JAVA.
- Aplicar patrones de diseño en la solución del problema.

# Descripción del Problema

GoS es un juego side scroller. El jugador maneja a un caballero medieval montado en un grifo que vuela durante todo el juego. El grifo se puede mover hacia cualquier dirección, pero el juego avanza únicamente hacia la derecha. Al presionar un botón, el grifo escupe fuego que puede utilizarse para atacar a los enemigos.

Los enemigos son oleadas de dragones pequeños que aparecen al estilo de space invaders. Los dragones lanzan fuego hacia la izquierda tratando de derribar al caballero. Los dragones avanzan hacia la izquierda. Si más de 3 dragones logran esquivar al caballero, el jugador pierde la partida.

Los dragones tienen diferentes características. Es posibe darle click a un dragón y ver en una esquina, sus características. Por ejemplo:
- Nombre generado aleatoriamente.
- Velocidad de recarga de fuego (de 1 a 100).
- Edad (de 1 a 1000 años). No hay dos dragones con la misma edad por oleada.
- Resistencia (de 1 a 3): indica que tantos dispararon soportan antes de morir.
- Clase: comandante (solo 1 por oleada), capitanes (tienen grupos de dragones y capitanes bajo su control) e infantería.
- Padre. Cada dragón tiene un padre (menos el primer dragon). Esto se asigna aleatoriamente a la hora de crearlo. Un dragón no puede ser el padre de más de dos dragones.

Conforme el nivel avanza, se incluyen más dragones en la oleada. La oleada inicial empieza con 100 dragones y cada nivel aumenta la oleada anterior en 20%. Los dragones son muy inteligentes. Cuando el jugador derriba a un dragón, la oleada cambia de alineación:

- Inicialmente aparecen en completo desorden, en un layout similar al de space invaders, pero a lo interno no tienen ningún orden.
- Selection sort según edad (aleatoriamente de menor a mayor o viceversa).
- Insertion sort por velocidad (aleatoriamente de menor a mayor o viceversa).
- Quick Sort por edad (aleatoriamente de menor a mayor o viceversa).
- Arbol binario por familias. Visualmente se debe ver la alineación de los dragones como un árbol. Si el padre de uno o más dragones mueren, se les busca un reemplazo.
- Árbol AVL por edades.

Cuando se llega a la última alineación, se reinicia a la alineación por selection sort. Cuando se aplica la alineación se debe ver de forma animada el proceso de ordenamiento y acomodo en pantalla. En todo momento se debe indicar la alineación actual.

En todo momento, el jugador puede ver un árbol B con todos los dragones de la oleada ordenado por nombre. Este árbol se mantiene actualizado según los dragones de la oleada. Es decir, si un dragón muere, se debe actualizar adecuadamente aplicando las reglas de árboles B.

El juego es cliente servidor. El único propósito del servidor es generar y ordenar las oleadas. El servidor provee un REST API que se ejecuta en WebSphere Application Server Liberty. El API recibe por parámetro la cantidad de dragones y retorna un XML con la oleada. Así mismo, cuando se necesite ordenar la oleada, el servidor recibe en XML la oleada con los dragones sobrevivientes y el tipo de ordenamiento, y retorna la oleada ordenada.

El juego tiene un log de eventos que muestra todo lo que está ocurriendo. Debe utilizar un logger como Logback para registrar todos los eventos y mostrarlos en pantalla. De igual forma el server tiene un log de eventos (en la consola del server) que muestra todos los ordenamientos resultantes y toda la actividad del mismo.
