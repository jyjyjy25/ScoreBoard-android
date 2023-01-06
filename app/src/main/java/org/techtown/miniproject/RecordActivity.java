package org.techtown.miniproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RecordActivity extends AppCompatActivity {
    boolean game_index_state = true;
    boolean user_index_state = false;
    boolean score_index_state = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        ImageButton game_index = (ImageButton) findViewById(R.id.index_game);
        ImageButton user_index = (ImageButton) findViewById(R.id.index_user);
        ImageButton score_index = (ImageButton) findViewById(R.id.index_score);

        game_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!game_index_state) {
                    game_index.setImageResource(R.drawable.record_game_pressed_index);
                    game_index_state = !game_index_state;

                    if (user_index_state) {
                        user_index.setImageResource(R.drawable.record_user_index);
                        user_index_state = !user_index_state;
                    }
                    if (score_index_state) {
                        score_index.setImageResource(R.drawable.record_score_index);
                        score_index_state = !score_index_state;
                    }
                }
            }
        });

        user_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!user_index_state) {
                    user_index.setImageResource(R.drawable.record_user_pressed_index);
                    user_index_state = !user_index_state;

                    if (game_index_state) {
                        game_index.setImageResource(R.drawable.record_game_index);
                        game_index_state = !game_index_state;
                    }
                    else if (score_index_state) {
                        score_index.setImageResource(R.drawable.record_score_index);
                        score_index_state = !score_index_state;
                    }

                }
            }
        });

        score_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!score_index_state) {
                    score_index.setImageResource(R.drawable.record_score_pressed_index);
                    score_index_state = !score_index_state;

                    if (game_index_state) {
                        game_index.setImageResource(R.drawable.record_game_index);
                        game_index_state = !game_index_state;
                    }
                    else if (user_index_state) {
                        user_index.setImageResource(R.drawable.record_user_index);
                        user_index_state = !user_index_state;
                    }
                }
            }
        });

    }
}
