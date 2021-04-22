package bg.valetudo.mobile.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import bg.valetudo.mobile.BR;
import bg.valetudo.mobile.R;
import bg.valetudo.mobile.databinding.DailyStatisticsItemBinding;
import bg.valetudo.mobile.model.enums.daily.DailyStatisticsEnum;
import bg.valetudo.mobile.model.other.daily.DailyStatisticChartCategoryHolder;
import bg.valetudo.mobile.model.other.daily.ChartData;

public class ChartRecyclerViewAdapter extends RecyclerView.Adapter<ChartRecyclerViewAdapter.ChartRecyclerViewAdapterViewHolder> {
    protected ViewModel viewModel;
    protected List<DailyStatisticChartCategoryHolder> items = new LinkedList<>();

    protected Map<DailyStatisticsEnum, ChartData> chartDataMap;

    public ChartRecyclerViewAdapter(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public ChartRecyclerViewAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        DailyStatisticsItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.daily_statistics_item, parent, false);
        return new ChartRecyclerViewAdapter.ChartRecyclerViewAdapterViewHolder(parent, binding, viewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull ChartRecyclerViewAdapterViewHolder holder, int position) {
        holder.onBind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setChartDataMap(Map<DailyStatisticsEnum, ChartData> chartDataMap) {
        this.chartDataMap = chartDataMap;
        notifyDataSetChanged();
    }

    public void setItems(Collection<DailyStatisticChartCategoryHolder> categoryHolders) {
        items.clear();
        items.addAll(categoryHolders);

        notifyDataSetChanged();
    }

    public class ChartRecyclerViewAdapterViewHolder extends RecyclerView.ViewHolder {
        private final ViewGroup parent;
        private final DailyStatisticsItemBinding mBinding;
        private final ViewModel mViewModel;

        public ChartRecyclerViewAdapterViewHolder(ViewGroup parent, DailyStatisticsItemBinding binding, ViewModel viewModel) {
            super(binding.getRoot());
            this.parent = parent;
            this.mBinding = binding;
            this.mViewModel = viewModel;
        }

        public void onBind(DailyStatisticChartCategoryHolder obj) {
            mBinding.setVariable(BR.viewModel, mViewModel);
            mBinding.setVariable(BR.obj, obj);

            if(obj.getSelectedDailyStatistic().get() != null) {
                if (chartDataMap != null) {
                    LinearLayout chartContainerView = itemView.findViewById(R.id.chart_include);
                    if(chartContainerView.getChildCount() > 0)
                        chartContainerView.removeAllViews();

                    View chartLayoutView = View.inflate(parent.getContext(), Objects.requireNonNull(obj.getSelectedDailyStatistic().get()).getChartLayout(), parent.findViewById(R.id.chart_include));

                    chartContainerView.addView(chartLayoutView);

                    ViewDataBinding chartLayoutDataBinding = DataBindingUtil.bind(chartLayoutView);
                    chartLayoutDataBinding.setVariable(BR.chartData, chartDataMap.get(obj.getSelectedDailyStatistic().get()));
                }
            }

            mBinding.executePendingBindings();
        }
    }
}
