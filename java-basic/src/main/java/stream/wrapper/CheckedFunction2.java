package stream.wrapper;

/**
 * @author 97994
 * @since 2020-09-04
 */
@FunctionalInterface
// 为啥改成颠倒下 R T 的顺序，StreamUtil中会报错
public interface CheckedFunction2<T, R> {
    R apply(T t) throws Exception;
}
