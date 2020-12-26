import java.util.Random;

/**
 * @author 97994
 * @since 2020-10-18
 */
public class RandomCodeHelper {
    private final static char[] codePool = new char[62];
    static {
//        48 - 57; 65 - 90; 97 - 122
        int codePoolIndex = 0;
        for (int i = 48; i <= 57; i++) {
            codePool[codePoolIndex++] = (char)i;
        }
        for (int i = 65; i <= 90; i++) {
            codePool[codePoolIndex++] = (char)i;
        }
        for (int i = 97; i <= 122; i++) {
            codePool[codePoolIndex++] = (char)i;
        }
    }

    public static String generateCode() {
        char[] randomCodeChars = new char[8];
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            randomCodeChars[i] = codePool[random.nextInt(62)];
        }
        return new String(randomCodeChars);
    }
}
