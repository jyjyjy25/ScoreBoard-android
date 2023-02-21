package org.techtown.miniproject.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.techtown.miniproject.R;
import org.techtown.miniproject.items.GameItem;

public class NewscoreGameActivity extends AppCompatActivity {
    boolean isExistBlank = false;
    private SharedPreferences preferences;
    SlidingUpPanelLayout sliding_layout;
    SlidingUpPanelLayout top_sliding_layout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newscore_game);

        sliding_layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);

        /* 게임 버튼 이벤트 */
        Button game_button = (Button) findViewById(R.id.game_name);
        game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        });

        /* 다음 버튼 이벤트 */
        Button next_button = (Button) findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isExistBlank) {
                    Intent intent = new Intent(getApplicationContext(), NewscoreUserActivity.class);
                    // intent.putExtra("game_name", game_name.getText().toString());
                    startActivityResult.launch(intent);
                } else {
                    // 비어있는 edittext 디자인 변경
                }
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

        /* 게임 추가 클릭 이벤트 설정 */
//        top_sliding_layout = (SlidingUpPanelLayout) findViewById(R.id.top_sliding_layout);
//        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//
//        Button add_game = (Button) findViewById(R.id.add_game);
//        add_game.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                top_sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
//
//                final Button btn_add = (Button) findViewById(R.id.add);
//                final EditText editTextName = (EditText) findViewById(R.id.new_game_name);
//
//                /* 패널 내의 추가 버튼 클릭 이벤트 설정 */
//                btn_add.setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View view) {
//                        String new_game_name = editTextName.getText().toString();
//                        game_adapter.addItem(new GameItem(new_game_name));
//                        game_adapter.notifyItemChanged(-1);
//
//                        imm.hideSoftInputFromWindow(editTextName.getWindowToken(), 0); // 키보드 내리기
//                        handler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                top_sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN); // 패널 내리기
//                            }
//                        },50); // 0.05초 딜레이
//                    }
//                });
//            }
//        });

//        Button.OnClickListener onClickListener = new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String game_name = view.getText().toString();
//                game_button.setText(game_name);
//            }
//        };

//    private SlidingUpPanelLayout.PanelSlideListener onSlideListener() {
//        return new SlidingUpPanelLayout.PanelSlideListener() {
//            @Override
//            public void onPanelSlide(View view, float v) {
//            }
//
//            @Override
//            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
//
//            }
//
//            @Override
//            public void onPanelCollapsed(View view) {
//            }
//
//            @Override
//            public void onPanelExpanded(View view) {
//            }
//
//            @Override
//            public void onPanelAnchored(View view) {
//            }
//
//            @Override
//            public void onPanelHidden(View view) {
//            }
//        };
//    }

    }

    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                    }
                }
            });
}