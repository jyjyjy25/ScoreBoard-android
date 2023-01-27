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
    TextView detail_name, detail_age, detail_gender, detail_win_cnt, detail_lose_cnt;
    String name, gender;
    int age, win_cnt, lose_cnt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        detail_name = (TextView) findViewById(R.id.detail_name);
        detail_age = (TextView) findViewById(R.id.detail_age);
        detail_gender = (TextView) findViewById(R.id.detail_gender);
        detail_win_cnt = (TextView) findViewById(R.id.detail_win_cnt);
        detail_lose_cnt = (TextView) findViewById(R.id.detail_lose_cnt);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        age = intent.getIntExtra("age", 0);
        gender = intent.getStringExtra("gender");
        win_cnt = intent.getIntExtra("win_cnt", 0);
        lose_cnt = intent.getIntExtra("lose_cnt", 0);

        detail_name.setText(name);
        detail_age.setText(String.valueOf(age));
        detail_gender.setText(gender);
        detail_win_cnt.setText(String.valueOf(win_cnt));
        detail_lose_cnt.setText(String.valueOf(lose_cnt));

    }
}
