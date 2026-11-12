package co.edu.udec.estructuras;

public class Pila {

    private int cuenta;
    private Nodo cima;

    // Constructor
    public Pila() {
        cuenta = 0;
        cima = null;
    }

    // Comprobar si la pila esta vacia
    public boolean estaVacia() {
        return cuenta == 0;
    }

    // Insertar un elemento a la cima
    public void apilar(Object dato) throws Exception {
        if (dato == null) {
            throw new Exception("El dato no puede ser nulo.");
        }

        Nodo nuevo = new Nodo(dato);

        if (estaVacia()) {
            cima = nuevo;
        } else {
            nuevo.setDerecha(cima);
            cima.setIzquierda(nuevo);
            cima = nuevo;
        }

        cuenta++;
    }

    // Retirar y devolver el elemento de la cima
    public Object desapilar() throws Exception {
        if (estaVacia()) {
            throw new Exception("La pila esta vacia");
        }

        Nodo eliminado = cima;
        Object dato = eliminado.getDato();

        cima = cima.getDerecha();

        eliminado.setDerecha(null);
        eliminado.setIzquierda(null);

        cuenta--;

        return dato;
    }

    // Consultar el elemento de la cima sin retirarlo
    public Object peek() throws Exception {
        if (estaVacia()) {
            throw new Exception("La pila esta vacia");
        }

        return cima.getDato();
    }

    // Obtener la cantidad de elementos
    public int tamanio() {
        return cuenta;
    }

    // Comprobar si un elemento se encuentra en una pila
    public boolean contiene(Object dato) {
        if (dato == null || estaVacia()) {
            return false;
        }

        Nodo actual = cima;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true;
            }

            actual = actual.getDerecha();
        }

        return false;
    }

    // Eliminar todos los elementos de la pila
    public void limpiar() {
        cima = null;
        cuenta = 0;
    }

    // Mostrar todos los elementos desde la cima hasta el fondo
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La pila esta vacia");
            return;
        }

        Nodo actual = cima;

        while (actual != null) {
            System.out.print(actual.getDato());
            actual = actual.getDerecha();
        }
    }

    // Buscar un elemento y devolver su posicion
    public int buscar(Object dato) throws Exception {
        if (estaVacia()) {
            throw new Exception("La pila esta vacia");
        }

        if (dato == null) {
            throw new Exception("El dato no puede ser nulo");
        }

        Nodo actual = cima;
        int posicion = 0;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return posicion;
            }

            actual = actual.getDerecha();
            posicion++;
        }

        throw new Exception("El elemento no se encuentra en la pila");
    }
}
