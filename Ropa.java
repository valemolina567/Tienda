package udla.valeria.molina.exa.prog2;

public class Ropa extends Producto {
    private String talla;

    public Ropa(String codigo, String nombre, double precio, int cantidad, String talla) {
        super(codigo, nombre, precio, cantidad);
        this.talla = talla;
    }

    public String getTalla() {
        return talla;
    }
}