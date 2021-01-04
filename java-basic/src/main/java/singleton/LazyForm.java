package singleton;

/**
 * @author xiayiguo
 * @since 2021-01-05
 */
public class LazyForm {
    private LazyForm() {

    }

    private static LazyForm lazy;

    /** not thread safe*/
    public static LazyForm getInstance() {
        if (lazy == null) {
            lazy = new LazyForm();
        }
        return lazy;
    }
}
