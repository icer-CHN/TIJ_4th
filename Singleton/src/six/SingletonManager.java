package six;

import java.util.HashMap;
import java.util.Map;

/**
 * 容器单例管理器
 * Created by icer-SP4 on 2016/4/4.
 */
public class SingletonManager {
    private static Map<Object, Object> singletonMgr = new HashMap<>();

    private SingletonManager() {
    }

    public static void register(Object key, Object value) {
        if (!singletonMgr.containsKey(key)) {
            singletonMgr.put(key, value);
        }
    }

    public static Object get(Object key) {
        return singletonMgr.get(key);
    }
}
