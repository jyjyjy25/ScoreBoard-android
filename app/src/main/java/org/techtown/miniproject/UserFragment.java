package org.techtown.miniproject;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import org.techtown.miniproject.adapters.UserInfoAdapter;
import org.techtown.miniproject.items.UserItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserFragment extends Fragment {
    RecyclerView user_recycler_view;
    ArrayList<UserItem> user_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_user, container, false);

        /* recyclerView 설정 */
        user_recycler_view = (RecyclerView) rootView.findViewById(R.id.user_recycler_view);

        LinearLayoutManager user_layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        user_recycler_view.setLayoutManager(user_layoutManager);

        UserInfoAdapter user_adapter = new UserInfoAdapter(getContext());
        user_adapter.addItem(new UserItem("Gabe", 31, "Male", 4, 0));
        user_adapter.addItem(new UserItem("June", 29, "Male", 0, 4));
        user_adapter.addItem(new UserItem("Julia", 23, "Female", 2, 2));
        user_recycler_view.setAdapter(user_adapter);

        /* 기본 오름차순 설정 */
        user_list = user_adapter.getItems();
        Collections.sort(user_list, new NameAscComparator());
        user_adapter.notifyDataSetChanged();

        /* 선택된 tab 텍스트 색상 설정 */
        TabLayout tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        tabs.setTabTextColors(Color.rgb(153, 153, 153), Color.rgb(0, 0, 0));

        /* tab event 설정 */
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                Log.d("Tag", String.valueOf(pos));
                if (pos == 0) { // 오름차순
                    Collections.sort(user_list, new NameAscComparator());
                    user_adapter.notifyDataSetChanged();
                } else if (pos == 1) { // 내림차순
                    Collections.sort(user_list, new NameDesComparator());
                    user_adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }

}

class NameAscComparator implements Comparator<UserItem> {
    @Override
    public int compare(UserItem u1, UserItem u2) {
        return u1.getUser_name().compareTo(u2.getUser_name());
    }
}

class NameDesComparator implements Comparator<UserItem> {
    @Override
    public int compare(UserItem u1, UserItem u2) {
        return u2.getUser_name().compareTo(u1.getUser_name());
    }
}