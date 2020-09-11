package com.temmy.gadsleadersboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int NumofTabs) {
        super(fm, NumofTabs);
        this.mNoOfTabs = NumofTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new HourFrag();
            case 1: return new IQFrag();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
