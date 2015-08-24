package assignment_22;

import assignment_21.RenMinBi;
import util.Loger;

/**
 * 对21题增加switch分支判断,输出每种纸币的描述.
 * <p>
 * Created by icer on 2015-08-24.
 */
public class NoteEnumSwitch {
    public static void main(String[] args) {
        for (RenMinBi rmb : RenMinBi.values()) {
            switch (rmb) {
                case YI_JIAO://由于分支为枚举,所以不能为(YI_JIAO),也不能为RenMinBi.YI_JIAO
                    Loger.logLn(rmb.name());
                    break;

                case WU_JIAO:
                    Loger.logLn(rmb.name());
                    break;

                case YI_YUAN:
                    Loger.logLn(rmb.name());
                    break;

                case WU_YUAN:
                    Loger.logLn(rmb.name());
                    break;

                case SHI_YUAN:
                    Loger.logLn(rmb.name());
                    break;

                case ER_SHI_YUAN:
                    Loger.logLn(rmb.name());
                    break;

                case WU_SHI_YUAN:
                    Loger.logLn(rmb.name());
                    break;

                case YI_BAI_YUAN:
                    Loger.logLn(rmb.name());
                    break;
            }
        }
    }
}
