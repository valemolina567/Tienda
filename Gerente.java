package udla.valeria.molina.exa.prog2;

public class Gerente extends Empleado {
    private double bonoAnual;

    public Gerente(String id, String nombre, double salario, double bonoAnual) {
        super(id, nombre, salario);
        this.bonoAnual = bonoAnual;
    }

    public double getBonoAnual() {
        return bonoAnual;
    }
}
