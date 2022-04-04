package sort;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestCaseReader {
    static final File root = new File(TestCaseGenerator.class.getResource(".").getFile());
    static final File input = new File(root, "input");

    public TestCaseReader() {}

    public static Iterable<File> increasingDistinctInt() {
        File folder = new File(input, "increasingDistinctInt");
        return getFiles(folder);
    }

    public static Iterable<File> decreasingDistinctInt() {
        File folder = new File(input, "decreasingDistinctInt");
        return getFiles(folder);
    }

    public static Iterable<File> shuffledDistinctInt() {
        File folder = new File(input, "shuffledDistinctInt");
        return getFiles(folder);
    }

    public static List<Integer> readIntFile(File file) {
        List<Integer> out = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                out.add(scanner.nextInt());
            }
        }
        catch (FileNotFoundException ignored) {}

        return out;
    }

    static String getTestName(File file) {
        return file.getParentFile().getName() + "/" + file.getName();
    }

    static List<File> getFiles(File parentFolder) {
        List<File> files = Arrays.asList(parentFolder.listFiles());
        Collections.sort(files);
        return files;
    }
}

