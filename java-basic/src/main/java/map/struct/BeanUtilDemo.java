package map.struct;

/**
 * @author xiayiguo
 * @since 2021-05-16
 */

import java.util.Arrays;

public class BeanUtilDemo {
    public static void main(String[] args) {
        A first = new A();
        first.setName("demo");
        first.setIds(Arrays.asList(1, 2, 3));

        B second = Converter.INSTANCE.aToB(first);
        for (String each : second.getIds()) {// 正常
            System.out.println(each);
        }
    }
}
