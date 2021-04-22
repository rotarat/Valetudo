package bg.valetudo.mobile;

import bg.valetudo.mobile.model.api.user.UserDataDTO;
import bg.valetudo.mobile.model.observable.user.UserDataObservable;

public class UserPreferences {
    private static UserPreferences instance;

    private String token;
    private UserDataDTO userData;

    private UserDataObservable userDataObservable;

    private UserPreferences() {}

    public static UserPreferences getInstance() {
        if(instance == null)
            instance = new UserPreferences();

        return instance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDataDTO getUserData() {
        return userData;
    }

    public void setUserData(UserDataDTO userData) {
        this.userData = userData;
    }

    public UserDataObservable getUserDataObservable() {
        return userDataObservable;
    }

    public void setUserDataObservable(UserDataObservable userDataObservable) {
        this.userDataObservable = userDataObservable;
    }
}
