package es.iessaladillo.pedrojoya.pr08.ui.settings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;
import es.iessaladillo.pedrojoya.pr08.R;

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

    public static SettingsFragment newInstance(){
        return new SettingsFragment();
    }
}
