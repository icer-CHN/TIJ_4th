package two;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 懒汉式单例模式
 * Created by icer-SP4 on 2016/4/4.
 */
public class Singleton implements Serializable {
    private static Singleton sInstance;

    private Singleton() {
    }

    /**
     * 懒汉式单例，使用时再创建对象
     * 缺点：每次调用都有同步开销
     *
     * @return 单例
     */
    public static synchronized Singleton getInstance() {
        if (sInstance == null)
            sInstance = new Singleton();
        return sInstance;
    }

    /**
     * 防止反序列化时得到原来保存的对象，得到统一单例
     *
     * @return 单例
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return sInstance;
    }

    public void doSomething() {
        System.out.println("doSomething()");
    }
}
