package jvm;

import org.openjdk.jol.info.GraphLayout;

/**
 * @author xiayiguo
 * @since 2021-02-03
 */
public class ObjectsSize {
    public static void main(String[] args) {
        int[] a = {1 };
        GraphLayout graphLayout = GraphLayout.parseInstance(a);
        System.out.println(graphLayout.totalSize());
    }
}
