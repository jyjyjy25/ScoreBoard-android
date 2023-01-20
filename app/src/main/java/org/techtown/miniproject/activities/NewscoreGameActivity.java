package org.techtown.miniproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.techtown.miniproject.R;

public class NewscoreGameActivity extends AppCompatActivity {
    boolean isExistBlank = false;
    private SharedPreferences preferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newscore_game);

        SlidingUpPanelLayout sliding_layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);

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
                if(!isExistBlank) {
                    Intent intent = new Intent(getApplicationContext(), NewscoreUserActivity.class);
                    // intent.putExtra("game_name", game_name.getText().toString());
                    startActivityResult.launch(intent);
                }
                else {
                    // 비어있는 edittext 디자인 변경
                }
            }
        });

        /* editText 비어있음 여부 확인 */
//        if(TextUtils.isEmpty(game_name.getText())) {
//            isExistBlank = true;
//        } else {
//            isExistBlank = false;
//        }

    }

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
