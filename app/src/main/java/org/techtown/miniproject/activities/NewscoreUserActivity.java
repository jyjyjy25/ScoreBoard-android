package org.techtown.miniproject.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.techtown.miniproject.R;
import org.techtown.miniproject.adapters.UserNewscoreAdapter;
import org.techtown.miniproject.items.UserItem;

public class NewscoreUserActivity extends AppCompatActivity {
    RecyclerView user_recycler_view;
    Handler handler = new Handler();
    SlidingUpPanelLayout top_sliding_layout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newscore_user);

        Button user1_name = (Button) findViewById(R.id.user1_name);
        EditText user1_score = (EditText) findViewById(R.id.user1_score);
        Button user2_name = (Button) findViewById(R.id.user2_name);
        EditText user2_score = (EditText) findViewById(R.id.user2_score);
        SlidingUpPanelLayout sliding_layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); // 키보드 객체

        /* recyclerView 설정 */
        user_recycler_view = (RecyclerView) findViewById(R.id.user_recycler_view);

        LinearLayoutManager user_layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        user_recycler_view.setLayoutManager(user_layoutManager);

        UserNewscoreAdapter user_adapter = new UserNewscoreAdapter(this);
        user_adapter.addItem(new UserItem("Gabe", 31, "Male", 4, 0));
        user_adapter.addItem(new UserItem("June", 29, "Male", 0, 4));
        user_adapter.addItem(new UserItem("Julia", 23, "Female", 2, 2));

        /* 유저 선택 이벤트 */
        user1_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getApplicationContext().getResources().getConfiguration().hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
                    user1_score.clearFocus();
                    user2_score.clearFocus();
                    imm.hideSoftInputFromWindow(user1_score.getWindowToken(), imm.HIDE_NOT_ALWAYS); // 키보드 내리기
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED); // 패널 올리기
                    }
                },300); // 0.3초동안 딜레이

                user_adapter.setOnItemClickListener(new UserNewscoreAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClick(View view, int pos) {
                        user1_name.setText(user_adapter.getItem(pos).getUser_name()); // 유저 이름 설정
                        sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN); // 패널 내리기
                        user1_score.requestFocus(); // user1_score 포커스 주기
                        imm.showSoftInput(user1_score, InputMethodManager.SHOW_IMPLICIT); // 키보드 올리기
                    }
                });
            }
        });
        user2_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getApplicationContext().getResources().getConfiguration().hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
                    user1_score.clearFocus();
                    user2_score.clearFocus();
                    imm.hideSoftInputFromWindow(user2_score.getWindowToken(), imm.HIDE_NOT_ALWAYS); // 키보드 내리기
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED); // 패널 올리기
                    }
                },300); // 0.3초동안 딜레이

                user_adapter.setOnItemClickListener(new UserNewscoreAdapter.OnItemClickListener() {
                    @Override
                    public void OnItemClick(View view, int pos) {
                        user2_name.setText(user_adapter.getItem(pos).getUser_name()); // 유저 이름 설정
                        sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN); // 패널 내리기
                        user2_score.requestFocus(); // user2_score 포커스 주기
                        imm.showSoftInput(user2_score, InputMethodManager.SHOW_IMPLICIT); // 키보드 올리기
                    }
                });
            }
        });

        user_recycler_view.setAdapter(user_adapter);

        /* user1_score 키보드의 NEXT 버튼 이벤트 */
        user1_score.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_NEXT){
                    user2_score.clearFocus();
                    user2_name.performClick();
                }
                return false;
            }
        });

        /* user_score 선택 시 패널이 EXPANDED 상태일 경우 HIDDEN으로 변경 */
        user1_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sliding_layout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED) {
                    sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
                }
                user1_score.requestFocus();
            }
        });
        user2_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sliding_layout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED) {
                    sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
                }
                user2_score.requestFocus();
            }
        });

        /* drag_view 외부 영역 클릭 시 발생하는 이벤트 */
        LinearLayout background_layout = (LinearLayout) findViewById(R.id.background_view);
        background_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
            }
        });

        /* 저장 버튼 클릭 이벤트 */
        Button save_button = (Button) findViewById(R.id.save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.putExtra("user1_name", user1_name.getText().toString());
                intent.putExtra("user1_score", user1_score.getText().toString());
                intent.putExtra("user2_name", user2_name.getText().toString());
                intent.putExtra("user2_score", user2_score.getText().toString());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                setResult(Activity.RESULT_OK, intent);
                startActivity(intent);
            }
        });

        /* 유저 추가 클릭 이벤트 설정 */
        top_sliding_layout = (SlidingUpPanelLayout) findViewById(R.id.top_sliding_layout);

        Button add_user = (Button) findViewById(R.id.add_user);
        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                top_sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);

                final Button btn_add = (Button) findViewById(R.id.add);
                final EditText editTextName = (EditText) findViewById(R.id.new_user_name);
                final EditText editTextAge = (EditText) findViewById(R.id.new_user_age);
                final RadioGroup rGroup = (RadioGroup) findViewById(R.id.radio_group);

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
                                Toast.makeText(getApplicationContext(), "성별을 선택하세요.", Toast.LENGTH_SHORT).show();
                        }

                        user_adapter.addItem(new UserItem(new_user_name, new_user_age, new_user_gender, 0, 0));
                        user_adapter.notifyItemChanged(-1);

                        imm.hideSoftInputFromWindow(editTextAge.getWindowToken(), 0); // 키보드 내리기
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                top_sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN); // 패널 내리기
                            }
                        }, 50); // 0.05초 딜레이
                    }
                });
            }
        });

    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        String game_name = data.getStringExtra("game_name");
        Toast.makeText(getApplicationContext(), "게임 이름: " + game_name, Toast.LENGTH_LONG);
    }
}
