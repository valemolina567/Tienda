package udla.valeria.molina.exa.prog2;

public class Vendedor extends Empleado {
    private double comision;

    public Vendedor(String id, String nombre, double salario, double comision) {
        super(id, nombre, salario);
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }
}
