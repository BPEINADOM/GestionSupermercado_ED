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

    // Insertar un elemento al inicio de la lista
    public void agregarAlInicio(Object dato) throws Exception {

        if (dato == null) {
            throw new Exception("El dato no puede ser nulo");
        }

        Nodo objetivo = new Nodo(dato);

        if (estaVacia()) {
            primero = objetivo;
            ultimo = objetivo;
        } else {
            objetivo.setDerecha(primero);
            primero.setIzquierda(objetivo);
            primero = objetivo;
        }

        cuenta++;

    }

    // Insertar un elemento en una posicion determinada
    public void agregarEnPosicion(int indice, Object dato) throws Exception {

        if (dato == null) {
            throw new Exception("El dato no puede ser null");
        }

        if (indice < 0 || indice > cuenta) {
            throw new Exception("La posicion esta fuera del rango permitido");
        }

        if (indice == 0) {
            agregarAlInicio(dato);
            return;
        }

        if (indice == cuenta) {
            agregar(dato);
            return;
        }

        Nodo siguiente = buscar(indice);
        Nodo anterior = siguiente.getIzquierda();
        Nodo nuevo = new Nodo(dato);

        anterior.setDerecha(nuevo);
        nuevo.setIzquierda(anterior);

        nuevo.setDerecha(siguiente);
        siguiente.setIzquierda(nuevo);

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

    // Elimina y devuelve el primer elemento
    public Object eliminarPrimero() throws Exception {
        if(estaVacia()) {
            throw new Exception("La lista esta vacia");
        }

        Object dato = primero.getDato();

        if (cuenta == 1) {
            primero = null;
            ultimo = null;
        } else {
            primero = primero.getDerecha();
            primero.setIzquierda(null);
        }

        cuenta--;
        return dato;

    }


    // Elimina y devuelve el ultimo elemento
    public Object eliminarUltimo() throws Exception {
        if(estaVacia()) {
            throw new Exception("La lista esta vacia");
        }

        Object dato = ultimo.getDato();

        if (cuenta == 1) {
            primero = null;
            ultimo = null;
        } else {
            ultimo = ultimo.getIzquierda();
            ultimo.setDerecha(null);
        }

        cuenta--;
        return dato;

    }

    // Elimina y devuelve el elemento de una posicion
    public Object eliminarEnPosicion(int indice) throws Exception {
        Nodo objetivo = buscar(indice);

        if (indice == 0) {
            return eliminarPrimero();
        }

        if (indice == cuenta - 1) {
            return eliminarUltimo();
        }

        Nodo anterior = objetivo.getIzquierda();
        Nodo siguiente = objetivo.getDerecha();

        anterior.setDerecha(siguiente);
        siguiente.setIzquierda(anterior);

        cuenta--;

        return objetivo.getDato();
    }

    // Comprobar si un elemento se encuentra en la lista
    public boolean contiene(Object dato) {
        if (dato == null || estaVacia()) {
            return false;
        }

        Nodo actual = primero;

        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true;
            }

            actual = actual.getDerecha();
        }

        return false;
    }

    // Elimina todos los elementos de la lista
    public void limpiar() {
        primero = null;
        ultimo = null;
        cuenta = 0;
    }

    // Mostrar los elementos desde el primero hasta el ultimo
    public void mostrarAdelante() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }

        Nodo actual = primero;

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getDerecha();
        }
    }

    // Mostrar los elementos desde el ultimo hasta el primero
    public void mostrarAtras() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }

        Nodo actual = ultimo;

        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getIzquierda();
        }
    }

    // Cantidad de los elementos
    public int cuentaElementos() {
        return cuenta;
    }
}
