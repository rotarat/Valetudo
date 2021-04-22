package bg.valetudo.mobile.ui.register.measurements;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Set;

import bg.valetudo.mobile.UserPreferences;
import bg.valetudo.mobile.model.api.user.UserDataDTO;
import bg.valetudo.mobile.model.constants.EndPoint;
import bg.valetudo.mobile.model.enums.configuration.ModulesEnum;
import bg.valetudo.mobile.model.observable.user.UserDataObservable;
import bg.valetudo.mobile.model.observable.user.UserObservable;
import bg.valetudo.mobile.ui.base.BaseViewModel;
import bg.valetudo.mobile.util.AuthorizedRequest;

public class RegisterMeasurementsViewModel extends BaseViewModel<RegisterMeasurementsFragment> {
    public void onFinishClick() {
        UserDataDTO userData = UserPreferences.getInstance().getUserDataObservable().toDTO();
        userData.setModules(Set.of(ModulesEnum.FOOD_BEVERAGE));

        RequestQueue queue = Volley.newRequestQueue(mFragment.requireContext());
        AuthorizedRequest aRequest = null;
        try {
            aRequest = new AuthorizedRequest(Request.Method.POST, EndPoint.USER_DATA, new JSONObject(new Gson().toJson(userData)),
                    response -> {
                        UserPreferences.getInstance().setUserData(new Gson().fromJson(response.toString(), UserDataDTO.class));
                        mFragment.showDailyStatisticsFragment();
                    }, error -> Log.e("LoginViewModel", error.getMessage()));
        } catch (JSONException e) {
            Log.e("RegisterMeasurementsViewModel", e.getMessage());
        }

        queue.add(aRequest);
    }

    public UserDataObservable getUserDataObservable() {
        return UserPreferences.getInstance().getUserDataObservable();
    }
}
