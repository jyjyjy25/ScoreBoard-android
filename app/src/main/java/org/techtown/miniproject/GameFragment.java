package org.techtown.miniproject;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import org.techtown.miniproject.activities.InfoActivity;
import org.techtown.miniproject.adapters.GameAdapter;
import org.techtown.miniproject.items.GameItem;
import org.techtown.miniproject.items.UserItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GameFragment extends Fragment {
    RecyclerView game_recycler_view;
    InfoActivity activity;
    ArrayList<GameItem> game_list;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        activity = (InfoActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_game, container, false);

        /* 선택된 tab 텍스트 색상 설정 */
        TabLayout tabs = (TabLayout) rootView.findViewById(R.id.tabs);
        tabs.setTabTextColors(Color.rgb(153, 153, 153), Color.rgb(0, 0, 0));

        /* recyclerView 설정 */
        game_recycler_view = (RecyclerView) rootView.findViewById(R.id.game_recycler_view);

        LinearLayoutManager game_layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        game_recycler_view.setLayoutManager(game_layoutManager);

        GameAdapter game_adapter = new GameAdapter(getActivity());
        game_adapter.addItem(new GameItem("배구"));
        game_adapter.addItem(new GameItem("컬링"));
        game_adapter.addItem(new GameItem("허들"));
        game_adapter.addItem(new GameItem("가위바위보"));
        game_adapter.addItem(new GameItem("탁구"));
        game_adapter.addItem(new GameItem("농구"));
        game_adapter.addItem(new GameItem("묵찌빠"));
        game_adapter.addItem(new GameItem("볼링"));
        game_adapter.addItem(new GameItem("달리기"));
        game_adapter.addItem(new GameItem("신발던지기"));
        game_recycler_view.setAdapter(game_adapter);


        Comparator<GameItem> Asc = new Comparator<GameItem>() {
            @Override
            public int compare(GameItem o1, GameItem o2) {
                return o1.getGame_name().compareTo(o2.getGame_name()) ;
            }
        };

        Comparator<GameItem> Desc = new Comparator<GameItem>() {
            @Override
            public int compare(GameItem o1, GameItem o2) {
                return o2.getGame_name().compareTo(o1.getGame_name()) ;
            }
        };

        /* 기본 오름차순 설정 */
        game_list = game_adapter.getItems();
        Collections.sort(game_list, new GameAscComparator());
        game_adapter.notifyDataSetChanged();

        /* tab event 설정 */
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                Log.d("Tag", String.valueOf(pos));
                if (pos == 0) { // 오름차순
                    Collections.sort(game_list, Asc);
                    game_adapter.notifyDataSetChanged();
                } else if (pos == 1) { // 내림차순
                    Collections.sort(game_list, Desc);
                    game_adapter.notifyDataSetChanged();
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

class GameAscComparator implements Comparator<GameItem> {
    @Override
    public int compare(GameItem u1, GameItem u2) {
        return u1.getGame_name().compareTo(u2.getGame_name());
    }
}

class GameDesComparator implements Comparator<GameItem> {
    @Override
    public int compare(GameItem u1, GameItem u2) {
        return u2.getGame_name().compareTo(u1.getGame_name());
    }
}
