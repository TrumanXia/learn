import java.util.Vector;

/**
 * @author xiayiguo
 * @since 2021-02-21
 */
public class TestThreadSafeContainer {
    public static void main(String[] args) {
        Vector<Integer> strings = new Vector<>(8);

        for (int i = 0 ; i < 10; i++) {
            strings.add(i);
        }

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                strings.remove(i);
            }
        }, "h").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                strings.get(i);
            }
        }, "ss").start();
    }
}
