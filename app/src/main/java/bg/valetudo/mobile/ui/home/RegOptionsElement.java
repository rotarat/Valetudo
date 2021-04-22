package bg.valetudo.mobile.ui.home;

import android.widget.CheckBox;

public class RegOptionsElement {
    private String text;
    private CheckBox checkbox;

    public RegOptionsElement(String text) {
        this.text = text;
    }

    public String getElementText () {
        return text;
    }

    public CheckBox getCheckbox () {
        return checkbox;
    }
}
