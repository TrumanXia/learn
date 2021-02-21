/**
 * @author xiayiguo
 * @since 2021-02-21
 *
 * output:
 *
 * Good{id=3, name='aa'}
 * Good{id=3, name='aa'}
 */
public class TestPassByValue {
    public static void main(String[] args) {
        Good aa = new Good(3, "aa");
        System.out.println(aa);
        new TestPassByValue().hello(aa);
        System.out.println(aa);
    }

    public void hello(Good in) {
        in = new Good(1, "as");
    }
}


class Good{
    private int id;
    private String name;

    public Good(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Good{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}