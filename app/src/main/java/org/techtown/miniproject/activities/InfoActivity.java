package org.techtown.miniproject.activities;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.techtown.miniproject.R;
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

        /* tab 아이콘 색상 설정 */
        tabs.getTabAt(0).setIcon(R.drawable.ic_game);
        tabs.getTabAt(1).setIcon(R.drawable.ic_user);
        tabs.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#FF699565"), PorterDuff.Mode.SRC_IN);

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
                tab.getIcon().setColorFilter(Color.parseColor("#FF699565"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
