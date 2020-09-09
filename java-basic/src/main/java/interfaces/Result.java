package interfaces;

import java.util.HashMap;

/**
 * @author 97994
 * @since 2020-09-06
 */
public class Result<T> extends HashMap<String, Object> {
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public static void main(String[] args) {
        Result<String> stringResult = new Result<>();
        stringResult.setData("hell");
        System.out.println(stringResult.getData());
    }
}
