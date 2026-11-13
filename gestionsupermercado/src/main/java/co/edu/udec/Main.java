package co.edu.udec;

import java.time.LocalDate;
import java.util.Scanner;

import co.edu.udec.aplicacion.SistemaSupermercado;
import co.edu.udec.modelo.CompraCliente;


public class Main 
{
    public static void main( String[] args )
    {
        
        Scanner scanner = new Scanner(System.in);
        SistemaSupermercado sistema = new SistemaSupermercado();

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE GESTION DEL SUPERMERCADO =====");
            System.out.println("1. Registrar elemento");
            System.out.println("2. Ver todos los elementos registrados");
            System.out.println("3. Ver elementos pendientes");
            System.out.println("4. Procesar siguiente elemento");
            System.out.println("5. Ver historial de elementos procesados");
            System.out.println("6. Buscar elemento por codigo");
            System.out.println("7. Cancelar elemento pendiente");
            System.out.println("8. Deshacer ultimo procesamiento");
            System.out.println("9. Ver cantidad de elementos");
            System.out.println("10. Salir");

            System.out.println("\nSeleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:
                    registrarCompra(scanner, sistema);
                    break;
                
                case 2:
                    sistema.verComprasRegistradas();
                    break;

                case 3:
                    sistema.verComprasPendientes();
                    break;

                case 4:
                    try {
                        sistema.procesarSiguienteCompra();
                    } catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    sistema.verHistorialProcesados();
                    break;

                case 6:
                    buscarCompra(scanner, sistema);
                    break;

                case 7:
                    cancelarCompra(scanner, sistema);
                    break;

                case 8:
                    try {
                        sistema.deshacerUltimoProcesamiento();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 9:
                    try {
                        sistema.verCantidadCompras();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 10:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 10);

        scanner.close();
        
    }

    // Registrar una compra por consola
    public static void registrarCompra(Scanner scanner, SistemaSupermercado sistema) {

        try {

            System.out.println("\n===== REGISTRAR COMPRA =====");

            System.out.println("Numero de copia: ");
            int numeroCompra = Integer.parseInt(scanner.nextLine());

            System.out.println("Nombre del cliente: ");
            String nombreCliente = scanner.nextLine();

            System.out.println("Fecha de compra (AÑO-MES-DIA): ");
            LocalDate fechaCompra = LocalDate.parse(scanner.nextLine());

            System.out.println("Cantidad de productos: ");
            int cantidadProductos = Integer.parseInt(scanner.nextLine());

            System.out.println("Total de la compra: ");
            double totalCompra = Double.parseDouble(scanner.nextLine());

            CompraCliente compra = new CompraCliente(numeroCompra, nombreCliente, fechaCompra, cantidadProductos, totalCompra, "PENDIENTE");

            sistema.registrarCompra(compra);

        } catch (Exception e) {
            System.out.println("Error al registrar la compra: " + e.getMessage());
        }
    }

    // Buscar una compra desde la consola
    public static void buscarCompra(Scanner scanner, SistemaSupermercado sistema) {

        try {

            System.out.println("\n===== BUSCAR COMPRA =====");

            System.out.println("Ingrese el numero de compra: ");
            int numeroCompra = Integer.parseInt(scanner.nextLine());

            sistema.consultarCompra(numeroCompra);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Cancelar una compra desde la consola
    public static void cancelarCompra(Scanner scanner, SistemaSupermercado sistema) {

        try {

            System.out.println("\n===== CANCELAR COMPRA =====");

            System.out.println("Ingrese el numero de compra: ");
            int numeroCompra = Integer.parseInt(scanner.nextLine());

            sistema.cancelarCompraPendiente(numeroCompra);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
