package parcial1rescateanimal;

/**
 * Contrato para los animales que pueden recibir rehabilitación
 * (aves y mamíferos).
 */
public interface Rehabilitable {

    /**
     * Realiza la rehabilitación del animal.
     *
     * @return mensaje que identifica al animal rehabilitado
     */
    String rehabilitar();
}
