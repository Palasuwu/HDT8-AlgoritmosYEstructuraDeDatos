package uvg.edu.gt;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SistemaAtencionEmergencias {
    public static void main(String[] args) {
        PriorityQueue<Paciente> colaEmergencias = new PriorityQueue<>();

        try {
            Scanner scanner = new Scanner(new File("/Users/pala./Desktop/Algoritmos-EstructurasDTS/HDT8/src/main/java/uvg/edu/gt/pacientes.txt"));
            while (scanner.hasNextLine()) {
                String[] datosPaciente = scanner.nextLine().split(",");
                String nombre = datosPaciente[0].trim();
                String sintoma = datosPaciente[1].trim();
                char codigoEmergencia = datosPaciente[2].trim().charAt(0);
                colaEmergencias.offer(new Paciente(nombre, sintoma, codigoEmergencia));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
            return;
        }

        while (!colaEmergencias.isEmpty()) {
            Paciente paciente = colaEmergencias.poll();
            System.out.println("Nombre: " + paciente.getNombre() + ", Síntoma: " + paciente.getSintoma() + ", Prioridad: " + paciente.getCodigoEmergencia());
        }
    }
}
