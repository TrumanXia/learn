package hash;

import sun.security.provider.MD5;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * @author 97994
 * @since 2020-09-07
 */
public class TestHash {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(Objects.hashCode("ssssss"));
        System.out.println(Objects.hashCode("sssssss"));
        byte[] md5s = MessageDigest.getInstance("MD5").digest("hello".getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(md5s, StandardCharsets.UTF_8));
    }
}
