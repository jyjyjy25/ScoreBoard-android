package org.techtown.miniproject.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.tabs.TabLayout;

import org.techtown.miniproject.GameFragment;
import org.techtown.miniproject.R;
import org.techtown.miniproject.UserFragment;

public class InfoActivity extends FragmentActivity {
    TabLayout tabs;
    GameFragment game_fragment;
    UserFragment user_fragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

    }
}
