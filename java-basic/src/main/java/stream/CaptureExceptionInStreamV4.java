package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import stream.either.Either;
import stream.wrapper.StreamUtil;

/**
 * @author 97994
 * @since 2020-09-04
 */
public class CaptureExceptionInStreamV4 {
    // 不要在lambda中直接捕获异常，这样可读性会变差
    // 第二种方式可读性好点，但是一旦发生异常，stream流处理会立刻停止
    // 第三种方式可以在流发生异常时，不丢失异常信息
    // 第四种方式可以保持异常信息与发生异常时的值
    public void good(String[] args) {
        List<Integer> collect = Stream.of(1).map(StreamUtil.wrap(this::doSth)).collect(Collectors.toList());
        List<Either> collect1 = Stream.of(1).map(StreamUtil.lift(this::doSth)).collect(Collectors.toList());
        List<Either> collect2 = Stream.of(1).map(StreamUtil.liftWithValue(this::doSth)).collect(Collectors.toList());
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
