
# Sistema de Gestion de Compras de un Supermercado


Este proyecto corresponde a la Actividad individual de la Unidad 3, el cual trata de una aplicación de consola desarrollada en Java para administrar las compras realizadas por los clientes de un supermercado, utilizando estructuras de datos enlazadas: lista, cola y pila.

El proyecto corresponde al ejercicio 16, su objetivo principal es implementar un sistema que permita administrar el ciclo de vida de las compras de un supermercado mediante estructuras de datos dinamicas, aplicando los principios de organizacion, manipluuacion y recorrido de nodos.

## Tecnologias Utilizadas

- Java 21
- Maven
- JUnit 5
- Git y Github

## Estructuras de datos implementadas

El funcionamiento del sistema se apoya en tres estructuras de datos:

- **Lista enlazada doble**: almacena todas las compras registradas y permite realizar operaciones de inserción, eliminacion, búsqueda y recorrido.

- **Cola enlazada**: administra las compras pendientes siguiendo el principio FIFO (First In, First Out), de manera que se procesa primero la compra que llego antes.

- **Pila enlazada**: conserva el historial de compras procesadas mediante el principio LIFO (Last In, First Out), permitiendo deshacer el ultimo procesamiento.

## Organizacion del proyecto

El codigo fuente esta organizado en paquetes para separar las responsabilidades:

- **estructura**: contiene las implementaciones de los nodos, la lista, la cola y la pila.

- **modelo**: contiene la clase CompraCliente, que representa la informacion de cada compra.

- **aplicacion**: contiene SistemaSupermercado, encargado de coordinar las operaciones y las estructuras de datos.
## Ejecucion del proyecto

Clonar el repositorio

```bash
  git clone https://github.com/BPEINADOM/GestionSupermercado_ED.git
```

Entrar en el directorio del proyecto

```bash
  cd GestionSupermercado_ED/gestionsupermercado
```

Compilar el proyecto

```bash
  mvn clean compile
```

Ejecutar la clase principal Main.java para ejecutar el menu del sistema

```bash
  javac Main.java
  java Main
```


