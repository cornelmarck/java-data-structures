import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTest {
    @Test
    void constructEmtpy() {
        PriorityQueue<Integer> h = new Heap<>(HeapType.MAX);
        assertEquals(0, h.size());
    }

    @Test
    void buildHeap() {
        List<Integer> l = new ArrayList<>();
        l.add(20);
        l.add(50);
        l.add(8);
        l.add(-3);

        Heap<Integer> h = new Heap<>(HeapType.MAX, l);
        assertEquals(50, h.get(0));
    }

    @Test
    void insert() {
        Heap<Integer> h = new Heap<>(HeapType.MAX);
        h.insert(20);
        h.insert(50);
        h.insert(-3);
        h.insert(8);

        assertEquals(50, h.get(0));
    }

    @Test
    void remove() {
        PriorityQueue<Integer> h = new Heap<>(HeapType.MAX);
        h.insert(20);
        h.insert(50);
        h.insert(-3);
        h.insert(8);

        assertEquals(50, h.remove());
        assertEquals(20, h.remove());
        assertEquals(8, h.remove());
        assertEquals(-3, h.remove());
    }
}