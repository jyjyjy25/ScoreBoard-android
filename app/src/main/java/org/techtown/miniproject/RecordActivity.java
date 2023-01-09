package org.techtown.miniproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecordActivity extends AppCompatActivity {
    boolean game_index_state = true;
    boolean user_index_state = false;
    boolean score_index_state = false;
    RecyclerView game_recycler_view;
    RecyclerView user_recycler_view;
    RecyclerView score_recycler_view;
    LinearLayout game_layout, user_layout, score_layout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        ImageButton game_index = (ImageButton) findViewById(R.id.index_game);
        ImageButton user_index = (ImageButton) findViewById(R.id.index_user);
        ImageButton score_index = (ImageButton) findViewById(R.id.index_score);

        game_layout = (LinearLayout) findViewById(R.id.game_layout);
        user_layout = (LinearLayout) findViewById(R.id.user_layout);
        score_layout = (LinearLayout) findViewById(R.id.score_layout);

        game_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!game_index_state) {
                    game_index.setImageResource(R.drawable.game_pressed_btn);
                    game_index_state = !game_index_state;
                    game_layout.setVisibility(View.VISIBLE);
                    user_layout.setVisibility(View.INVISIBLE);
                    score_layout.setVisibility(View.INVISIBLE);

                    if (user_index_state) {
                        user_index.setImageResource(R.drawable.user_btn);
                        user_index_state = !user_index_state;
                    }
                    else if (score_index_state) {
                        score_index.setImageResource(R.drawable.score_btn);
                        score_index_state = !score_index_state;
                    }
                }
            }
        });

        user_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!user_index_state) {
                    user_index.setImageResource(R.drawable.user_pressed_btn);
                    user_index_state = !user_index_state;
                    user_layout.setVisibility(View.VISIBLE);
                    game_layout.setVisibility(View.INVISIBLE);
                    score_layout.setVisibility(View.INVISIBLE);

                    if (game_index_state) {
                        game_index.setImageResource(R.drawable.game_btn);
                        game_index_state = !game_index_state;
                    }
                    else if (score_index_state) {
                        score_index.setImageResource(R.drawable.score_btn);
                        score_index_state = !score_index_state;
                    }
                }
            }
        });

        score_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!score_index_state) {
                    score_index.setImageResource(R.drawable.score_pressed_btn);
                    score_index_state = !score_index_state;
                    score_layout.setVisibility(View.VISIBLE);
                    game_layout.setVisibility(View.INVISIBLE);
                    user_layout.setVisibility(View.INVISIBLE);

                    if (game_index_state) {
                        game_index.setImageResource(R.drawable.game_btn);
                        game_index_state = !game_index_state;
                    }
                    else if (user_index_state) {
                        user_index.setImageResource(R.drawable.user_btn);
                        user_index_state = !user_index_state;
                    }
                }
            }
        });

        game_recycler_view = (RecyclerView) findViewById(R.id.game_recycler_view);
        LinearLayoutManager game_layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        game_recycler_view.setLayoutManager(game_layoutManager);
        GameAdapter game_adapter = new GameAdapter(getApplicationContext());

        game_adapter.addItem(new GameItem("배구", "구기종목", 3));
        game_adapter.addItem(new GameItem("컬링", "동계종목", 9));
        game_adapter.addItem(new GameItem("허들", "육상종목", 4));

        game_recycler_view.setAdapter(game_adapter);

        user_recycler_view = (RecyclerView) findViewById(R.id.user_recycler_view);
        LinearLayoutManager user_layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        user_recycler_view.setLayoutManager(user_layoutManager);
        UserAdapter user_adapter = new UserAdapter(getApplicationContext());

        user_adapter.addItem(new UserItem("Gabe", 31, "Male", 4, 0));
        user_adapter.addItem(new UserItem("June", 30, "Male", 0, 4));
        user_adapter.addItem(new UserItem("Julia", 23, "Female", 2, 2));

        user_recycler_view.setAdapter(user_adapter);

        score_recycler_view = (RecyclerView) findViewById(R.id.score_recycler_view);
        LinearLayoutManager score_layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        score_recycler_view.setLayoutManager(score_layoutManager);
        ScoreAdapter score_adapter = new ScoreAdapter(getApplicationContext());

        score_adapter.addItem(new ScoreItem(2022, "10/18", "Gabe", "June", 4, 0));
        score_adapter.addItem(new ScoreItem(2022, "10/20", "Nowee", "Ann", 3, 1));

        score_recycler_view.setAdapter(score_adapter);

    }
}
