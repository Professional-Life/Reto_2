import Entity.entityStudent;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creamos las listas de estudiantes que están matriculados en cada asignatura.
        List<entityStudent> mathematics = new ArrayList<>();
        List<entityStudent> french = new ArrayList<>();
        List<entityStudent> both = new ArrayList<>();

        // Estudiantes de diferentes sedes.
        entityStudent student1 = new entityStudent("Ana", "Málaga");
        entityStudent student2 = new entityStudent("Luis", "Madrid");
        entityStudent student3 = new entityStudent("Pedro", "Málaga");
        entityStudent student4 = new entityStudent("Marta", "Málaga");
        entityStudent student5 = new entityStudent("Carla", "Sevilla");
        entityStudent student6 = new entityStudent("Edwin", "Sevilla");
        entityStudent student7 = new entityStudent("Ivan", "Málaga");

        // Añadimos algunos estudiantes a cada lista, para simulación.
        mathematics.add(student1);
        mathematics.add(student2);
        mathematics.add(student3);
        french.add(student4);
        french.add(student3);
        french.add(student5);
        french.add(student7);
        both.add(student3);
        both.add(student6);

        // Llamamos al procedimiento para notificar a cada asignatura, y sobre una sede en específico.
        notifications(mathematics, french, both);
    }

    /**
     * Procedimiento que notifica a los estudiantes que estén en una sede indicada, tomando en cuenta
     * la asignatura que está matriculado cada estudiante.
     * @param mathematics El parámetro mathematics indica la lista de estudiantes que están matriculados en la asignatura de Matemáticas.
     * @param french El parámetro french indica la lista de estudiantes que están matriculados en la asignatura de Francés.
     * @param both El parámetro both indica la lista de estudiantes que están matriculados en las asignatura de Matemáticas y Francés.
     */
    public static void notifications(List<entityStudent> mathematics, List<entityStudent> french, List<entityStudent> both){

        // Dejamos indicada la sede que debemos de notificar.
        String siteTarget = "Málaga";

        // Creamos una copia de cada lista de estudiantes, para no afectar a la original.
        List<entityStudent> notifyForMath = new ArrayList<>(List.copyOf(mathematics));
        List<entityStudent> notifyForFrench = new ArrayList<>(List.copyOf(french));
        List<entityStudent> notifyForBoth = new ArrayList<>(List.copyOf(both));

        // De la lista de estudiantes donde están ambas materias, se eliminan los estudiantes que estén
        // en las otras listas, para no repetir la notificación.
        notifyForBoth.forEach(entityStudent -> {
            notifyForMath.remove(entityStudent);
            notifyForFrench.remove(entityStudent);
        });

        // Para cada lista, se eliminan los estudiantes que NO son de la sede indicada anteriormente.
        notifyForMath.removeIf(student -> !student.getSite().equalsIgnoreCase(siteTarget));
        notifyForFrench.removeIf(student -> !student.getSite().equalsIgnoreCase(siteTarget));
        notifyForBoth.removeIf(student -> !student.getSite().equalsIgnoreCase(siteTarget));

        // Lista de estudiantes original.
        System.out.println("\nLista original (Matemáticas): \n" + mathematics);
        System.out.println("\nLista original (Francés): \n" + french);
        System.out.println("\nLista original (Matemáticas y Francés): \n" + both);
        System.out.println("\n========================================================================================\n");

        // Mostramos los resultados de las listas a notificar de cada estudiante.
        System.out.println("\nLista de estudiantes a notificar (Matemáticas): \n" + notifyForMath);
        System.out.println("\nLista de estudiantes a notificar (Francés): \n" +notifyForFrench);
        System.out.println("\nLista de estudiantes a notificar (Matemáticas y Francés): \n" + notifyForBoth);
    }
}