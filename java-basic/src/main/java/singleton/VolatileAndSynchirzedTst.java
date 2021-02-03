package singleton;

import java.util.concurrent.*;

/**
 * @author xiayiguo
 * @since 2021-01-06
 */
public class VolatileAndSynchirzedTst {
    private /*volatile*/ int i = 0;

    private synchronized void act() {
        i++;
    }

    private void printI() {
        System.out.println("i: " + i);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileAndSynchirzedTst volatileAndSynchirzedTst = new VolatileAndSynchirzedTst();
        ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(10, 10, 1_000, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        int taskNum = 10;
        CountDownLatch countDownLatch = new CountDownLatch(taskNum);
        for (int j = 0; j < taskNum; j++) {
            threadPoolExecutor.execute(() -> {
                for (int m = 0; m < 1000; m++) {
                    volatileAndSynchirzedTst.act();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        volatileAndSynchirzedTst.printI();
        threadPoolExecutor.shutdown();
    }
}
