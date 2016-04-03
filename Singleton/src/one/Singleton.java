package one;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 饿汉式单例模式
 * 缺点:不论使用与否,单例都会创建,有时浪费资源;
 * Created by icer-SP4 on 2016/4/4.
 */
public class Singleton implements Serializable {
    private static final Singleton sInstance = new Singleton();//声明的同时赋值，饿汉式单例

    private Singleton() {
    }

    public static Singleton getInstance() {
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
