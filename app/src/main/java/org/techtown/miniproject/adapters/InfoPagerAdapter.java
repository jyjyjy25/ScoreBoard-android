package org.techtown.miniproject.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import org.techtown.miniproject.GameFragment;
import org.techtown.miniproject.UserFragment;

import java.util.ArrayList;

public class InfoPagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> items = new ArrayList<Fragment>();

    public InfoPagerAdapter(@NonNull FragmentManager fm, int pageCnt) {
        super(fm, pageCnt);
        items.add(new GameFragment());
        items.add(new UserFragment());
    }

    public void addItem(Fragment item) {
        items.add(item);
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
