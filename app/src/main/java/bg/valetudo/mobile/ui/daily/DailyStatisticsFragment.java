package bg.valetudo.mobile.ui.daily;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import bg.valetudo.mobile.BR;
import bg.valetudo.mobile.R;
import bg.valetudo.mobile.databinding.FragmentDailyStatisticsBinding;
import bg.valetudo.mobile.model.enums.daily.DailyStatisticsEnum;
import bg.valetudo.mobile.model.other.daily.ChartData;
import bg.valetudo.mobile.ui.adapter.ChartRecyclerViewAdapter;
import bg.valetudo.mobile.ui.base.BaseFragment;

public class DailyStatisticsFragment extends BaseFragment<FragmentDailyStatisticsBinding> implements SwipeRefreshLayout.OnRefreshListener {
    private DailyStatisticsViewModel mDailyStatisticsViewModel;
    private ChartRecyclerViewAdapter mDailyStatisticCategoryHolderAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDailyStatisticsViewModel = ViewModelProviders.of(requireActivity()).get(DailyStatisticsViewModel.class);
        mDailyStatisticsViewModel.setFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_daily_statistics, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding = DataBindingUtil.bind(view);
        Optional.ofNullable(mViewDataBinding).ifPresent((dBinding) -> dBinding.setVariable(BR.viewModel, mDailyStatisticsViewModel));
        Objects.requireNonNull(mViewDataBinding).swipeRefreshLayout.setOnRefreshListener(this);

        attachRecyclerViewAdapter();
        mDailyStatisticsViewModel.init();
    }

    private void attachRecyclerViewAdapter() {
        mDailyStatisticCategoryHolderAdapter = new ChartRecyclerViewAdapter(mDailyStatisticsViewModel);
        mViewDataBinding.statisticRecyclerView.setAdapter(mDailyStatisticCategoryHolderAdapter);
        mViewDataBinding.statisticRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mViewDataBinding.statisticRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setChartDataMapToAdapter(Map<DailyStatisticsEnum, ChartData> chartDataMap) {
        mDailyStatisticCategoryHolderAdapter.setChartDataMap(chartDataMap);
    }

    public void notifyAdapterChange() {
        mDailyStatisticCategoryHolderAdapter.notifyDataSetChanged();
    }

    public void stopRefreshing() {
        mViewDataBinding.swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        mDailyStatisticsViewModel.refresh();
    }
}
