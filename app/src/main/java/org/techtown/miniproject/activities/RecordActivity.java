package org.techtown.miniproject.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.miniproject.adapters.GameAdapter;
import org.techtown.miniproject.items.GameItem;
import org.techtown.miniproject.R;
import org.techtown.miniproject.adapters.ScoreAdapter;
import org.techtown.miniproject.items.ScoreItem;
import org.techtown.miniproject.adapters.UserAdapter;
import org.techtown.miniproject.items.UserItem;

public class RecordActivity extends AppCompatActivity {
    RecyclerView score_recycler_view;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        score_recycler_view = (RecyclerView) findViewById(R.id.score_recycler_view);
        LinearLayoutManager score_layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        score_recycler_view.setLayoutManager(score_layoutManager);
        ScoreAdapter score_adapter = new ScoreAdapter(getApplicationContext());

        score_adapter.addItem(new ScoreItem("2022/10/18", "가위바위보", "Gabe", "June", 4, 0));
        score_adapter.addItem(new ScoreItem("2022/11/21", "탁구", "Nowee", "Ann", 3, 1));

        score_recycler_view.setAdapter(score_adapter);

    }
}
