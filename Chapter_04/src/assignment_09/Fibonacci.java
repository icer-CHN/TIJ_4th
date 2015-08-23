package assignment_09;

import util.Loger;

import java.util.ArrayList;
import java.util.List;

/**
 * 斐波那契数列
 * <p>
 * 由于没有做大数处理,最多到第92个数,再往后就long正溢出了;
 * <p>
 * Created by icer on 2015/8/23.
 */
public class Fibonacci {
    private static final List<Long> M_FIBONACCI_LIST = new ArrayList<>();

    static {
        M_FIBONACCI_LIST.add(1L);
        M_FIBONACCI_LIST.add(1L);
    }

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        final int NUM = 92;
        for (int i = 1; i <= NUM; i++) {
            Loger.log(getFibonacci(i) + "");
            if (i < NUM) {
                Loger.log(", ");
            } else if (i == NUM) {
                Loger.logLn("");
                break;
            }
            if (i % 5 == 0)
                Loger.logLn("");
        }
        long t1 = System.currentTimeMillis();
        Loger.logLn("\nLong.MAX_VALUE: " + Long.MAX_VALUE);
        Loger.logLn("\nTime cost: " + (t1 - t0) + "ms");
    }

    public static long getFibonacci(int index) {
        long res;
        for (; ; ) {
            int size = M_FIBONACCI_LIST.size();
            if (size < index) {
                M_FIBONACCI_LIST.add(M_FIBONACCI_LIST.get(size - 1) + M_FIBONACCI_LIST.get(size - 2));
            } else {
                res = M_FIBONACCI_LIST.get(index - 1);
                break;
            }
        }
        return res;
    }
}
