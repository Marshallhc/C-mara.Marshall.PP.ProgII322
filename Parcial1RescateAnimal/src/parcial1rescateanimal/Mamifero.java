package parcial1rescateanimal;

/**
 * Mamífero alojado en el Centro de Rescate. Puede recibir rehabilitación.
 * Su dato específico es el peso, en kilogramos.
 */
public class Mamifero extends Animal implements Rehabilitable {

    private static final String MENSAJE_PESO_INVALIDO = "El peso debe ser estrictamente positivo";
    private static final double FACTOR_COSTO = 10;

    private final double peso;

    /**
     * Crea un mamífero.
     *
     * @param codigo código del animal
     * @param nombre nombre identificatorio
     * @param estado estado de salud
     * @param peso   peso en kilogramos (mayor que cero)
     * @throws AtributoInvalidoException si algún dato no cumple las reglas
     */
    public Mamifero(String codigo, String nombre, EstadoSalud estado, double peso) {
        super(codigo, nombre, estado);
        this.peso = validarMedidaPositiva(peso, MENSAJE_PESO_INVALIDO);
    }

    /**
     * Devuelve el peso del mamífero.
     *
     * @return peso en kilogramos
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Costo diario del mamífero: peso × 10.
     *
     * @return costo diario de mantenimiento
     */
    @Override
    public double calcularCostoDiario() {
        return peso * FACTOR_COSTO;
    }

    @Override
    public String rehabilitar() {
        return "El mamifero '" + getNombre() + "' (" + getCodigo() + ") recibio rehabilitacion.";
    }

    @Override
    public String toString() {
        return "Mamifero [" + describirDatosComunes() + ", peso=" + peso + " kg]";
    }
}
