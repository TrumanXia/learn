package stream.wrapper;

import stream.either.Either;
import stream.either.Pair;

import java.util.function.Function;

/**
 * @author 97994
 * @since 2020-09-04
 */
public class StreamUtil {
    // 返回值为lambda的入参和出参顺序也要一致， 可以直接改 CheckedFunction 的泛型参数的顺序， 这里只是掩饰验收，这个方法没有实际意义
    // public static <T, R> Function<T, R> wrap(CheckedFunction<T, R> checkedFunction) {
    // return (T t) -> {
    // try {
    // return (R)checkedFunction.apply((R)t);
    // } catch (Exception e) {
    // throw new RuntimeException(e);
    // }
    // };
    // }

    public static <T, R> Function<T, R> wrap(CheckedFunction2<T, R> checkedFunction) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <T, R> Function<T, Either> lift(CheckedFunction2<T, R> function) {
        return t -> {
            try {
                return Either.Right(function.apply(t));
            } catch (Exception ex) {
                return Either.Left(ex);
            }
        };
    }

    public static <T, R> Function<T, Either> liftWithValue(CheckedFunction2<T, R> function) {
        return t -> {
            try {
                return Either.Right(function.apply(t));
            } catch (Exception ex) {
                return Either.Left(Pair.of(ex, t));
            }
        };
    }
}
