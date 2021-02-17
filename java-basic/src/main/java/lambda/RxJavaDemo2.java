package lambda;

import rx.Observable;

import java.util.Arrays;

/**
 * @author xiayiguo
 * @since 2021-02-12
 */
public class RxJavaDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Observable.from(Arrays.asList(1, 2, 3, 4)).subscribe(next -> {if (next > 2) {
            System.out.println(next);
        }}, error -> {
            System.out.println("sss");
        }, () -> {
            System.out.println("end");
        });
    }

}
