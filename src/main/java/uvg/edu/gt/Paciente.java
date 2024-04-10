package uvg.edu.gt;
// Clase Paciente que implementa la interfaz Comparable para comparar pacientes por código de emergencia.
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Paciente {
    private String nombre;
    private String sintoma;
    private char codigoEmergencia;

    public Paciente(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }
}

public class SistemaAtencionEmergencias {
    public static void main(String[] args) {
        PriorityQueue<Paciente> colaEmergencias = new PriorityQueue<>((p1, p2) -> p1.getCodigoEmergencia() - p2.getCodigoEmergencia());

        try {
            Scanner scanner = new Scanner(new File("pacientes.txt"));
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
