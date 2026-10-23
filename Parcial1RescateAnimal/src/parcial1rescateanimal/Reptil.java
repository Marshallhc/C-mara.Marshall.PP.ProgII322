package parcial1rescateanimal;

/**
 * Reptil alojado en el Centro de Rescate. Puede realizar un proceso de
 * liberación. Su dato específico es la longitud, en centímetros.
 */
public class Reptil extends Animal implements Liberable {

    private static final String MENSAJE_LONGITUD_INVALIDA = "La longitud debe ser estrictamente positiva";
    private static final double COSTO_FIJO = 15;

    private final double longitud;

    /**
     * Crea un reptil.
     *
     * @param codigo   código del animal
     * @param nombre   nombre identificatorio
     * @param estado   estado de salud
     * @param longitud longitud en centímetros (mayor que cero)
     * @throws AtributoInvalidoException si algún dato no cumple las reglas
     */
    public Reptil(String codigo, String nombre, EstadoSalud estado, double longitud) {
        super(codigo, nombre, estado);
        this.longitud = validarMedidaPositiva(longitud, MENSAJE_LONGITUD_INVALIDA);
    }

    /**
     * Devuelve la longitud del reptil.
     *
     * @return longitud en centímetros
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * Costo diario del reptil: longitud + 15.
     *
     * @return costo diario de mantenimiento
     */
    @Override
    public double calcularCostoDiario() {
        return longitud + COSTO_FIJO;
    }

    @Override
    public String liberar() {
        return "El reptil '" + getNombre() + "' (" + getCodigo() + ") fue liberado.";
    }

    @Override
    public String toString() {
        return "Reptil [" + describirDatosComunes() + ", longitud=" + longitud + " cm]";
    }
}
