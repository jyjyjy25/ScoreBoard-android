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
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.techtown.miniproject.GameFragment;
import org.techtown.miniproject.R;
import org.techtown.miniproject.UserFragment;
import org.techtown.miniproject.adapters.InfoPagerAdapter;

public class InfoActivity extends AppCompatActivity {
    TabLayout tabs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        /* tab 추가 */
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("게임"));
        tabs.addTab(tabs.newTab().setText("유저"));

        /* ViewPager 설정 */
        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        InfoPagerAdapter adapter = new InfoPagerAdapter(getSupportFragmentManager(), tabs.getTabCount());
        pager.setAdapter(adapter);

        /* ViewPager 스와이프 이벤트 */
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        /* tab 클릭 이벤트 */
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
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
