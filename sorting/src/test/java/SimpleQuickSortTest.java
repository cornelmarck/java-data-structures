
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleQuickSortTest {

    @Test
    public void RandomInt() {
        List<Integer> items = new ArrayList<>(TestUtils.randomStream().limit((long) 1E6).toList());
        List<Integer> copy = new ArrayList<>(items);

        SimpleQuickSort.sort(items);
        SimpleQuickSort.sort(copy);

        Assertions.assertIterableEquals(copy, items);
    }

}
