package com.cys.animalhospital;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabAdapter extends FragmentStateAdapter {

    Fragment[] fragments=new Fragment[4];

    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        fragments[0]=new Fragment1();
        fragments[1]=new Fragment2();
        fragments[2]=new Fragment3();
        fragments[3]=new Fragment4();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}
