package sort;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.util.List;

class SimpleQuickSortTest {

    @ParameterizedTest()
    @MethodSource("sort.TestCaseReader#shuffledDistinctInt")
    void testShuffledInt(File file) {
        SortingAlgorithm<Integer> method = new SimpleQuickSort<>();
        List<Integer> list = TestCaseReader.readIntFile(file);
        method.sort(list);
    }

    @ParameterizedTest
    @MethodSource("sort.TestCaseReader#increasingDistinctInt")
    void testIncreasingInt(File file) {
        SortingAlgorithm<Integer> method = new SimpleQuickSort<>();
        List<Integer> list = TestCaseReader.readIntFile(file);
        method.sort(list);

    }

    @ParameterizedTest
    @MethodSource("sort.TestCaseReader#decreasingDistinctInt")
    void testDecreasingInt(File file) {
        SortingAlgorithm<Integer> method = new SimpleQuickSort<>();
        List<Integer> list = TestCaseReader.readIntFile(file);
        method.sort(list);
    }


}