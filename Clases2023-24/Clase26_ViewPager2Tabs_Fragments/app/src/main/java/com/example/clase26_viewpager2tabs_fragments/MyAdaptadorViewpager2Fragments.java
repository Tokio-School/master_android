package com.example.clase26_viewpager2tabs_fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdaptadorViewpager2Fragments extends FragmentStateAdapter {

    public MyAdaptadorViewpager2Fragments(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentUno();
            case 1:
                return new FragmentDos();
            case 2:
                return new FragmentTres();
            case 3:
                return new FragmentCuatro();
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
