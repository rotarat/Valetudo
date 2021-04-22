package bg.valetudo.mobile.ui.register.generalinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import java.util.Optional;

import bg.valetudo.mobile.BR;
import bg.valetudo.mobile.R;
import bg.valetudo.mobile.databinding.FragmentGeneralInfoBindingImpl;
import bg.valetudo.mobile.model.enums.configuration.GenderEnum;
import bg.valetudo.mobile.ui.MainActivity;
import bg.valetudo.mobile.ui.base.BaseFragment;
import bg.valetudo.mobile.ui.home.GenericSpinnerAdapter;
import bg.valetudo.mobile.ui.register.measurements.RegisterMeasurementsFragment;

public class RegisterGeneralInfoFragment extends BaseFragment<FragmentGeneralInfoBindingImpl> {
    RegisterGeneralInfoViewModel mRegisterGeneralInfoViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRegisterGeneralInfoViewModel = ViewModelProviders.of(requireActivity()).get(RegisterGeneralInfoViewModel.class);
        mRegisterGeneralInfoViewModel.setFragment(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_general_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding = DataBindingUtil.bind(view);
        Optional.ofNullable(mViewDataBinding).ifPresent((dBinding) -> dBinding.setVariable(BR.viewModel, mRegisterGeneralInfoViewModel));

        populateGenderSpinner();
    }

    public void showMeasurementFragment () {
        ((MainActivity) requireActivity()).showFragment(RegisterMeasurementsFragment.class);
    }

    private void populateGenderSpinner() {
        GenericSpinnerAdapter<GenderEnum> genderAdapter = new GenericSpinnerAdapter<>(requireContext(), GenderEnum.values(), true);
        mViewDataBinding.genderSpinner.setAdapter(genderAdapter);
        mViewDataBinding.genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position > 0) {
                    GenderEnum selected = GenderEnum.values()[position - 1];
                    mRegisterGeneralInfoViewModel.getUserDataObservable().getGender().set(selected);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
