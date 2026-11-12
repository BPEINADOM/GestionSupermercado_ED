package co.edu.udec.estructuras;

public class Cola {

    private int cuenta;
    private Nodo frente;
    private Nodo fin;

    // Constructor
    public Cola() {
        cuenta = 0;
        frente = null;
        fin = null;
    }

    // Comprobar si la cola esta vacia
    public boolean estaVacia() {
        return cuenta == 0;
    }

    // Agregar un elemento al final de la cola
    public void encolar(Object dato) throws Exception {
        if (dato == null) {
            throw new Exception("No se puede agregar un dato nulo a la cola");
        }

        Nodo nuevo = new Nodo(dato);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setDerecha(nuevo);
            nuevo.setIzquierda(fin);
            fin = nuevo;
        }

        cuenta++;

    }

    // Retirar y devolver el elemento del frente
    public Object desencolar() throws Exception {
        if (estaVacia()) {
            throw new Exception("La cola esta vacia");
        }

        Nodo eliminado = frente;
        Object dato = eliminado.getDato();

        frente = frente.getDerecha();

        if (frente != null) {
            frente.setIzquierda(null);
        } else {
            fin = null;
        }

        eliminado.setDerecha(null);
        eliminado.setIzquierda(null);

        cuenta--;

        return dato;
    }

    // Consultar el elemento del frente sin eliminarlo
    public Object peek() throws Exception {
        if (estaVacia()) {
            throw new Exception("La cola esta vacia");
        }

        return frente.getDato();
    }

    // Obtener la cantidad de elementos
    public int tamanio() {
        return cuenta;
    }

    // Comprobar si un elemento se encuentra en cola
    public boolean contiene(Object dato) {
        if (dato == null || estaVacia()) {
            return false;
        }

        Nodo actual = frente;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true;
            }

            actual = actual.getDerecha();
        }

        return false;
    }

    // Eliminar todos los elementos de la cola
    public void limpiar() {
        frente = null;
        fin = null;
        cuenta = 0;
    }

    // Mostrar los elementos desde el frente hasta el final
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La cola esta vacia");
            return;
        }

        Nodo actual = frente;

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getDerecha();
        }

    }


}
