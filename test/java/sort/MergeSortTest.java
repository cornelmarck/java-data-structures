package sort;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.util.List;

class MergeSortTest {

    @ParameterizedTest
    @MethodSource("sort.TestCaseReader#shuffledDistinctInt")
    void testShuffledInt(File file) {
        SortingAlgorithm<Integer> method = new MergeSort<>();
        List<Integer> list = TestCaseReader.readIntFile(file);
        method.sort(list);

        Assertions.assertTrue(TestCaseUtils.isSorted(list));
    }

    @ParameterizedTest
    @MethodSource("sort.TestCaseReader#increasingDistinctInt")
    void testIncreasingInt(File file) {
        SortingAlgorithm<Integer> method = new MergeSort<>();
        List<Integer> list = TestCaseReader.readIntFile(file);
        method.sort(list);

        Assertions.assertTrue(TestCaseUtils.isSorted(list));

    }

    @ParameterizedTest
    @MethodSource("sort.TestCaseReader#decreasingDistinctInt")
    void testDecreasingInt(File file) {
        SortingAlgorithm<Integer> method = new MergeSort<>();
        List<Integer> list = TestCaseReader.readIntFile(file);
        method.sort(list);

        Assertions.assertTrue(TestCaseUtils.isSorted(list));
    }







}