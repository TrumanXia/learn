package singleton;

/**
 * @author xiayiguo
 * @since 2021-01-05
 */
public class InnerclassForm {
    private InnerclassForm() {

    }

    /**
     * 因为 Inner 类没有被主动使用，只有显示通过调用getInstance方法时， 才会显示装载Inner 类，从而实例化instance。
     */
    private static class Inner {
        private static final InnerclassForm INSTANCE = new InnerclassForm();
    }

    /** not thread safe */
    public static InnerclassForm getInstance() {
        return Inner.INSTANCE;
    }
}
