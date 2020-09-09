package stream;

import stream.wrapper.StreamUtil;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 97994
 * @since 2020-09-04
 */
public class CaptureExceptionInStreamV2 {
    // 不要在lambda中直接捕获异常，这样可读性会变差
    // 第二种方式可读性好点，但是一旦发生异常，stream流处理会立刻停止
    public void good(String[] args) {
        Stream.of(1).map(StreamUtil.wrap(t -> trySomething(t))).collect(Collectors.toList());
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
