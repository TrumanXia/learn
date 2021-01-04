package singleton;

/**
 * @author xiayiguo
 * @since 2021-01-05
 */
public class StarvingForm {
    private StarvingForm() {

    }

    private static StarvingForm starving = new StarvingForm();

    public static StarvingForm getInstance() {
        return starving;
    }
}
