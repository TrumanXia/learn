package lambda;

import rx.Single;

import java.util.Locale;

/**
 * @author xiayiguo
 * @since 2021-02-12
 */
public class RxJavaDemo {
    public static void main(String[] args) {
        Single.just(new NewsLetter().init()).subscribe(RxJavaDemo::println);
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
