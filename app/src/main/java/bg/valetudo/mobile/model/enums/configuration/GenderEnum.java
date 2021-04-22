package bg.valetudo.mobile.model.enums.configuration;

import androidx.annotation.StringRes;

import bg.valetudo.mobile.R;
import bg.valetudo.mobile.ValetudoApp;

public enum GenderEnum {
    MALE(R.string.male),
    FEMALE(R.string.female),
    OTHER(R.string.other);

    @StringRes int label;

    GenderEnum(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return ValetudoApp.getInstance().getApplicationContext().getString(label);
    }
}
