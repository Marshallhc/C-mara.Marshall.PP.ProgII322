package parcial1rescateanimal;

/**
 * Ave alojada en el Centro de Rescate. Puede recibir rehabilitación y
 * realizar un proceso de liberación. Su dato específico es la envergadura
 * alar, en centímetros.
 */
public class Ave extends Animal implements Rehabilitable, Liberable {

    private static final String MENSAJE_ENVERGADURA_INVALIDA = "La envergadura alar debe ser estrictamente positiva";
    private static final double FACTOR_COSTO = 2;

    private final double envergaduraAlar;

    /**
     * Crea un ave.
     *
     * @param codigo          código del animal
     * @param nombre          nombre identificatorio
     * @param estado          estado de salud
     * @param envergaduraAlar envergadura alar en centímetros (mayor que cero)
     * @throws AtributoInvalidoException si algún dato no cumple las reglas
     */
    public Ave(String codigo, String nombre, EstadoSalud estado, double envergaduraAlar) {
        super(codigo, nombre, estado);
        this.envergaduraAlar = validarMedidaPositiva(envergaduraAlar, MENSAJE_ENVERGADURA_INVALIDA);
    }

    /**
     * Devuelve la envergadura alar del ave.
     *
     * @return envergadura alar en centímetros
     */
    public double getEnvergaduraAlar() {
        return envergaduraAlar;
    }

    /**
     * Costo diario del ave: envergadura alar × 2.
     *
     * @return costo diario de mantenimiento
     */
    @Override
    public double calcularCostoDiario() {
        return envergaduraAlar * FACTOR_COSTO;
    }

    @Override
    public String rehabilitar() {
        return "El ave '" + getNombre() + "' (" + getCodigo() + ") recibio rehabilitacion.";
    }

    @Override
    public String liberar() {
        return "El ave '" + getNombre() + "' (" + getCodigo() + ") fue liberada.";
    }

    @Override
    public String toString() {
        return "Ave [" + describirDatosComunes() + ", envergaduraAlar=" + envergaduraAlar + " cm]";
    }
}
