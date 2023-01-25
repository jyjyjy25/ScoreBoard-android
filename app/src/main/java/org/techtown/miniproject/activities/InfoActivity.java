package org.techtown.miniproject.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.tabs.TabLayout;

import org.techtown.miniproject.GameFragment;
import org.techtown.miniproject.R;
import org.techtown.miniproject.UserFragment;

public class InfoActivity extends AppCompatActivity {
    TabLayout tabs;
    GameFragment game_fragment;
    UserFragment user_fragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        game_fragment = new GameFragment();
        user_fragment = new UserFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, game_fragment).commit();

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("게임"));
        tabs.addTab(tabs.newTab().setText("유저"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected = null;
                if (position == 0) {
                    selected = game_fragment;
                } else if (position == 1) {
                    selected = user_fragment;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }



}
