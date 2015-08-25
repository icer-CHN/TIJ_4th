package assignment_19;

import util.Loger;

/**
 * 可变参数列表
 * Created by icer on 2015/8/25.
 */
public class VarParam {
    public static void main(String[] args) {
        stuff(1, 2, 3);
        stuff();
        stuff('a', 'b', 'c');
        stuff("abc", "def", "opq");
        stuff(new Object(), new Object());
        stuff(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        stuff(new int[]{1, 2, 3});
        stuff(new Integer[]{1, 2, 3});
        stuff(1, 5.6, 'v', "image", new Object(), new String[]{"abc", "xyz"});

    }

    public static void stuff(Object... objs) {
        for (Object obj : objs) {
            Loger.logLn(obj.getClass().toString() + "  " + obj.toString());
        }
        Loger.logLn(objs.toString());
        Loger.logLn();
    }
}
