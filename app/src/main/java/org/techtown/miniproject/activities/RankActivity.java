package org.techtown.miniproject.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.miniproject.R;
import org.techtown.miniproject.adapters.RankAdapter;
import org.techtown.miniproject.items.RankItem;

public class RankActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        RecyclerView rank_recycler_view = (RecyclerView) findViewById(R.id.rank_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rank_recycler_view.setLayoutManager(layoutManager);

        RankAdapter adapter = new RankAdapter(getApplicationContext());

        adapter.addItem(new RankItem(1, "Gabe", 30, "Male", 4, 0));
        adapter.addItem(new RankItem(2, "June", 29, "Male", 3, 1));
        adapter.addItem(new RankItem(3, "Julia", 23, "Female", 2, 2));
        adapter.addItem(new RankItem(4, "Nowee", 24, "Female", 1, 3));
        adapter.addItem(new RankItem(5, "David", 33, "Male", 0, 4));

        rank_recycler_view.setAdapter(adapter);
    }
}
