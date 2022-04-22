import java.util.Random;
import java.util.stream.Stream;

public class TestUtils {

    public static Stream<Integer> randomStream() {
        Random rand = new Random(12341234);
        return rand.ints().boxed();
    }
}
