import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortTest {

    @Test
    public void RandomInt() {
        List<Integer> items = new ArrayList<>(TestUtils.randomStream().limit((long) 1E6).toList());
        List<Integer> copy = new ArrayList<>(items);

        InsertionSort.sort(items);
        InsertionSort.sort(copy);

        Assertions.assertIterableEquals(copy, items);
    }

}
