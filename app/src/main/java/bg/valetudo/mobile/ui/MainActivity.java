package bg.valetudo.mobile.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Optional;

import bg.valetudo.mobile.R;
import bg.valetudo.mobile.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Optional.ofNullable(getSupportActionBar()).ifPresent(ActionBar::hide);
        showFragment(LoginFragment.class);
    }

    public void showFragment(Class<? extends Fragment> fragmentClass) {
        FragmentManager fm = getSupportFragmentManager();
        if(!fm.getFragments().isEmpty())
            closeFragment(fm, getSupportFragmentManager().getFragments().get(0).getTag());

        try {
            Fragment f = fragmentClass.newInstance();
            fm.beginTransaction().add(R.id.fragment_container, f, fragmentClass.getSimpleName()).commit();
        } catch (IllegalAccessException | InstantiationException e) {
            Log.e("MainActivity", "Could not instantiate fragment!");
        }
    }

    private void closeFragment(FragmentManager fm, String fragmentTag) {
        Fragment fragment = fm.findFragmentByTag(fragmentTag);
        if (fragment != null) {
            fragment.onDetach();
            fm.beginTransaction()
                .disallowAddToBackStack()
                .remove(fragment)
                .commitNow();
        }
    }
}