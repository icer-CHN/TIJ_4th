package assignment_21;

/**
 * 人民币枚举
 * Created by icer on 2015-08-24.
 */
public enum RenMinBi {
    YI_JIAO(0.1f), WU_JIAO(0.5f), YI_YUAN(1), WU_YUAN(5), SHI_YUAN(10), ER_SHI_YUAN(20), WU_SHI_YUAN(50), YI_BAI_YUAN(100);

    private float value;

    RenMinBi(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

}
