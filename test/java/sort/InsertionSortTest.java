package sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.List;

class InsertionSortTest {

    @ParameterizedTest()
    @MethodSource("sort.TestCaseReader#shuffledDistinctInt")
    void testShuffledInt(File file) {
        SortingAlgorithm<Integer> insertionSort = new InsertionSort<>();
        List<Integer> list = TestCaseReader.readIntFile(file);
        insertionSort.sort(list);
    }

    @ParameterizedTest
    @MethodSource("sort.TestCaseReader#increasingDistinctInt")
    void testIncreasingInt(File file) {
        SortingAlgorithm<Integer> insertionSort = new InsertionSort<>();
        List<Integer> list = TestCaseReader.readIntFile(file);
        insertionSort.sort(list);

    }

    @ParameterizedTest
    @MethodSource("sort.TestCaseReader#decreasingDistinctInt")
    void testDecreasingInt(File file) {
        SortingAlgorithm<Integer> insertionSort = new InsertionSort<>();
        List<Integer> list = TestCaseReader.readIntFile(file);
        insertionSort.sort(list);
    }


}