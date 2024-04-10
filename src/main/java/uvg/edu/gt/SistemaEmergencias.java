package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class SistemaEmergencias {

    //Cambiar la variable Rutaarchvio por la ruta del archivo que deseas que el programa lea
    static String Rutaarchivo = "/Users/pala./Desktop/Algoritmos-EstructurasDTS/HDT8/src/main/java/uvg/edu/gt/pacientes.txt" ; // Cambiar aca
    public static void main(String[] args) {
        PriorityQueue<Paciente> colaEmergencias = new PriorityQueue<>();

        // Leer el archivo de texto y agregar los pacientes a la cola
        try (BufferedReader br = new BufferedReader(new FileReader(Rutaarchivo)))
        {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0].trim();
                String sintoma = datos[1].trim();
                char prioridad = datos[2].trim().charAt(0);
                Paciente paciente = new Paciente(nombre, sintoma, prioridad);
                colaEmergencias.add(paciente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer pacientes en orden de Prioridad
        while (!colaEmergencias.isEmpty()) {
            Paciente siguientePaciente = colaEmergencias.poll();
            System.out.println("Nombre: " + siguientePaciente.getNombre());
            System.out.println("Síntoma: " + siguientePaciente.getSintoma());
            System.out.println("Prioridad: " + siguientePaciente.getPrioridad());
            System.out.println();
        }
    }
}
