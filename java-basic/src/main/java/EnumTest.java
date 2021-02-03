import interfaces.ITask;

import java.io.Serializable;

/**
 * @author xiayiguo
 * @since 2021-01-29
 */
public enum EnumTest implements Serializable {
    SINGLETON;

    private Object readResolve() {
        return SINGLETON;
    }

}
