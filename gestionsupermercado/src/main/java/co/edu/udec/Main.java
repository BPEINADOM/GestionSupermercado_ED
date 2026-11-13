package co.edu.udec;

import java.time.LocalDate;
import java.util.Scanner;

import co.edu.udec.aplicacion.SistemaSupermercado;
import co.edu.udec.modelo.CompraCliente;

/**
 * Hello world!
 *
 */
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
                    System.out.println("Registrar un elemento");
                case 2:
                    sistema.verComprasRegistradas();
                    break;

                case 3:
                    sistema.verComprasPendientes();
                    break;

                case 4:
                    System.out.println("Procesar siguiente elemento");
                    break;

                case 5:
                    sistema.verHistorialProcesados();
                    break;

                case 6:
                    System.out.println("Buscar elemento por codigo");
                    break;

                case 7:
                    System.out.println("Cancelar elemento pendiente");
                    break;

                case 8:
                    System.out.println("Deshacer ultimo procesamiento");
                    break;

                case 9:
                    System.out.println("Ver cantidad de elementos");
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
}
