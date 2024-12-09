package udla.valeria.molina.exa.prog2;

import java.util.ArrayList;
import java.util.List;

// Clase abstracta Producto
public abstract class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void reducirCantidad(int cantidadVendida) {
        if (cantidad >= cantidadVendida) {
            cantidad -= cantidadVendida;
        } else {
            System.out.println("Inventario insuficiente para el producto: " + nombre);
        }
    }

    public void actualizarCantidad(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }
}
