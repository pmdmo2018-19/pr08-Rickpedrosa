package es.iessaladillo.pedrojoya.pr08.ui.init;


import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.databinding.InitFragmentBinding;
import es.iessaladillo.pedrojoya.pr08.ui.detail.DetailFragment;
import es.iessaladillo.pedrojoya.pr08.ui.settings.SettingsFragment;
import es.iessaladillo.pedrojoya.pr08.utils.FragmentUtils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class InitFragment extends Fragment {

    //private InitViewModel mViewModel;
    private InitFragmentBinding b;

    public static InitFragment newInstance() {
        return new InitFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void setupToolbar() {
        b.toolbarInitFragment.setTitle(R.string.initFragment_lblTitle);
        b.toolbarInitFragment.inflateMenu(R.menu.init_fragment);
        b.toolbarInitFragment.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.mnuSettings) {
                FragmentUtils.replaceFragmentAddToBackstack(requireFragmentManager(),
                        R.id.flInit, SettingsFragment.newInstance(),
                        SettingsFragment.class.getSimpleName(), SettingsFragment.class.getSimpleName(), FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                Toast.makeText(requireContext(), "Yo abriré settings_fragment", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                return false;
            }
        });
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
        setupToolbar();
        setupFab();
        //mViewModel = ViewModelProviders.of(this).get(InitViewModel.class);
        // TODO: Use the ViewModel
    }

    private void setupFab() {
        b.initFragmentFab.setOnClickListener(v -> FragmentUtils.replaceFragmentAddToBackstack(requireFragmentManager(),
                R.id.flInit, DetailFragment.newInstance(), DetailFragment.class.getSimpleName()
                , DetailFragment.class.getSimpleName(), FragmentTransaction.TRANSIT_FRAGMENT_FADE));
    }

}
