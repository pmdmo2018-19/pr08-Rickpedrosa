package es.iessaladillo.pedrojoya.pr08.ui.init;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.databinding.InitFragmentBinding;
import es.iessaladillo.pedrojoya.pr08.utils.FragmentUtils;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

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
            //noinspection RedundantIfStatement
            if (item.getItemId() == R.id.mnuSettings) {
               // FragmentUtils.replaceFragmentAddToBackstack(getFragmentManager(), );
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
        b.initFragmentFab.setOnClickListener(v -> {
            //Abrir fragmento de detalle
        });
    }

}
