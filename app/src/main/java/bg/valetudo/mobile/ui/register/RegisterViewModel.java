package bg.valetudo.mobile.ui.register;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

import bg.valetudo.mobile.UserPreferences;
import bg.valetudo.mobile.model.api.user.UserDTO;
import bg.valetudo.mobile.model.api.user.UserDataDTO;
import bg.valetudo.mobile.model.constants.EndPoint;
import bg.valetudo.mobile.model.observable.user.UserObservable;
import bg.valetudo.mobile.ui.MainActivity;
import bg.valetudo.mobile.ui.base.BaseViewModel;
import bg.valetudo.mobile.util.AuthorizedRequest;

import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class RegisterViewModel extends BaseViewModel<RegisterFragment> {
    private final UserObservable userObservable = new UserObservable();

    public UserObservable getUserObservable() {
        return userObservable;
    }

    public void onSignUpClick() {
        UserDTO user = new UserDTO();

        user.setEmail(userObservable.getEmail().get());
        user.setUsername(userObservable.getUsername().get());

        if (Objects.equals(userObservable.getPassword().get(), userObservable.getConfirmPassword().get())) {
            user.setPassword(userObservable.getPassword().get());

            RequestQueue queue = Volley.newRequestQueue(mFragment.requireContext());
            AuthorizedRequest aRequest = null;
            try {
                aRequest = new AuthorizedRequest(Request.Method.POST, EndPoint.REGISTER, new JSONObject(new Gson().toJson(user)),
                        response -> {
                            mFragment.showLoginFragment();
                        }, error -> Log.e("RegisterViewModel", error.getMessage()));
            } catch (JSONException e) {
                Log.e("RegisterViewModel", e.getMessage());
            }

            queue.add(aRequest);
        } else {
            alertPasswordNotValid();
        }
    }

    public void onLogInClick () {
        mFragment.showLoginFragment();
    }

    public void alertPasswordNotValid () {
        AlertDialog.Builder builder = new AlertDialog.Builder(mFragment.getContext());
        builder.setMessage("The password you entered doesn't match!");
        builder.setCancelable(true);
        builder.setPositiveButton(
                "I can't type",
                (dialog, id) -> dialog.cancel());

        AlertDialog alert = builder.create();
        alert.show();
    }
}
