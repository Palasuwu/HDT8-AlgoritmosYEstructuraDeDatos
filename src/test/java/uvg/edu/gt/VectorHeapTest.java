package uvg.edu.gt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

//Se crean instancias de la clase VectorHeap.
//Se agregan pacientes al heap usando el metodo add.
//Se comprueba si los metodos peek y poll devuelven el paciente correcto sin eliminarlo.
//Se prueba el metodo remove para eliminar y devolver al paciente con la máxima prioridad.
//Se prueba el metodo clear para asegurarse de que el heap quede vacio después de borrar todos los elementos.

public class VectorHeapTest {

    private VectorHeap<Paciente> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    public void testAdd() {
        assertTrue(heap.isEmpty());
        heap.add(new Paciente("Juan", "Fractura de pierna", 'C'));
        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());
    }

    @Test
    public void testRemove() {
        assertTrue(heap.isEmpty());
        Paciente p1 = new Paciente("Juan", "Fractura de pierna", 'C');
        Paciente p2 = new Paciente("Maria", "Apendicitis", 'A');
        heap.add(p1);
        heap.add(p2);

        assertEquals(p2, heap.remove());
        assertEquals(p1, heap.remove());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testPeek() {
        assertTrue(heap.isEmpty());
        Paciente p1 = new Paciente("Juan", "Fractura de pierna", 'C');
        Paciente p2 = new Paciente("Maria", "Apendicitis", 'A');
        heap.add(p1);
        heap.add(p2);

        assertEquals(p2, heap.peek());
        assertFalse(heap.isEmpty());
        assertEquals(2, heap.size());
    }

    @Test
    public void testPoll() {
        assertTrue(heap.isEmpty());
        Paciente p1 = new Paciente("Juan", "Fractura de pierna", 'C');
        Paciente p2 = new Paciente("Maria", "Apendicitis", 'A');
        heap.add(p1);
        heap.add(p2);

        assertEquals(p2, heap.poll());
        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());
    }

    @Test
    public void testClear() {
        assertTrue(heap.isEmpty());
        heap.add(new Paciente("Juan", "Fractura de pierna", 'C'));
        assertFalse(heap.isEmpty());
        assertEquals(1, heap.size());

        heap.clear();
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }
}
