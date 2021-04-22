package bg.valetudo.mobile.model.other.daily;

public class ChartData {
    // Arc Progress
    private Integer arcProgressPercent;
    private String arcBottomText;

    public static ChartData forArcProgress(Integer percentage, String bottomText) {
        ChartData chartData = new ChartData();
        chartData.arcProgressPercent = percentage;
        chartData.arcBottomText = bottomText;

        return chartData;
    }

    public Integer getArcProgressPercent() {
        return arcProgressPercent;
    }

    public String getArcBottomText() {
        return arcBottomText;
    }
}
