import java.util.Scanner;

public class RegistroVentasTienda {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalGeneral = 0;
        int productosAltos = 0;
        int productosBajos = 0;

        System.out.println("=== Registro de Ventas del Día ===");

        while (true) {
            System.out.print("\nIngrese el nombre del producto (o escriba 'salir' para terminar): ");
            String nombre = sc.nextLine();
            if (nombre.trim().equalsIgnoreCase("salir")) {
                break;
            }

            System.out.print("Precio unitario ($): ");
            double precio = sc.nextDouble();

            System.out.print("Cantidad vendida: ");
            int cantidad = sc.nextInt();

            double totalVenta = precio * cantidad;
            totalGeneral += totalVenta;

            if (totalVenta >= 100000) {
                productosAltos++;
            } else if (totalVenta < 50000) {
                productosBajos++;
            }

            System.out.printf("Total venta de '%s': $%,.2f\n", nombre, totalVenta);
        }

        // Resultados finales
        System.out.println("\n===== Resumen del Día =====");
        System.out.printf("Total general del día: $%,.2f\n", totalGeneral);
        System.out.println("Productos con ventas altas (≥ $100.000): " + productosAltos);
        System.out.println("Productos con ventas bajas (< $50.000): " + productosBajos);

        // Mensaje especial según el total del día
        if (totalGeneral >= 500000) {
            System.out.println("¡Buen día de ventas!");
        } else if (totalGeneral >= 200000 && totalGeneral < 500000) {
            System.out.println("Día regular.");
        } else {
            System.out.println("Pocas ventas hoy.");
        }

        sc.close();
        System.out.println("===========================");
    }
}
