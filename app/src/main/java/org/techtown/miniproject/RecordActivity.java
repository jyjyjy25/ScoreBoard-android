package org.techtown.miniproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RecordActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

//        View blue_background = (View) findViewById(R.id.background_blue);
//        View red_background = (View) findViewById(R.id.background_red);
//        View yellow_background = (View) findViewById(R.id.background_yellow);
        ImageButton game_index = (ImageButton) findViewById(R.id.index_game);
        ImageButton user_index = (ImageButton) findViewById(R.id.index_user);
        ImageButton score_index = (ImageButton) findViewById(R.id.index_score);

        game_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                blue_background.setVisibility(View.VISIBLE);
//                red_background.setVisibility(View.INVISIBLE);
//                yellow_background.setVisibility(View.INVISIBLE);
            }
        });

        user_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                blue_background.setVisibility(View.INVISIBLE);
//                red_background.setVisibility(View.VISIBLE);
//                yellow_background.setVisibility(View.INVISIBLE);
            }
        });

        score_index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                blue_background.setVisibility(View.INVISIBLE);
//                red_background.setVisibility(View.INVISIBLE);
//                yellow_background.setVisibility(View.VISIBLE);
            }
        });

    }
}
