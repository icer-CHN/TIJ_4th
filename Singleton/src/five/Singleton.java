package five;

/**
 * 枚举式单例模式
 * Created by icer-SP4 on 2016/4/4.
 */
public enum Singleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("doSomething()");
    }
}
