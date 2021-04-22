package bg.valetudo.mobile.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import bg.valetudo.mobile.BR;

public class GenericRecyclerViewAdapter<T> extends RecyclerView.Adapter<GenericRecyclerViewAdapter.GenericViewHolder> {
    @LayoutRes
    protected int layoutId;
    protected ViewModel viewModel;
    protected List<T> responseCollection;

    public GenericRecyclerViewAdapter(@LayoutRes int layoutId) {
        this(null, layoutId);
    }

    public GenericRecyclerViewAdapter(ViewModel viewModel, @LayoutRes int layoutId) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
        this.responseCollection = new ArrayList<>();
    }

    @NonNull
    @Override
    public GenericRecyclerViewAdapter.GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, layoutId, parent, false);
        return new GenericViewHolder(binding, viewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericRecyclerViewAdapter.GenericViewHolder holder, int position) {
        holder.onBind(responseCollection.get(position));
    }

    @Override
    public int getItemCount() {
        return responseCollection.size();
    }

    public void setItems(List<T> list) {
        responseCollection.clear();

        responseCollection.addAll(list);
        notifyDataSetChanged();
    }

    public void clearItems() {
        responseCollection.clear();
    };

    public ViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public List<T> getResponseCollection() {
        return responseCollection;
    }

    public void setResponseCollection(List<T> responseCollection) {
        this.responseCollection = responseCollection;
    }

    public int getObjectPosition(T obj) { return responseCollection.indexOf(obj); }

    public static class GenericViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding mBinding;
        private ViewModel mViewModel;

        public GenericViewHolder(ViewDataBinding binding, ViewModel viewModel) {
            super(binding.getRoot());
            this.mBinding = binding;
            this.mViewModel = viewModel;
        }

        public <T> void onBind(T obj) {
            mBinding.setVariable(BR.viewModel, mViewModel);
            mBinding.setVariable(BR.obj, obj);
            mBinding.executePendingBindings();
        }
    }
}
