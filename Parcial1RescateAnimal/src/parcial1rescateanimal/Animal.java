package parcial1rescateanimal;

import java.util.Objects;

/**
 * Clase abstracta que representa a un animal silvestre alojado en el Centro
 * de Rescate. Todo animal tiene un código, un nombre identificatorio y un
 * estado de salud.
 *
 * <p>Dos animales son iguales cuando coinciden su código y su nombre
 * identificatorio, sin importar su tipo, estado de salud ni características
 * específicas.</p>
 */
public abstract class Animal {

    private static final String MENSAJE_CODIGO_INVALIDO = "El codigo del animal no puede ser nulo ni estar en blanco";
    private static final String MENSAJE_NOMBRE_INVALIDO = "El nombre del animal no puede ser nulo ni estar en blanco";
    private static final String MENSAJE_ESTADO_INVALIDO = "El estado de salud del animal no puede ser nulo";

    private final String codigo;
    private final String nombre;
    private final EstadoSalud estado;

    /**
     * Crea un animal validando sus datos comunes.
     *
     * @param codigo código del animal (no nulo ni en blanco)
     * @param nombre nombre identificatorio (no nulo ni en blanco)
     * @param estado estado de salud (no nulo)
     * @throws AtributoInvalidoException si algún dato no cumple las reglas
     */
    protected Animal(String codigo, String nombre, EstadoSalud estado) {
        validarCadena(codigo, MENSAJE_CODIGO_INVALIDO);
        validarCadena(nombre, MENSAJE_NOMBRE_INVALIDO);
        if (estado == null) {
            throw new AtributoInvalidoException(MENSAJE_ESTADO_INVALIDO);
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
    }

    /**
     * Calcula el costo diario de mantenimiento del animal. El cálculo
     * depende del tipo de animal.
     *
     * @return costo diario de mantenimiento, en unidades
     */
    public abstract double calcularCostoDiario();

    /**
     * Devuelve una representación textual completa del animal.
     *
     * @return texto con los datos comunes y los específicos del tipo
     */
    @Override
    public abstract String toString();

    /**
     * Devuelve el código del animal.
     *
     * @return código
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Devuelve el nombre identificatorio del animal.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el estado de salud del animal.
     *
     * @return estado de salud
     */
    public EstadoSalud getEstado() {
        return estado;
    }

    /**
     * Dos animales son iguales si coinciden su código y su nombre.
     *
     * @param o objeto a comparar
     * @return {@code true} si ambos son animales con igual código y nombre
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Animal otro)) {
            return false;
        }
        return codigo.equals(otro.codigo) && nombre.equals(otro.nombre);
    }

    /**
     * Código hash coherente con {@link #equals(Object)}.
     *
     * @return código hash calculado con código y nombre
     */
    @Override
    public final int hashCode() {
        return Objects.hash(codigo, nombre);
    }

    /**
     * Devuelve los datos comunes del animal para que las subclases armen
     * su {@code toString()} sin repetir código.
     *
     * @return texto con código, nombre y estado
     */
    protected String describirDatosComunes() {
        return "codigo=" + codigo + ", nombre=" + nombre + ", estado=" + estado;
    }

    /**
     * Valida que una medida sea estrictamente positiva.
     *
     * @param medida  valor a validar
     * @param mensaje mensaje de la excepción si no es válida
     * @return la misma medida, si es válida
     * @throws AtributoInvalidoException si la medida es menor o igual a cero o no es un número
     */
    protected static double validarMedidaPositiva(double medida, String mensaje) {
        if (Double.isNaN(medida) || medida <= 0) {
            throw new AtributoInvalidoException(mensaje);
        }
        return medida;
    }

    private static void validarCadena(String cadena, String mensaje) {
        if (cadena == null || cadena.isBlank()) {
            throw new AtributoInvalidoException(mensaje);
        }
    }
}
