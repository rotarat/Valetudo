package bg.valetudo.mobile.ui.login;

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

import java.util.Objects;
import java.util.Optional;

import bg.valetudo.mobile.BR;
import bg.valetudo.mobile.R;
import bg.valetudo.mobile.ui.MainActivity;
import bg.valetudo.mobile.ui.daily.DailyStatisticsFragment;
import bg.valetudo.mobile.ui.register.RegisterFragment;
import bg.valetudo.mobile.ui.register.generalinfo.RegisterGeneralInfoFragment;

public class LoginFragment extends Fragment {
    private LoginViewModel mLoginViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginViewModel = ViewModelProviders.of(requireActivity()).get(LoginViewModel.class);
        mLoginViewModel.setFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewDataBinding dataBinding = DataBindingUtil.bind(view);
        Optional.ofNullable(dataBinding).ifPresent((dBinding) -> dBinding.setVariable(BR.viewModel, mLoginViewModel));
    }

    public void showRegistrationFragment() {
        ((MainActivity) requireActivity()).showFragment(RegisterFragment.class);
    }

    public void showDailyStatisticsFragment() {
        ((MainActivity) requireActivity()).showFragment(DailyStatisticsFragment.class);
    }

    public void showRegisterGeneralInfoFragment() {
        ((MainActivity) requireActivity()).showFragment(RegisterGeneralInfoFragment.class);
    }
}
