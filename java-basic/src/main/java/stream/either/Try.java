package stream.either;

/**
 * @author 97994
 * @since 2020-09-06
 */
// 其实和Either差不多， 没有保持异常信息
public class Try<Exception, R> {
    private final Exception failure;
    private final R succes;

    public Try(Exception failure, R succes) {
        this.failure = failure;
        this.succes = succes;
    }
}