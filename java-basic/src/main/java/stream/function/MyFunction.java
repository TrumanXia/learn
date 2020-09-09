package stream.function;

import jdk.nashorn.internal.objects.annotations.Function;

/**
 * @author 97994
 * @since 2020-09-05
 */
@FunctionalInterface
public interface MyFunction {
    void process(int a);
}
