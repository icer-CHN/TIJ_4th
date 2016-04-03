package three;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * DCL(Double Check Lock)单例模式
 * Created by icer-SP4 on 2016/4/4.
 */
public class Singleton implements Serializable {
    private volatile static Singleton sInstance;

    private Singleton() {
    }

    /**
     * DCL式单例，使用时再创建对象
     *
     * @return 单例
     */
    public static Singleton getInstance() {
        if (sInstance == null) {
            synchronized (Singleton.class) {
                if (sInstance == null) {
                    sInstance = new Singleton();
                }
            }
        }
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
