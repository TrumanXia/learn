package bytes;

/**
 * @author 97994
 * @since 2020-11-01
 */
public class TestBitsToByte {
    public static void main(String[] args) {
        int a = 17;
        String s = Integer.toBinaryString(a);
        System.out.println(s);

        System.out.println(Integer.toHexString(a));
    }
}
