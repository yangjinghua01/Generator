package genericityclass;

/**
 * 泛型类
 * 此处T可以随意写为任意标识，常见的如T,K,V,E等形式的参数常用于标识泛型
 * 在实例化泛型类时，必须指定T的类型
 * @param <T>
 */
public class Generic <T>{
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
