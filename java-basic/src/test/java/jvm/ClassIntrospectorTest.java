package jvm;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Date;

/**
 * @author xiayiguo
 * @since 2020-12-27
 */
public class ClassIntrospectorTest extends TestCase {
    @Test
    public void testIntrospect() throws IllegalAccessException {
        final ClassIntrospector ci = new ClassIntrospector();

        ObjectInfo res;

        res = ci.introspect(new ObjectA());
        ObjectInfo introspect = ci.introspect(new Date());
        System.out.println("new ObjectA() =>" + res.getDeepSize());
        System.out.println("new Date() =>" + introspect.getDeepSize());

    }

    private static class ObjectA {
//        String 默认是4个字节 32，
//        String str; // 4 指针是 4个字节
//        但是赋值空72
//        String str = ""; // 4
//        80
//        String str = "1"; // 4
//        动态增长的，对齐是8个字节
        String str = "1111111"; // 4 其实是char数组
//        char god;
        int i1 = 600; // 4
        byte b1 = 2; // 1
        byte b2; // 1
        int i2; // 4
        ObjectB obj = new ObjectB(); // 4 存的是指针， Oop指针，如果是32G内存以下的，默认开启对象指针压缩，4个字节
        byte b3; // 1
    }

    private static class ObjectB {

    }
}