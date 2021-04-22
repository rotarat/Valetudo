package bg.valetudo.mobile.model.enums.configuration;

import androidx.annotation.StringRes;

import bg.valetudo.mobile.R;

public enum ModulesEnum {
    FOOD_BEVERAGE(R.string.m_food_beverage),
    WORKOUT(R.string.m_workout),
    SLEEP(R.string.m_sleep);

    @StringRes
    int label;

    ModulesEnum(int label) {
        this.label = label;
    }

    public int getLabel() {
        return label;
    }
}
