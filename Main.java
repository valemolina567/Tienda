import udla.valeria.molina.exa.prog2.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestionar Productos");
            System.out.println("2. Gestionar Empleados");
            System.out.println("3. Registrar Venta");
            System.out.println("4. Mostrar Total de Ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    gestionarProductos(sistema, scanner);
                    break;
                case 2:
                    gestionarEmpleados(sistema, scanner);
                    break;
                case 3:
                    registrarVenta(sistema, scanner);
                    break;
                case 4:
                    System.out.println("Total de ventas: $" + sistema.calcularTotalVentas());
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void gestionarProductos(Sistema sistema, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE PRODUCTOS ===");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Listar Productos");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de producto (Ropa/Calzado/Accesorio): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    if (tipo.equalsIgnoreCase("Ropa")) {
                        System.out.print("Talla: ");
                        String talla = scanner.nextLine();
                        sistema.agregarProducto(new Ropa(codigo, nombre, precio, cantidad, talla));
                    } else if (tipo.equalsIgnoreCase("Calzado")) {
                        System.out.print("Número: ");
                        int numero = scanner.nextInt();
                        sistema.agregarProducto(new Calzado(codigo, nombre, precio, cantidad, numero));
                    } else if (tipo.equalsIgnoreCase("Accesorio")) {
                        System.out.print("Tipo: ");
                        String tipoAccesorio = scanner.nextLine();
                        sistema.agregarProducto(new Accesorio(codigo, nombre, precio, cantidad, tipoAccesorio));
                    } else {
                        System.out.println("Tipo de producto no válido.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el código del producto a eliminar: ");
                    String codigoEliminar = scanner.nextLine();
                    sistema.eliminarProducto(codigoEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el código del producto a actualizar: ");
                    String codigoActualizar = scanner.nextLine();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();
                    sistema.actualizarProducto(codigoActualizar, nuevaCantidad);
                    break;
                case 4:
                    sistema.listarProductos();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void gestionarEmpleados(Sistema sistema, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE EMPLEADOS ===");
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Eliminar Empleado");
            System.out.println("3. Listar Empleados");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de empleado (Vendedor/Gerente): ");
                    String tipo = scanner.nextLine();
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer

                    if (tipo.equalsIgnoreCase("Vendedor")) {
                        System.out.print("Comisión: ");
                        double comision = scanner.nextDouble();
                        sistema.agregarEmpleado(new Vendedor(id, nombre, salario, comision));
                    } else if (tipo.equalsIgnoreCase("Gerente")) {
                        System.out.print("Bono Anual: ");
                        double bono = scanner.nextDouble();
                        sistema.agregarEmpleado(new Gerente(id, nombre, salario, bono));
                    } else {
                        System.out.println("Tipo de empleado no válido.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el ID del empleado a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    sistema.eliminarEmpleado(idEliminar);
                    break;
                case 3:
                    sistema.listarEmpleados();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void registrarVenta(Sistema sistema, Scanner scanner) {
        System.out.print("ID de la Venta: ");
        String idVenta = scanner.nextLine();
        System.out.print("Fecha: ");
        String fecha = scanner.nextLine();
        System.out.print("ID del Empleado: ");
        String idEmpleado = scanner.nextLine();

        Empleado empleado = sistema.buscarEmpleado(idEmpleado);
        if (empleado == null) {
            System.out.println("Empleado no encontrado.");
            return;
        }

        Venta venta = new Venta(idVenta, fecha, empleado);
        String agregarMas;
        do {
            System.out.print("Ingrese el código del producto: ");
            String codigoProducto = scanner.nextLine();
            Producto producto = sistema.buscarProducto(codigoProducto);

            if (producto != null) {
                System.out.print("Cantidad a vender: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                venta.agregarProducto(producto, cantidad);
            } else {
                System.out.println("Producto no encontrado.");
            }

            System.out.print("¿Desea agregar otro producto a la venta? (s/n): ");
            agregarMas = scanner.nextLine();
        } while (agregarMas.equalsIgnoreCase("s"));

        sistema.registrarVenta(venta);
        System.out.println("Venta registrada con éxito.");
    }
}