package lambda;

import rx.Single;
import rx.schedulers.Schedulers;

import java.util.Locale;

/**
 * @author xiayiguo
 * @since 2021-02-12
 */
public class RxJavaDemo {
    public static void main(String[] args) throws InterruptedException {
        Single.just(new NewsLetter().init()).subscribeOn(Schedulers.io()).subscribe(RxJavaDemo::println);
        Thread.sleep(100);
    }

    public static class NewsLetter {
        public String init() {
            return "new letter";
        }
    }

    public static void println(String content) {
        System.out.println(String.format(Locale.ROOT, "%s : %s", Thread.currentThread().getName(), content));
    }
}
