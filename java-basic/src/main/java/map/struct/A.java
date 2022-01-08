package map.struct;

/**
 * @author xiayiguo
 * @since 2021-05-16
 */

import lombok.Data;
import java.util.List;

@Data
public class A {
    private String name;

    private List<Integer> ids;
}