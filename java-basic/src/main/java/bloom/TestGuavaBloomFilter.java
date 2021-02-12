package bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author xiayiguo
 * @since 2021-02-04
 */
public class TestGuavaBloomFilter {
    public static void main(String[] args) {
        BloomFilter<Integer> integerBloomFilter = BloomFilter.create(Funnels.integerFunnel(), 1000, 0.01);
        for (int i =0; i < 1000; i++) {
            integerBloomFilter.put(i);
        }
        int misCount = 0;
        for (int i = 1000; i < 2000; i++) {
            if (integerBloomFilter.mightContain(i)) {
                misCount++;
                System.out.println("误判了。。");
            }
        }
        System.out.println("误判数:" + misCount);

    }
}
