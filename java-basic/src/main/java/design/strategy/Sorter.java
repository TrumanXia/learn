package design.strategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiayiguo
 * @since 2021-01-30
 */
public class Sorter {
    private static final int GB = 1_024 * 1_024 * 1_024;
    private static final List<AlgRange> RANGES = new ArrayList<>();

    static {
        RANGES.add(new AlgRange(0, 2, new Alg1()));
        RANGES.add(new AlgRange(2, 4, new Alg1()));
    }

    /**
     * 这里将范围的判断封装成了类中的一个方法，很好的实现了策略模式的写法
     * 
     * @param filePath
     */
    public void sortFile(String filePath) {
        File file = new File(filePath);
        long length = file.length();
        IAlg alg = null;
        for (AlgRange range : RANGES) {
            if (range.inRange(length)) {
                alg = range.getAlg();
                break;
            }
        }
        alg.toString();
    }

    private static class AlgRange {
        private long start;
        private long end;
        private IAlg alg;

        AlgRange(long start, long end, IAlg alg) {
            this.start = start;
            this.end = end;
            this.alg = alg;
        }

        public IAlg getAlg() {
            return alg;
        }

        public boolean inRange(long size) {
            // 不能全闭，不然逻辑有问题
            if (start <= size && size <= end) {
                return true;
            }
            return false;
        }
    }
}
