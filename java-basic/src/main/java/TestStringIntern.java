/**
 * @author xiayiguo
 * @since 2021-01-29
 */
public class TestStringIntern {
    public static void main(String[] args) {
        /*String test1 = "abc";
        String test2 = new String("abc");
        System.out.println(test1 == test2);
        String str = test2.intern();
        System.out.println(test1 == test2);
        System.out.println(test1 == str);*/
        String test1 = "abc";
        String test2 = "abc";
        System.out.println(test1 == test2);
        String str = test2.intern();
        System.out.println(test1 == test2);
        System.out.println(test1 == str);
    }
}
