package co.edu.udec.aplicacion;

import co.edu.udec.estructuras.Cola;
import co.edu.udec.estructuras.Lista;
import co.edu.udec.estructuras.Pila;
import co.edu.udec.modelo.CompraCliente;

public class SistemaSupermercado {

    private Lista listaGeneral;
    private Cola colaPendientes;
    private Pila historialProcesados;

    // Constructor
    public SistemaSupermercado() {
        listaGeneral = new Lista();
        colaPendientes = new Cola();
        historialProcesados = new Pila();
    }

    // Registrar cada compra realizada
    public void registrarCompra(CompraCliente compra) throws Exception {
        if (compra == null) {
            throw new Exception("La compra no puede ser nula");
        }

        if (listaGeneral.contiene(compra)) {
            throw new Exception("Ya existe una compra con ese numero");
        }

        compra.setEstado("PENDIENTE");

        listaGeneral.agregar(compra);
        colaPendientes.encolar(compra);

        System.out.println("Compra registrada correctamente");
    }

    // Mostrar todas las compras registradas
    public void verComprasRegistradas() {

        System.out.println("\n===== COMPRAS REGISTRADAS =====");

        if (listaGeneral.estaVacia()) {
            System.out.println("No hay compras regitradas");
            return;
        }

        listaGeneral.mostrarAdelante();

    }

    // Mostrar las compras pendientes
    public void verComprasPendientes() {

        System.out.println("\n===== COMPRAS PENDIENTES =====");

        if (colaPendientes.estaVacia()) {
            System.out.println("No hay compras realizadas");
            return;
        }

        colaPendientes.mostrar();

    }

    // Procesar la siguiente compra pendiente
    public void procesarSiguienteCompra() throws Exception {
        if (colaPendientes.estaVacia()) {
            throw new Exception("No hay compras pendientes para procesar");
        }

        CompraCliente procesada = (CompraCliente) colaPendientes.desencolar();

        procesada.setEstado("PROCESADA");

        historialProcesados.apilar(procesada);

        System.out.println("\nCompra procesada correctamente");
        System.out.println(procesada);
    }

    // Mostrar el historial de compras procesadas
    public void verHistorialProcesados() {

        System.out.println("\n===== HISTORIAL DE COMPRAS PROCESADAS =====");

        if (historialProcesados.estaVacia()) {
            System.out.println("No hay compras procesadas");
            return;
        }

        historialProcesados.mostrar();

    }

    // Buscar compra por su numero
    public CompraCliente buscarCompraPorNumero(int numeroCompra) throws Exception {
        for (int i = 0; i < listaGeneral.cuentaElementos(); i++) {
            
            CompraCliente compra = (CompraCliente) listaGeneral.buscarDato(i);

            if (compra.getNumeroCompra() == numeroCompra) {
                return compra;
            }
        }

        throw new Exception("No existe una compra con ese numero");
    }

    // Consultar una compra por su numero
    public void consultarCompra(int numeroCompra) throws Exception {

        CompraCliente compra = buscarCompraPorNumero(numeroCompra);

        System.out.println("\n===== COMPRA ENCONTRADA =====");
        System.out.println(compra);

    }

    // Cancelar una compra que se encuentre pendiente
    public void cancelarCompraPendiente(int numeroCompra) throws Exception {
        if (colaPendientes.estaVacia()) {
            throw new Exception("No hay compras pendientes para cancelar");
        }

        Cola auxiliar = new Cola();
        boolean encontrada = false;

        // Recorrer la cola original
        while (!colaPendientes.estaVacia()) {

            CompraCliente actual = (CompraCliente) colaPendientes.desencolar();

            if (actual.getNumeroCompra() == numeroCompra) {

                actual.setEstado("CANCELADA");
                encontrada = true;

            } else {

                auxiliar.encolar(actual);

            }
        }

        // Devolver las compras restantes a la cola original
        while(!auxiliar.estaVacia()) {

            CompraCliente actual = (CompraCliente) auxiliar.desencolar();

            colaPendientes.encolar(actual);

        }

        if (!encontrada) {
            throw new Exception("No se encontro una compra pendiente con ese numero");
        }

        System.out.println("Compra cancelada correctmanete");
    }

    // Deshacer el ultimo procesamiento realizado
    public void deshacerUltimoProcesamiento() throws Exception {
        if (historialProcesados.estaVacia()) {
            throw new Exception("No hay compras procesadas para deshacer");
        }

        // Recuperar la ultima compra procesada
        CompraCliente ultimo = (CompraCliente) historialProcesados.desapilar();

        ultimo.setEstado("PENDIENTE");

        colaPendientes.encolar(ultimo);

        System.out.println("\nSe deshizo el ultimo procesamiento");
        System.out.println("Compra devuelta a pendientes: ");
        System.out.println(ultimo);
    }

    // Mostrar las cantidades de compras segun su estado
    public void verCantidadCompras() throws Exception {
        
        int total = listaGeneral.cuentaElementos();
        
        int pendientes = 0;
        int procesadas = 0;
        int canceladas = 0;

        // Recorrer todas las compras registradas
        for (int i = 0; i < total; i++) {

            CompraCliente compra = (CompraCliente) listaGeneral.buscarDato(i);

            switch (compra.getEstado()) {

                case "PENDIENTE":
                    pendientes++;
                    break;
                
                case "PROCESADA":
                    pendientes++;
                    break;
                
                case "CANCELADA":
                    pendientes++;
                    break;
                
            }
        }

        System.out.println("\n===== CANTIDAD DE COMPRAS =====");
        System.out.println("Total registradas: " + total);
        System.out.println("Pendientes: " + pendientes);
        System.out.println("Procesadas: " + procesadas);
        System.out.println("Canceladas: " + canceladas);
    }

}
