package parcial1rescateanimal;

import java.util.List;
import java.util.Objects;

/**
 * Programa principal del Sistema de Gestión Centro Rescate Animal v1.1.
 */
public class Parcial1RescateAnimal {

    /**
     * Punto de entrada. Carga animales de distintos tipos (el último es un
     * duplicado y debe ser rechazado) y ejecuta las funcionalidades del centro.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {

        CentroRescate centro = new CentroRescate("FaunaSur");

        registrar(centro, new Ave("AV-10", "Luna", EstadoSalud.ESTABLE, 80));
        registrar(centro, new Mamifero("MA-20", "Puma", EstadoSalud.EN_RECUPERACION, 12));
        registrar(centro, new Reptil("RE-30", "Sol", EstadoSalud.ESTABLE, 65));
        registrar(centro, new Ave("AV-40", "Nube", EstadoSalud.CRITICO, 50));

        registrar(centro, new Reptil("AV-10", "Luna", EstadoSalud.CRITICO, 90));

        System.out.println("Animales registrados:");
        mostrarAnimales(centro.obtenerAnimales());
        System.out.println("Rehabilitaciones:");
        mostrarRehabilitaciones(centro.obtenerAnimales());
        System.out.println("Liberaciones:");
        mostrarLiberaciones(centro.obtenerAnimales());
        System.out.println("Costo diario de cada animal:");
        mostrarCostos(centro.obtenerAnimales());
        System.out.println("Animales ESTABLES:");
        mostrarAnimales(centro.filtrarPorEstado(EstadoSalud.ESTABLE));
        System.out.println("Animales con costo diario hasta 100:");
        mostrarAnimales(centro.obtenerAnimalesConCostoMaximo(100));
    }

    /**
     * Intenta agregar un animal al centro. Como {@code agregarAnimal} lanza una
     * excepción chequeada, se atiende acá para que un duplicado no corte el programa.
     *
     * @param centro centro donde se registra el animal
     * @param animal animal a registrar
     */
    private static void registrar(CentroRescate centro, Animal animal) {
        try {
            centro.agregarAnimal(animal);
        } catch (AnimalDuplicadoException e) {
            System.out.println("No se pudo agregar el animal: " + e.getMessage());
        }
    }

    /**
     * Muestra cada animal de la lista; si está vacía, lo informa.
     *
     * @param animales animales a mostrar
     */
    private static void mostrarAnimales(List<Animal> animales) {
        if (animales.isEmpty()) {
            System.out.println("No hay animales para mostrar.");
            return;
        }
        for (Animal animal : animales) {
            Objects.requireNonNull(animal);
            System.out.println(animal);
        }
    }

    /**
     * Rehabilita a los animales {@link Rehabilitable} e informa de los que no pueden serlo.
     *
     * @param animales animales a recorrer
     */
    private static void mostrarRehabilitaciones(List<Animal> animales) {
        for (Animal animal : animales) {
            Objects.requireNonNull(animal);
            if (animal instanceof Rehabilitable rehabilitable) {
                System.out.println(rehabilitable.rehabilitar());
            } else {
                System.out.println("El animal '" + animal.getNombre() + "' (" + animal.getCodigo()
                        + ") no puede recibir rehabilitacion.");
            }
        }
    }

    /**
     * Libera a los animales {@link Liberable} e informa de los que no pueden serlo.
     *
     * @param animales animales a recorrer
     */
    private static void mostrarLiberaciones(List<Animal> animales) {
        for (Animal animal : animales) {
            Objects.requireNonNull(animal);
            if (animal instanceof Liberable liberable) {
                System.out.println(liberable.liberar());
            } else {
                System.out.println("El animal '" + animal.getNombre() + "' (" + animal.getCodigo()
                        + ") no puede ser liberado.");
            }
        }
    }

    /**
     * Muestra el costo diario de mantenimiento de cada animal.
     *
     * @param animales animales a recorrer
     */
    private static void mostrarCostos(List<Animal> animales) {
        for (Animal animal : animales) {
            Objects.requireNonNull(animal);
            System.out.println(animal.getCodigo() + " - " + animal.getNombre() + ": "
                    + animal.calcularCostoDiario() + " unidades");
        }
    }
}
