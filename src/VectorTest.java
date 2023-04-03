import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VectorTest {

    @Test
    public void testAdd() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(10);
        heap.add(20);
        heap.add(15);

        Vector<Integer> expected = new Vector<>();
        expected.add(10);
        expected.add(20);
        expected.add(15);

        assertEquals(expected, heap.data);
    }

    @Test
    public void testRemove() {
        VectorHeap<Integer> heap = new VectorHeap<>();
        heap.add(10);
        heap.add(20);
        heap.add(15);

        int minVal = heap.remove();

        Vector<Integer> expected = new Vector<>();
        expected.add(15);
        expected.add(20);

        assertEquals(10, minVal);
        assertEquals(expected, heap.data);
    }

}