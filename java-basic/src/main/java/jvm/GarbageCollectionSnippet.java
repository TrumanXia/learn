package jvm;

/**
 * @author xiayiguo
 * @since 2021-01-06
 */
public class GarbageCollectionSnippet {
    public static void main(String[] args) {
        byte[] longExist = new byte[1];
        int i = 0;
        byte[] temp;
        while (i++ < 170) {
            temp = new byte[4 * 1024 * 1024];
            temp = null;
        }
    }
}
