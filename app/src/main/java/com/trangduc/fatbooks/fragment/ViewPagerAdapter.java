package com.trangduc.fatbooks.fragment;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    /**
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new EndowFragment();
            case 1:
                return new CommunityFragment();
            case 2:
                return new LibraryFragment();
            default:
                return new EndowFragment();
        }
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return 3;
    }
}
