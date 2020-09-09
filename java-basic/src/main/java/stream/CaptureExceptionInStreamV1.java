package stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 97994
 * @since 2020-09-04
 */
public class CaptureExceptionInStreamV1 {
    // 不要在lambda中直接捕获异常，这样可读性会变差
    public void good(String[] args) {
        Stream.of(1).map(this::trySomething).collect(Collectors.toList());
    }

    private int trySomething(Integer t) {
        try {
            return doSth(t);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    private int doSth(Integer t) throws Exception {
        throw new Exception();
    }

}
