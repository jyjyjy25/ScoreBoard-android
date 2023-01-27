package org.techtown.miniproject;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import org.techtown.miniproject.adapters.UserAdapter;
import org.techtown.miniproject.items.UserItem;

public class UserFragment extends Fragment {
    RecyclerView user_recycler_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_user, container, false);

        /* 선택된 tab 텍스트 색상 설정 */
        TabLayout tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        tabs.setTabTextColors(Color.rgb(153, 153, 153), Color.rgb(0, 0, 0));

        /* recyclerView 설정 */
        user_recycler_view = (RecyclerView) rootView.findViewById(R.id.user_recycler_view);

        LinearLayoutManager user_layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        user_recycler_view.setLayoutManager(user_layoutManager);

        UserAdapter user_adapter = new UserAdapter(getActivity());
        user_adapter.addItem(new UserItem("Gabe", 31, "Male", 4, 0));
        user_adapter.addItem(new UserItem("June", 29, "Male", 0, 4));
        user_adapter.addItem(new UserItem("Julia", 23, "Female", 2, 2));
        user_recycler_view.setAdapter(user_adapter);

        return rootView;
    }

}