package bg.valetudo.mobile.ui.daily;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import bg.valetudo.mobile.UserPreferences;
import bg.valetudo.mobile.model.api.daily.DailyFoodIntakeDTO;
import bg.valetudo.mobile.model.api.user.UserDataDTO;
import bg.valetudo.mobile.model.constants.EndPoint;
import bg.valetudo.mobile.model.enums.configuration.ModulesEnum;
import bg.valetudo.mobile.model.enums.daily.DailyStatisticsEnum;
import bg.valetudo.mobile.model.other.daily.DailyStatisticChartCategoryHolder;
import bg.valetudo.mobile.model.other.daily.ChartData;
import bg.valetudo.mobile.ui.base.BaseViewModel;
import bg.valetudo.mobile.util.AuthorizedRequest;

public class DailyStatisticsViewModel extends BaseViewModel<DailyStatisticsFragment> {
    private final MutableLiveData<List<DailyStatisticChartCategoryHolder>> dailyStatisticCategoryHolders = new MutableLiveData<>();

    private DailyFoodIntakeDTO dailyFoodIntake;

    public void init() {
        List<DailyStatisticChartCategoryHolder> categoryHolders = new LinkedList<>();
        Set<ModulesEnum> modules = UserPreferences.getInstance().getUserData().getModules();
        modules.forEach(module -> {
            DailyStatisticChartCategoryHolder categoryHolder = new DailyStatisticChartCategoryHolder();
            categoryHolder.setModule(module);
            categoryHolder.setDailyStatistics(Arrays.stream(DailyStatisticsEnum.values()).filter(ds -> ds.getModule() == module).collect(Collectors.toList()));
            categoryHolder.getSelectedDailyStatistic().set(categoryHolder.getDailyStatistics().get(0));

            categoryHolders.add(categoryHolder);
        });

        dailyStatisticCategoryHolders.setValue(categoryHolders);

        loadDailyFoodIntake();
    }

    public void refresh() {
        loadDailyFoodIntake();
    }

    private void loadDailyFoodIntake() {
        RequestQueue queue = Volley.newRequestQueue(mFragment.requireContext());
        AuthorizedRequest aRequest = new AuthorizedRequest(Request.Method.GET, EndPoint.DAILY_FOOD_INTAKE, null,
                response -> {
                    dailyFoodIntake = new Gson().fromJson(response.toString(), DailyFoodIntakeDTO.class);
                    mFragment.setChartDataMapToAdapter(getChartDataMap());

                    mFragment.stopRefreshing();
                }, error -> Log.e("LoginViewModel", error.getMessage()));

        queue.add(aRequest);
    }

    private Map<DailyStatisticsEnum, ChartData> getChartDataMap() {
        Map<DailyStatisticsEnum, ChartData> chartData = new HashMap<>();

        Integer dailyFoodGoalPercentage = (int) ((dailyFoodIntake.getCalories().doubleValue() / UserPreferences.getInstance().getUserData().getGoalFood().doubleValue()) * 100);
        String dailyFoodGoalBottomText = dailyFoodIntake.getCalories() + "/" + UserPreferences.getInstance().getUserData().getGoalFood() + " kcal";

        chartData.put(DailyStatisticsEnum.DAILY_FOOD_GOAL, ChartData.forArcProgress(dailyFoodGoalPercentage, dailyFoodGoalBottomText));

        return chartData;
    }

    public MutableLiveData<List<DailyStatisticChartCategoryHolder>> getDailyStatisticCategoryHolders() {
        return dailyStatisticCategoryHolders;
    }
}
