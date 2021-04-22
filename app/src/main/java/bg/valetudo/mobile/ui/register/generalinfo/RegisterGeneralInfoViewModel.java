package bg.valetudo.mobile.ui.register.generalinfo;

import bg.valetudo.mobile.UserPreferences;
import bg.valetudo.mobile.model.observable.user.UserDataObservable;
import bg.valetudo.mobile.model.observable.user.UserObservable;
import bg.valetudo.mobile.ui.base.BaseViewModel;

public class RegisterGeneralInfoViewModel extends BaseViewModel<RegisterGeneralInfoFragment> {
    private final UserDataObservable userDataObservable = new UserDataObservable();

    public void onNextClick () {
        UserPreferences.getInstance().setUserDataObservable(userDataObservable);
        mFragment.showMeasurementFragment();
    }

    public UserDataObservable getUserDataObservable() {
        return userDataObservable;
    }
}
