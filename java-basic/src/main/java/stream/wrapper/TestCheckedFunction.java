package stream.wrapper;

import java.util.function.Function;

/**
 * @author 97994
 * @since 2020-09-04
 */
public class TestCheckedFunction {
    public static void main(String[] args) {
        Function runnable = (t) -> {
            return 1;
        };

        CheckedFunction<Integer, String> s = ((s1) -> 1);
    }
}
