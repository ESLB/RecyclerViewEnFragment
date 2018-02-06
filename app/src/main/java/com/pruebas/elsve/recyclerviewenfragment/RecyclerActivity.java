package com.pruebas.elsve.recyclerviewenfragment;

import android.support.v4.app.Fragment;

public class RecyclerActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new RecyclerFragment();
    }
}
