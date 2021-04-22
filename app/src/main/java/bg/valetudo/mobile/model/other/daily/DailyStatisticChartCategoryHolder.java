package bg.valetudo.mobile.model.other.daily;

import androidx.databinding.ObservableField;

import java.util.List;

import bg.valetudo.mobile.model.enums.configuration.ModulesEnum;
import bg.valetudo.mobile.model.enums.daily.DailyStatisticsEnum;

public class DailyStatisticChartCategoryHolder {
    private ModulesEnum module;
    private List<DailyStatisticsEnum> dailyStatistics;

    private final ObservableField<DailyStatisticsEnum> selectedDailyStatistic = new ObservableField<>();

    public ModulesEnum getModule() {
        return module;
    }

    public void setModule(ModulesEnum module) {
        this.module = module;
    }

    public List<DailyStatisticsEnum> getDailyStatistics() {
        return dailyStatistics;
    }

    public void setDailyStatistics(List<DailyStatisticsEnum> dailyStatistics) {
        this.dailyStatistics = dailyStatistics;
    }

    public ObservableField<DailyStatisticsEnum> getSelectedDailyStatistic() {
        return selectedDailyStatistic;
    }
}
