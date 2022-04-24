package sort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCaseGenerator {
    final File root;

    public TestCaseGenerator() throws IOException {
        URL rootPath = TestCaseGenerator.class.getResource(".");
        if (rootPath == null) {
            throw new IOException("Root folder not found");
        }
        root = new File(rootPath.getFile(), "input");
        root.mkdir();
    }

    void increasingDistinctInt(List<Integer> n) {
        File folder = new File(root, "increasingDistinctInt");
        folder.mkdir();

        for (int i : n) {
            File out = new File(folder, zeroPadNumber(i));
            writeToFile(out, integerList(i));
        }
    }

    void decreasingDistinctInt(List<Integer> n) {
        File folder = new File(root, "decreasingDistinctInt");
        folder.mkdir();

        for (int i : n) {
            File out = new File(folder, zeroPadNumber(i));
            List<Integer> list = integerList(i);
            Collections.reverse(list);
            writeToFile(out, list);
        }
    }

    void shuffledDistinctInt(List<Integer> n) {
        File folder = new File(root, "shuffledDistinctInt");
        folder.mkdir();

        for (int i : n) {
            File out = new File(folder, zeroPadNumber(i));
            List<Integer> list = integerList(i);
            Collections.shuffle(list);
            writeToFile(out, list);
        }
    }

    static <T> void writeToFile(File output, List<T> items) {
        if (output.exists()) {
            output.delete();
        }

        try (FileWriter fileWriter = new FileWriter(output)) {
            for (T i : items) {
                fileWriter.write(i.toString() + System.lineSeparator());
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    List<Integer> integerList(int n) {
        int size = (int) Math.pow(2, n);
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            out.add(i);
        }
        return out;
    }

    List<Integer> repeatedIntegerList(int n, int repetitions) {
        List<Integer> out = new ArrayList<>();
        int size = (int) Math.pow(2, n);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < repetitions; j++) {
                out.add(i);
            }
        }
        return out;
    }

    static String zeroPadNumber(int i) {
        return String.format("%02d", i);
    }

    public static void main(String[] args) {
        try {
            TestCaseGenerator gen = new TestCaseGenerator();
            gen.increasingDistinctInt(List.of(2, 4, 8, 12, 16, 20, 22, 24, 25, 26));
            gen.decreasingDistinctInt(List.of(2, 4, 8, 12, 16, 20, 22, 24, 25, 26));
            gen.shuffledDistinctInt(List.of(2, 4, 8, 12, 16, 20, 22, 24, 25, 26));
        }
        catch (Exception e) {
            System.out.println(e) ;
        }
    }
}



