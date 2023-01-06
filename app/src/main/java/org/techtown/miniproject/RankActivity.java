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

        adapter.addItem(new RankItem("1위", "Gabe", 30, "♂", 4, 0));
        adapter.addItem(new RankItem("2위", "June", 29, "♂", 3, 1));
        adapter.addItem(new RankItem("3위", "Julia", 23, "♀", 2, 2));
        adapter.addItem(new RankItem("4위", "Nowee", 24, "♀", 1, 3));
        adapter.addItem(new RankItem("5위", "David", 33, "♂", 0, 4));

        rank_recycler_view.setAdapter(adapter);
    }
}
