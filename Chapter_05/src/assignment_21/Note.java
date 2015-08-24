package assignment_21;

import util.Loger;

/**
 * 纸币枚举
 * Created by icer on 2015-08-24.
 */
public class Note {
    public static void main(String[] args) {
        for (RenMinBi rmb : RenMinBi.values()) {
            Loger.logLn(rmb.ordinal() + ": " + rmb.name() + ": " + rmb.getValue());
        }
    }
}

