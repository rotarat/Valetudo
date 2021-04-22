package bg.valetudo.mobile.ui.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Optional;

import bg.valetudo.mobile.BR;
import bg.valetudo.mobile.R;
import bg.valetudo.mobile.ui.MainActivity;
import bg.valetudo.mobile.ui.login.LoginFragment;
import bg.valetudo.mobile.ui.register.generalinfo.RegisterGeneralInfoFragment;

public class RegisterFragment extends Fragment {
    private RegisterViewModel mRegisterViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRegisterViewModel = ViewModelProviders.of(requireActivity()).get(RegisterViewModel.class);
        mRegisterViewModel.setFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewDataBinding dataBinding = DataBindingUtil.bind(view);
        Optional.ofNullable(dataBinding).ifPresent((dBinding) -> dBinding.setVariable(BR.viewModel, mRegisterViewModel));
    }

    void showLoginFragment() {
        ((MainActivity) requireActivity()).showFragment(LoginFragment.class);
    }

    void showGeneralInfoFragment () {
        ((MainActivity) requireActivity()).showFragment(RegisterGeneralInfoFragment.class);
    }
}
