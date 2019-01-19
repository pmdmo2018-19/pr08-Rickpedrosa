package es.iessaladillo.pedrojoya.pr08.ui.settings;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceFragmentCompat;
import es.iessaladillo.pedrojoya.pr08.R;

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupToolBar();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    private void setupToolBar() {
        Toolbar toolbar = requireActivity().findViewById(R.id.toolbar_fragmentSettings);
        toolbar.setNavigationOnClickListener(v -> requireActivity().onBackPressed());
    }
}
