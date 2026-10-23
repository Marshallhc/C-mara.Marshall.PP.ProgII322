package parcial1rescateanimal;

/**
 * Excepción chequeada que se lanza cuando se intenta registrar en el centro
 * un animal igual a otro ya existente (mismo código y mismo nombre
 * identificatorio).
 */
public class AnimalDuplicadoException extends Exception {

    private static final String MENSAJE_DEFAULT = "Animal duplicado";

    /**
     * Crea la excepción con el mensaje por defecto.
     */
    public AnimalDuplicadoException() {
        this(MENSAJE_DEFAULT);
    }

    /**
     * Crea la excepción con un mensaje descriptivo.
     *
     * @param mensaje detalle del animal duplicado
     */
    public AnimalDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
