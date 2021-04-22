package bg.valetudo.mobile.util;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.github.lzyzsd.circleprogress.ArcProgress;

import java.util.List;
import java.util.Objects;

import bg.valetudo.mobile.model.other.daily.DailyStatisticChartCategoryHolder;
import bg.valetudo.mobile.ui.adapter.ChartRecyclerViewAdapter;
import bg.valetudo.mobile.ui.adapter.GenericRecyclerViewAdapter;

public class BindingUtils {

    private BindingUtils() {}

    @BindingAdapter({"data"})
    @SuppressWarnings("unchecked")
    public static <T> void setData(RecyclerView recyclerView, MutableLiveData<List<T>> data) {
        if(Objects.isNull(recyclerView.getAdapter()))
            return;

        if(GenericRecyclerViewAdapter.class.isAssignableFrom(Objects.requireNonNull(recyclerView.getAdapter()).getClass())) {
            GenericRecyclerViewAdapter<T> adapter = (GenericRecyclerViewAdapter<T>) recyclerView.getAdapter();
            adapter.setItems(data.getValue());
        }
    }

    @BindingAdapter("chartsCategoryHolders")
    public static void setChartsCategoryHolders(RecyclerView recyclerView, MutableLiveData<List<DailyStatisticChartCategoryHolder>> categoryHolders) {
        if(Objects.isNull(recyclerView.getAdapter()))
            return;

        if(ChartRecyclerViewAdapter.class.isAssignableFrom(Objects.requireNonNull(recyclerView.getAdapter()).getClass())) {
            ChartRecyclerViewAdapter adapter = (ChartRecyclerViewAdapter) recyclerView.getAdapter();
            adapter.setItems(categoryHolders.getValue());
        }
    }

    @BindingAdapter("b_arc_progress")
    public static void setArcProgress(ArcProgress arcProgress, Integer arcProgressValue) {
        if(arcProgressValue != null)
            arcProgress.setProgress(arcProgressValue);
    }

    @BindingAdapter("b_arc_bottom_text")
    public static void setArcBottomTextValue(ArcProgress arcProgress, String arcBottomTextValue) {
        if(arcBottomTextValue != null)
            arcProgress.setBottomText(arcBottomTextValue);
    }
}
