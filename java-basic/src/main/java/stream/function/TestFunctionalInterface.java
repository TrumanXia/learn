package stream.function;

/**
 * @author 97994
 * @since 2020-09-05
 */
public class TestFunctionalInterface {
    public static void main(String[] args) {
        // 传递行为
//        practice(System.out::println);
        practice((a) -> System.out.println(a + 2));
    }

    private static void practice(MyFunction function) {
        function.process(2);
    }
}
