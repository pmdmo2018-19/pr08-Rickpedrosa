package es.iessaladillo.pedrojoya.pr08.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.databinding.DetailFragmentBinding;

public class DetailFragment extends Fragment {

    private DetailFragmentBinding b;

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void setupToolbar() {
        b.toolbarDetailFragment.setTitle(R.string.detailFragment_lblTitle);
        b.toolbarDetailFragment.setNavigationIcon(R.drawable.ic_arrow_back_whitev2_24dp);
        b.toolbarDetailFragment.setNavigationOnClickListener(v -> requireActivity().onBackPressed());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        b = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false);
        return b.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupToolbar();
        setupFab();
    }

    private void setupFab() {
        b.detailFragmentFab.setOnClickListener(v -> Toast.makeText(requireContext(), "CYKA BLYAT", Toast.LENGTH_SHORT).show());
    }

}
