package singleton;

/**
 * @author xiayiguo
 * @since 2021-01-05
 */
public class ThreadSafeDoubleCheckLazyForm {
    private ThreadSafeDoubleCheckLazyForm() {

    }

    private static ThreadSafeDoubleCheckLazyForm lazy;

    /** not thread safe */
    public static /*1. synchronized*/ ThreadSafeDoubleCheckLazyForm getInstance() {
        if (lazy == null) {
            // 对这个class类加锁，保证只有一个被加载的clas类
            synchronized (ThreadSafeDoubleCheckLazyForm.class) {
                if (lazy == null) {
                    lazy = new ThreadSafeDoubleCheckLazyForm();
                }
            }
        }
        return lazy;
    }
}
