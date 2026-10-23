package parcial1rescateanimal;

/**
 * Excepción no chequeada que se lanza cuando un atributo o argumento no
 * cumple las reglas del sistema (cadenas nulas o en blanco, medidas no
 * positivas, estado nulo, máximo menor o igual a cero, etc.).
 */
public class AtributoInvalidoException extends IllegalArgumentException {

    private static final String MENSAJE_DEFAULT = "Atributo invalido";

    /**
     * Crea la excepción con el mensaje por defecto.
     */
    public AtributoInvalidoException() {
        this(MENSAJE_DEFAULT);
    }

    /**
     * Crea la excepción con un mensaje descriptivo.
     *
     * @param mensaje detalle del atributo inválido
     */
    public AtributoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
