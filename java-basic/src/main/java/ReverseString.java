/**
 * @author xiayiguo
 * @since 2021-02-21
 */
public class ReverseString {
    public static void main(String[] args) {
        String target = "abcd";

        int i = 0;
        int j = target.length() - 1;

        char[] chars = target.toCharArray();
//        使用双指针
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        System.out.println(String.valueOf(chars));
    }
}
