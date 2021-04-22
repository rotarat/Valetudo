package bg.valetudo.mobile.model.enums.daily;

import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;

import bg.valetudo.mobile.R;
import bg.valetudo.mobile.model.enums.configuration.ModulesEnum;

public enum DailyStatisticsEnum {
    DAILY_FOOD_GOAL(ModulesEnum.FOOD_BEVERAGE, R.string.ds_daily_goal, R.layout.arc_progress_chart);

    private final ModulesEnum module;

    @StringRes
    private final int label;

    @LayoutRes
    private final int chartLayout;

    DailyStatisticsEnum(ModulesEnum module, int label, int chartLayout) {
        this.module = module;
        this.label = label;
        this.chartLayout = chartLayout;
    }

    public ModulesEnum getModule() {
        return module;
    }

    public int getLabel() {
        return label;
    }

    public int getChartLayout() {
        return chartLayout;
    }
}
