package bg.valetudo.mobile.ui.base;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

public class BaseViewModel<T extends Fragment> extends ViewModel {
    protected T mFragment;

    public void setFragment(T mFragment) {
        this.mFragment = mFragment;
    }
}
