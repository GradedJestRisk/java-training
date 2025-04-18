package basics.test.Mockito;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StaticUtils {

    private StaticUtils() {}

    public static String name() {
        return "Baeldung";
    }


    public static List<Integer> range(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .collect(Collectors.toList());
    }
}