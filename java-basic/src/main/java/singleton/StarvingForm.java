package singleton;

/**
 * @author xiayiguo
 * @since 2021-01-05
 *
 * thread safe
 */
public class StarvingForm {
    private StarvingForm() {

    }

    private static final StarvingForm starving = new StarvingForm();

    public static StarvingForm getInstance() {
        return starving;
    }
}
