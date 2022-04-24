package sort;

import java.util.Iterator;
import java.util.List;

public class TestCaseUtils {

    public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        if (list.isEmpty()) {
            return true;
        }

        Iterator<T> iter = list.iterator();
        T prev = iter.next();
        while (iter.hasNext()) {
            T cur = iter.next();
            if (cur.compareTo(prev) < 0) {
                return false;
            }
            prev = cur;
        }

        return true;
    }
}
