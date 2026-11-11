package co.edu.udec.estructuras;

public class Nodo {

    private Object dato;
    private Nodo izquierda;
    private Nodo derecha;

    // Constructor vacio
    public Nodo() {

    }

    // Constructor que recibe el dato
    public Nodo(Object dato) {
        this.dato = dato;
    }

    public Object getDato() {
        return dato;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    // Establecer el nodo izquierdo
    public void setIzquierda(Nodo vecino) {
        this.izquierda = vecino;
    }

    // Establecer el nodo derecho
    public void setDerecha(Nodo vecino) {
        this.derecha = vecino;
    }

}
