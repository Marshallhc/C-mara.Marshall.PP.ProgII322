package parcial1rescateanimal;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Centro de Rescate que registra animales silvestres y administra su cuidado.
 *
 * <p>Los animales se guardan en un {@link LinkedHashSet}: conserva el orden de
 * carga y, apoyándose en {@code equals}/{@code hashCode} de {@link Animal},
 * detecta duplicados sin recorrer toda la colección.</p>
 */
public class CentroRescate {

    private static final String MENSAJE_NOMBRE_INVALIDO = "El nombre del centro no puede ser nulo ni estar en blanco";
    private static final String MENSAJE_ANIMAL_NULO = "El animal no puede ser nulo";
    private static final String MENSAJE_ESTADO_NULO = "El estado de salud no puede ser nulo";
    private static final String MENSAJE_MAXIMO_INVALIDO = "El costo maximo debe ser mayor que cero";

    private final String nombre;
    private final Set<Animal> animales;

    /**
     * Crea un centro de rescate sin animales.
     *
     * @param nombre nombre del centro (no nulo ni en blanco)
     * @throws AtributoInvalidoException si el nombre es nulo o está en blanco
     */
    public CentroRescate(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new AtributoInvalidoException(MENSAJE_NOMBRE_INVALIDO);
        }
        this.nombre = nombre;
        this.animales = new LinkedHashSet<>();
    }

    /**
     * Devuelve el nombre del centro.
     *
     * @return nombre del centro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Incorpora un animal de cualquier tipo al centro.
     *
     * @param animal animal a registrar (no nulo)
     * @throws NullPointerException     si el animal es nulo
     * @throws AnimalDuplicadoException si ya existe otro animal igual
     *                                  (mismo código y mismo nombre)
     */
    public void agregarAnimal(Animal animal) throws AnimalDuplicadoException {
        Objects.requireNonNull(animal, MENSAJE_ANIMAL_NULO);
        if (!animales.add(animal)) {
            throw new AnimalDuplicadoException("Ya existe un animal con codigo '"
                    + animal.getCodigo() + "' y nombre '" + animal.getNombre() + "'.");
        }
    }

    /**
     * Devuelve los animales registrados, en el orden de carga, en una nueva
     * lista (modificarla no altera el centro).
     *
     * @return copia de los animales registrados
     */
    public List<Animal> obtenerAnimales() {
        return new ArrayList<>(animales);
    }

    /**
     * Devuelve los animales que tienen el estado de salud indicado.
     *
     * @param estado estado buscado (no nulo)
     * @return nueva lista con los animales de ese estado, en orden de carga
     * @throws NullPointerException si el estado es nulo
     */
    public List<Animal> filtrarPorEstado(EstadoSalud estado) {
        Objects.requireNonNull(estado, MENSAJE_ESTADO_NULO);
        List<Animal> filtrados = new ArrayList<>();
        for (Animal animal : animales) {
            if (animal.getEstado() == estado) {
                filtrados.add(animal);
            }
        }
        return filtrados;
    }

    /**
     * Devuelve los animales cuyo costo diario es menor o igual al máximo.
     *
     * @param maximo costo diario máximo (mayor que cero)
     * @return nueva lista con los animales que cumplen, en orden de carga
     * @throws AtributoInvalidoException si el máximo es menor o igual a cero
     */
    public List<Animal> obtenerAnimalesConCostoMaximo(double maximo) {
        if (Double.isNaN(maximo) || maximo <= 0) {
            throw new AtributoInvalidoException(MENSAJE_MAXIMO_INVALIDO);
        }
        List<Animal> resultado = new ArrayList<>();
        for (Animal animal : animales) {
            if (animal.calcularCostoDiario() <= maximo) {
                resultado.add(animal);
            }
        }
        return resultado;
    }
}
