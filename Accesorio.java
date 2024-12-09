package udla.valeria.molina.exa.prog2;

public class Accesorio extends Producto {
    private String tipo;

    public Accesorio(String codigo, String nombre, double precio, int cantidad, String tipo) {
        super(codigo, nombre, precio, cantidad);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
