package org.techtown.miniproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import org.techtown.miniproject.R;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

public class DetailUserActivity extends AppCompatActivity {
    TextView user_name, user_age, user_gender, user_win_num, user_lose_num;
    String name, gender;
    int age, win_cnt, lose_cnt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        user_name = (TextView) findViewById(R.id.user_name);
        user_age = (TextView) findViewById(R.id.user_age);
        user_gender = (TextView) findViewById(R.id.user_gender);
        user_win_num = (TextView) findViewById(R.id.user_win_num);
        user_lose_num = (TextView) findViewById(R.id.user_lose_num);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        age = intent.getIntExtra("age", 0);
        gender = intent.getStringExtra("gender");
        win_cnt = intent.getIntExtra("win_cnt", 0);
        lose_cnt = intent.getIntExtra("lose_cnt", 0);

        user_name.setText(name);
        user_age.setText(String.valueOf(age));
        user_gender.setText(gender);
        user_win_num.setText(String.valueOf(win_cnt));
        user_lose_num.setText(String.valueOf(lose_cnt));

    }
}
