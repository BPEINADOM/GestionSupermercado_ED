package co.edu.udec.estructuras;

public class Lista {

    private int cuenta;
    private Nodo primero;
    private Nodo ultimo;

    // Comprobar si no hay elementos
    public boolean estaVacia() {
        return cuenta == 0;
    }

    // Insertar un elemento al final de la lista
    public void agregar(Object dato) throws Exception {

        if (dato == null) {
            throw new Exception("El dato no puede ser nulo");
        }

        Nodo objetivo = new Nodo(dato);

        if (estaVacia()) {
            primero = objetivo;
            ultimo = objetivo;
        } else {
            ultimo.setDerecha(objetivo);
            objetivo.setIzquierda(ultimo);
            ultimo = objetivo;
        }

        cuenta++;
    }


    // Buscar nodo por su posicion
    private Nodo buscar(int indice) throws Exception {
        if (estaVacia()) {
            throw new Exception("La lista esta vacia");
        }

        if (indice < 0 || indice >= cuenta) {
            throw new Exception(
                "La posicion " + indice +
                " esta fuera de rango 0 - " + (cuenta - 1)
            );
        }

        Nodo actual = primero;

        for (int i = 0; i < indice; i++) {
            actual = actual.getDerecha();
        }

        return actual;
    }


    // Buscar elemento por su contenido
    private int buscar(Object dato) throws Exception {
        if (estaVacia()) {
            throw new Exception("La lista esta vacia");
        }

        if (dato == null) {
            throw new Exception("El dato no puede ser nulo"); 
        }

        Nodo actual = primero;

        for (int i = 0; i < cuenta; i++) {
            if (actual.getDato().equals(dato)) {
                return i;
            }

            actual = actual.getDerecha();
        }

        throw new Exception("El elemento no se encuentra en la lista");

    }

    // Buscar el dato de una posicion
    public Object buscarDato(int indice) throws Exception {
        Nodo objetivo = buscar(indice);
        return objetivo.getDato();
    }

    // Buscar la posicion de un elemento
    public int buscarDato(Object dato) throws Exception {
        return buscar(dato);
    }

    // Cantidad de los elementos
    public int cuentaElementos() {
        return cuenta;
    }
}
