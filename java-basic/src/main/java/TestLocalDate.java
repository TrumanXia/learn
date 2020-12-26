import com.sun.org.apache.bcel.internal.generic.NEW;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author 97994
 * @since 2020-10-18
 */
public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2019, 12, 17);
        LocalDate refundDate = localDate.plusDays(365);
        System.out.println(refundDate);

    }
}
