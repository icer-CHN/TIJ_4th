package four;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 内部Holder式单例模式
 * Created by icer-SP4 on 2016/4/4.
 */
public class Singleton implements Serializable {
    private Singleton() {
    }

    /**
     * 调用时才会创建单例实例
     *
     * @return 单例
     */
    public static Singleton getInstance() {
        return SingletonHolder.sInstance;
    }

    /**
     * 防止反序列化时得到原来保存的对象，得到统一单例
     *
     * @return 单例
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return SingletonHolder.sInstance;
    }

    public void doSomething() {
        System.out.println("doSomething()");
    }

    private static class SingletonHolder {
        private static final Singleton sInstance = new Singleton();
    }
}
