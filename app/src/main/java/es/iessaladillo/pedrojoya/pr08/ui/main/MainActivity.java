package es.iessaladillo.pedrojoya.pr08.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import es.iessaladillo.pedrojoya.pr08.R;
import es.iessaladillo.pedrojoya.pr08.ui.init.InitFragment;
import es.iessaladillo.pedrojoya.pr08.utils.FragmentUtils;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.flInit, InitFragment.newInstance(), InitFragment.class.getSimpleName());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
