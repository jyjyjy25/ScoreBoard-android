package org.techtown.miniproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RecordActivity extends AppCompatActivity {
    boolean game_index_state = false;
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
                game_index.setBackgroundResource(R.drawable.record_game_index_selector);
                game_index_state = !game_index_state;
            }
        });

        user_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_index.setBackgroundResource(R.drawable.record_user_index_selector);
                user_index_state = !user_index_state;
            }
        });

        score_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score_index.setBackgroundResource(R.drawable.record_score_index_selector);
                score_index_state = !score_index_state;
            }
        });

    }
}
