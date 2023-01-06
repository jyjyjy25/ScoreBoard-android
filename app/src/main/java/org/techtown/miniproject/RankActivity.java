package org.techtown.miniproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        RecyclerView rank_recycler_view = (RecyclerView) findViewById(R.id.rank_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rank_recycler_view.setLayoutManager(layoutManager);

        RankAdapter adapter = new RankAdapter(getApplicationContext());

        adapter.addItem(new RankItem("Gabe", 30, "♂", 3, 1));
        adapter.addItem(new RankItem("June", 29, "♂", 2, 2));

        rank_recycler_view.setAdapter(adapter);
    }
}
