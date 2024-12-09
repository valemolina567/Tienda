package udla.valeria.molina.exa.prog2;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String id;
    private String fecha;
    private Empleado empleado;
    private List<Producto> productosVendidos = new ArrayList<>();
    private double total;

    public Venta(String id, String fecha, Empleado empleado) {
        this.id = id;
        this.fecha = fecha;
        this.empleado = empleado;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto.getCantidad() >= cantidad) {
            productosVendidos.add(producto);
            producto.reducirCantidad(cantidad);
            total += producto.getPrecio() * cantidad;
        } else {
            System.out.println("No hay suficiente inventario para el producto: " + producto.getNombre());
        }
    }

    public double getTotal() {
        return total;
    }
}
