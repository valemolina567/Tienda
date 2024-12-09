package udla.valeria.molina.exa.prog2;

public class Calzado extends Producto {
    private int numero;

    public Calzado(String codigo, String nombre, double precio, int cantidad, int numero) {
        super(codigo, nombre, precio, cantidad);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
