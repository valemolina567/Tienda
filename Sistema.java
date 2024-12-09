package udla.valeria.molina.exa.prog2;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Producto> productos = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();
    private List<Venta> ventas = new ArrayList<>();

    // Métodos para productos
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String codigo) {
        productos.removeIf(producto -> producto.getCodigo().equals(codigo));
    }

    public void actualizarProducto(String codigo, int nuevaCantidad) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.actualizarCantidad(nuevaCantidad);
                break;
            }
        }
    }

    public Producto buscarProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            productos.forEach(producto -> {
                System.out.println("Código: " + producto.getCodigo() +
                        ", Nombre: " + producto.getNombre() +
                        ", Precio: " + producto.getPrecio() +
                        ", Cantidad: " + producto.getCantidad());
            });
        }
    }

    // Métodos para empleados
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(String id) {
        empleados.removeIf(empleado -> empleado.getId().equals(id));
    }

    public Empleado buscarEmpleado(String id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null;
    }

    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            empleados.forEach(empleado -> {
                System.out.println("ID: " + empleado.getId() +
                        ", Nombre: " + empleado.getNombre() +
                        ", Salario: " + empleado.getSalario());
            });
        }
    }

    // Métodos para ventas
    public void registrarVenta(Venta venta) {
        ventas.add(venta);
    }

    public double calcularTotalVentas() {
        return ventas.stream().mapToDouble(Venta::getTotal).sum();
    }
}