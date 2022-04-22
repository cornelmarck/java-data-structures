import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeSortTest {

    @Test
    public void RandomInt() {
        List<Integer> items = new ArrayList<>(TestUtils.randomStream().limit((long) 1E6).toList());
        List<Integer> copy = new ArrayList<>(items);

        MergeSort.sort(items);
        MergeSort.sort(copy);

        Assertions.assertIterableEquals(copy, items);
    }

}
