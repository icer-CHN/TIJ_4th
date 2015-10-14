package assignment_12;

import util.Loger;

/**
 * finalize()中加入终结条件判断;
 * 并且保证finalize()确实执行;
 *
 * Tank: n.水槽
 * Created by icer on 2015-10-14.
 */
public class Tank {

    public static final int STATE_EMPTY = 0;
    public static final int STATE_FULL = 1;
    public static int instanceNum = 0;
    public static boolean error = false;

    private int mState;

    public Tank() {
        mState = STATE_FULL;
        instanceNum++;
    }

    public Tank pour() {
        if (mState == STATE_FULL) {
            mState = STATE_EMPTY;
        } else {
            Loger.logLn("This tank is EMPTY");
        }
        return this;
    }

    @Override
    protected void finalize() throws Throwable {

        if (mState == STATE_FULL) {
            error = true;
            Loger.logLn("Error: Tank is FULL");
        } else {
            super.finalize();
            Loger.logLn("finalized, rest: " + (--instanceNum));
        }
    }

    public static void main(String[] args) {
        new Tank().pour();
        new Tank().pour();
        new Tank();
        for (long i = 1; instanceNum > 0 && !error; i++) {
            Loger.logLn("count: " + i);
            System.gc();
        }
    }
}
