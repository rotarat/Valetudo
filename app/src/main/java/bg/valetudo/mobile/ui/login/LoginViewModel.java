package bg.valetudo.mobile.ui.login;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import bg.valetudo.mobile.UserPreferences;
import bg.valetudo.mobile.model.api.user.UserDTO;
import bg.valetudo.mobile.model.api.user.UserDataDTO;
import bg.valetudo.mobile.model.constants.EndPoint;
import bg.valetudo.mobile.model.observable.user.UserObservable;
import bg.valetudo.mobile.ui.base.BaseViewModel;
import bg.valetudo.mobile.util.AuthorizedRequest;
import bg.valetudo.mobile.util.LoginRequest;

public class LoginViewModel extends BaseViewModel<LoginFragment> {
    private final UserObservable userObservable = new UserObservable();

    public void onLoginClick() {
        UserDTO user = new UserDTO();
        user.setUsername(userObservable.getUsername().get());
        user.setPassword(userObservable.getPassword().get());

        try {
            JSONObject userJson = new JSONObject(new Gson().toJson(user));
            RequestQueue queue = Volley.newRequestQueue(mFragment.requireContext());
            LoginRequest lRequest = new LoginRequest(Request.Method.POST, EndPoint.LOGIN, userJson,
                    response -> loadUserData(), error -> Log.e("LoginViewModel", error.getMessage()));

            queue.add(lRequest);
        } catch (JSONException e) {
            Log.e("LoginViewModel", e.getMessage());
        }
    }

    public void loadUserData() {
        RequestQueue queue = Volley.newRequestQueue(mFragment.requireContext());
        AuthorizedRequest aRequest = new AuthorizedRequest(Request.Method.GET, EndPoint.USER_DATA, null,
                response -> {
                    if(response.isNull("id")) {
                        mFragment.showRegisterGeneralInfoFragment();
                    } else {
                        UserPreferences.getInstance().setUserData(new Gson().fromJson(response.toString(), UserDataDTO.class));
                        mFragment.showDailyStatisticsFragment();
                    }
                }, error -> Log.e("LoginViewModel", error.getMessage()));

        queue.add(aRequest);
    }

    public void onSingUpClick() {
        mFragment.showRegistrationFragment();
    }

    public UserObservable getUserObservable() {
        return userObservable;
    }
}
