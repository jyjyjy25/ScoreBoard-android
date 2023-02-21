package org.techtown.miniproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.techtown.miniproject.adapters.UserInfoAdapter;
import org.techtown.miniproject.items.GameItem;
import org.techtown.miniproject.items.UserItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserFragment extends Fragment {
    RecyclerView user_recycler_view;
    ArrayList<UserItem> user_list;
    SlidingUpPanelLayout sliding_layout;
    Handler handler = new Handler();

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

        /* 유저 추가 클릭 이벤트 설정 */
        sliding_layout = (SlidingUpPanelLayout) rootView.findViewById(R.id.user_layout);
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);

        Button add_user = (Button) rootView.findViewById(R.id.add_user);
        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);

                final Button btn_add = (Button) rootView.findViewById(R.id.add);
                final EditText editTextName = (EditText) rootView.findViewById(R.id.new_user_name);
                final EditText editTextAge = (EditText) rootView.findViewById(R.id.new_user_age);
                final RadioGroup rGroup = (RadioGroup) rootView.findViewById(R.id.radio_group);

                /* 패널 내의 추가 버튼 클릭 이벤트 설정 */
                btn_add.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        String new_user_name = editTextName.getText().toString();
                        int new_user_age = Integer.parseInt(editTextAge.getText().toString());

                        String new_user_gender = null;
                        switch (rGroup.getCheckedRadioButtonId()) {
                            case R.id.radio_btn_male:
                                new_user_gender = "Male";
                            case R.id.radio_btn_female:
                                new_user_gender = "Female";
                            default:
                                Toast.makeText(getContext(), "성별을 선택하세요.", Toast.LENGTH_SHORT).show();
                        }

                        user_adapter.addItem(new UserItem(new_user_name, new_user_age, new_user_gender, 0, 0));
                        user_adapter.notifyItemChanged(-1);

//                        imm.hideSoftInputFromWindow(editTextName.getWindowToken(), 0); // 키보드 내리기
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN); // 패널 내리기
                            }
                        }, 50); // 0.05초 딜레이
                    }
                });
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