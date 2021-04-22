package bg.valetudo.mobile.model.observable.user;

import android.widget.ImageView;

import androidx.databinding.ObservableField;

public class UserObservable {
    private final ObservableField<String> username = new ObservableField<>();
    private final ObservableField<String> password = new ObservableField<>();
    private final ObservableField<String> confirmPassword = new ObservableField<>();
    private final ObservableField<String> email = new ObservableField<>();

    public ObservableField<String> getUsername() {
        return username;
    }

    public ObservableField<String> getPassword() {
        return password;
    }

    public ObservableField<String> getConfirmPassword() {
        return confirmPassword;
    }

    public ObservableField<String> getEmail() {
        return email;
    }
}
