package es.iessaladillo.pedrojoya.pr08.ui.main;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.preference.PreferenceManager;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.base.SharedPreferencesStringLiveData;

@SuppressWarnings("WeakerAccess")
public class MainActivityViewModel extends AndroidViewModel {

    private final LiveData<String> loremType;

    public MainActivityViewModel(Application application) {
        super(application);
        loremType = new SharedPreferencesStringLiveData(PreferenceManager.getDefaultSharedPreferences(application),
                application.getString(R.string.lore_or_chiquito_prefkey), application.getString(R.string.prefLoreChiquito_defaultValue));
    }

    LiveData<String> getLoremType() {
        return loremType;
    }
}
