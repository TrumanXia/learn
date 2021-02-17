/**
 * @author xiayiguo
 * @since 2021-02-17
 */
public class TestString {
    public static void main(String[] args) {
        String str1 = "abc" + "d";
        String str2 = "ab" + "cd";
        String abcd = "abcd";
        String str2Intern = str2.intern();
//        System.out.println(str1.equals(str2));
//        System.out.println(str2.equals(str2Intern));
//        System.out.println(abcd.equals(str2Intern));
        System.out.println(str1 == str2);
        System.out.println(str2 == str2Intern);
        System.out.println(abcd == str2Intern);
    }
}
