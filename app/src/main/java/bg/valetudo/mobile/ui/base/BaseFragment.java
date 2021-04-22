package bg.valetudo.mobile.ui.base;

import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public class BaseFragment<T extends ViewDataBinding> extends Fragment {
    protected T mViewDataBinding;
}
