package continue_break_label;

import util.Loger;

/**
 * Created by icer on 2015-10-14.
 */
public class LabeledContinueBreak {
    public static void main(String[] args) {
        outer:
        for (int i = 0; true; ) {

            inner:
            for (; i < 10; i++) {
                Loger.logLn("i = " + i);

                if (i == 2) {
                    Loger.logLn("continue");
                    continue;
                }

                if (i == 3) {
                    Loger.logLn("break");
                    i++;
                    break;
                }

                if (i == 5) {
                    Loger.logLn("continue outer");
                    i++;
                    continue outer;
                }

                if (i == 7) {
                    Loger.logLn("continue outer");
                    i++;
                    continue outer;
                }

                if (i == 8) {
                    Loger.logLn("break outer");
                    break outer;
                }

                for (int j = 0; j < 5; j++) {
                    if (j == 3) {
                        Loger.logLn("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
}
