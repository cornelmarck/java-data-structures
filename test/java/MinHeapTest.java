import data_structures.Heap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MinHeapTest {
    @Test
    void constructEmpty() {
        Heap<Integer> h = new Heap<Integer>(Comparator.reverseOrder());
        assertEquals(0, h.size());
    }

    @Test
    void buildHeap() {
        List<Integer> l = new ArrayList<>();
        l.add(20);
        l.add(50);
        l.add(8);
        l.add(-3);

        Heap<Integer> h = new Heap<>(l, Comparator.reverseOrder());
        assertEquals(-3, h.get(0));
        assertNotEquals(50, h.get(1));
        assertNotEquals(50, h.get(2));
    }

    @Test
    void insert() {
        Heap<Integer> h = new Heap<Integer>(Comparator.reverseOrder());
        h.insert(50);
        h.insert(20);
        h.insert(8);
        h.insert(-3);

        assertEquals(-3, h.get(0));
    }

    @Test
    void remove() {
        Heap<Integer> h = new Heap<Integer>(Comparator.reverseOrder());
        h.insert(20);
        h.insert(50);
        h.insert(-3);
        h.insert(8);

        assertEquals(-3, h.remove());
        assertEquals(8, h.remove());
        assertEquals(20, h.remove());
        assertEquals(50, h.remove());
    }
}