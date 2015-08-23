package assignment_10;

import util.Loger;

import java.util.ArrayList;
import java.util.List;

/**
 * 吸血鬼数: 位数为偶数;由两个数字相乘得到,且这两个数分别包含了乘积一半的数字;不可由两个0结尾;
 * 例: 2187=27*81
 * 计算四位数的所有吸血鬼数.
 * <p>
 * Created by icer on 2015/8/22.
 */
public class VampireNumber {

    public static void main(String[] args) {
        long time0 = System.currentTimeMillis();
        for (int i = 1001; i < 10000; i++) {
            if (isVampireNum(i))
                Loger.logLn(i + "");
        }
        long time1 = System.currentTimeMillis();
        Loger.logLn("\n" + (time1 - time0) + "ms");
    }

    /**
     * 判断一个四位数是不是吸血鬼数;
     * 算法思想略蠢;时间成本太高;
     */
    public static boolean isVampireNum(int num) {
        boolean res = false;
        if (num % 100 != 0) {
            List<Integer> list = new ArrayList<>();
            List<Integer> listOccupy = new ArrayList<>();
            list.add(num / 1000);
            list.add((num % 1000) / 100);
            list.add((num % 100) / 10);
            list.add(num % 10);
            for (int i = 10; i < 100; i++) {
                if (listOccupy.size() > 0) {
                    list.addAll(listOccupy);
                    listOccupy.clear();
                }
                int decade = i / 10;
                if (list.contains(decade)) {
                    listOccupy.add(list.remove(list.indexOf(decade)));
                    int unit = i % 10;
                    if (list.contains(unit)) {
                        listOccupy.add(list.remove(list.indexOf(unit)));
                        int x1 = listOccupy.get(0) * 10 + listOccupy.get(1);
                        int x2 = listOccupy.get(1) * 10 + listOccupy.get(0);
                        int y1 = list.get(0) * 10 + list.get(1);
                        int y2 = list.get(1) * 10 + list.get(0);
                        res = isStuff(x1, y1, num) || isStuff(x1, y2, num) || isStuff(x2, y1, num) || isStuff(x2, y2, num);
                        if (res)
                            break;
                    }
                }
            }
        }
        return res;
    }

    /**
     * @param num1    乘数1
     * @param num2    乘数2
     * @param product 目标乘积
     * @return num1 * num2 == product
     */
    public static boolean isStuff(int num1, int num2, int product) {
        boolean res = false;
        if (num1 * num2 == product) {
            Loger.log(num1 + "*" + num2 + "=");
            res = true;
        }
        return res;
    }
}
