package es.iessaladillo.pedrojoya.pr08.ui.init;


import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.databinding.InitFragmentBinding;
import es.iessaladillo.pedrojoya.pr08.ui.detail.DetailFragment;
import es.iessaladillo.pedrojoya.pr08.ui.settings.SettingsFragment;
import es.iessaladillo.pedrojoya.pr08.utils.FragmentUtils;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class InitFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    private InitFragmentBinding b;
    private SharedPreferences sharedPreferences;

    public static InitFragment newInstance() {
        return new InitFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.init_fragment, container, false);
        return b.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupViews();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        showLoremText();
    }

    private void setupViews() {
        setupToolbar();
        setupFab();
    }

    private void showLoremText() {
        b.lblLorem.setText(sharedPreferences.getString(getString(R.string.lore_or_chiquito_prefkey), getString(R.string.main_latin_ipsum)));
    }

    @Override
    public void onResume() {
        super.onResume();
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    private void setupFab() {
        b.initFragmentFab.setOnClickListener(v -> FragmentUtils.replaceFragmentAddToBackstack(requireFragmentManager(),
                R.id.flInit, DetailFragment.newInstance(), DetailFragment.class.getSimpleName()
                , DetailFragment.class.getSimpleName(), FragmentTransaction.TRANSIT_FRAGMENT_FADE));
    }


    private void setupToolbar() {
        b.toolbarInitFragment.setTitle(R.string.initFragment_lblTitle);
        b.toolbarInitFragment.inflateMenu(R.menu.init_fragment);
        b.toolbarInitFragment.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.mnuSettings) {
                FragmentUtils.replaceFragmentAddToBackstack(requireFragmentManager(),
                        R.id.flInit, SettingsFragment.newInstance(),
                        SettingsFragment.class.getSimpleName(), SettingsFragment.class.getSimpleName(), FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                return true;
            } else {
                return false;
            }
        });
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (TextUtils.equals(key, getString(R.string.lore_or_chiquito_prefkey))) {
            showLoremText();
        }
    }
}
