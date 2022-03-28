import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HeapsortTest {

    public static List<Integer> intToList(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i : arr) {
            result.add(i);
        }
        return result;
    }

    @Test
    void sort() {
        int[] arr = new int[]{2, 5, 3, 2, 1, 9, 4, 10, 40, 30, 21};
        List<Integer> one = intToList(arr);
        List<Integer> two = intToList(arr);

        Collections.sort(one);
        Heapsort.sort(two);
        assertEquals(one ,two);
    }

    @Test
    void sortInverse() {
        int[] arr = new int[]{2, 5, 3, 2, 1, 9, 4, 10, 40, 30, 21};
        List<Integer> one = intToList(arr);
        List<Integer> two = intToList(arr);

        Collections.sort(one);
        Collections.reverse(one);
        Heapsort.sortInverse(two);
        assertEquals(one ,two);
    }
}