package parcial1rescateanimal;

/**
 * Contrato para los animales que pueden realizar un proceso de liberación
 * (aves y reptiles).
 */
public interface Liberable {

    /**
     * Realiza el proceso de liberación del animal.
     *
     * @return mensaje que identifica al animal liberado
     */
    String liberar();
}
