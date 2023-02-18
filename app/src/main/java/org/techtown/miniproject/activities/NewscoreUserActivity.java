package org.techtown.miniproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.techtown.miniproject.R;
import org.techtown.miniproject.adapters.UserAdapter;
import org.techtown.miniproject.items.UserItem;
import org.w3c.dom.Text;

public class NewscoreUserActivity extends AppCompatActivity {
    RecyclerView user_recycler_view;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newscore_user2);

        Button user1_name = (Button) findViewById(R.id.user1_name);
        EditText user1_score = (EditText) findViewById(R.id.user1_score);
        Button user2_name = (Button) findViewById(R.id.user2_name);
        EditText user2_score = (EditText) findViewById(R.id.user2_score);
        SlidingUpPanelLayout sliding_layout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);

        /* recyclerView 설정 */
        user_recycler_view = (RecyclerView) findViewById(R.id.user_recycler_view);

        LinearLayoutManager user_layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        user_recycler_view.setLayoutManager(user_layoutManager);

        UserAdapter user_adapter = new UserAdapter(this);
        user_adapter.addItem(new UserItem("Gabe", 31, "Male", 4, 0));
        user_adapter.addItem(new UserItem("June", 29, "Male", 0, 4));
        user_adapter.addItem(new UserItem("Julia", 23, "Female", 2, 2));
        user_recycler_view.setAdapter(user_adapter);

        /* 유저 선택 이벤트 */
        user1_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        });

        user2_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
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

    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        String game_name = data.getStringExtra("game_name");
        Toast.makeText(getApplicationContext(), "게임 이름: " + game_name, Toast.LENGTH_LONG);
    }
}
