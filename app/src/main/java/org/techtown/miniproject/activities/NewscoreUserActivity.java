package org.techtown.miniproject.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import org.techtown.miniproject.R;
import org.w3c.dom.Text;

public class NewscoreUserActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newscore_user2);

        TextView user1_name = (TextView) findViewById(R.id.user1_name);
        TextView user1_score = (TextView) findViewById(R.id.user1_score);
        TextView user2_name = (TextView) findViewById(R.id.user2_name);
        TextView user2_score = (TextView) findViewById(R.id.user2_score);

        Button save_button = (Button) findViewById(R.id.save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.putExtra("user1_name", user1_name.getText().toString());
                intent.putExtra("user1_score", user1_score.getText().toString());
                intent.putExtra("user2_name", user2_name.getText().toString());
                intent.putExtra("user2_score", user2_score.getText().toString());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                setResult(Activity.RESULT_OK, intent);
                startActivity(intent);
            }
        });

    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        String game_name = data.getStringExtra("game_name");
        Toast.makeText(getApplicationContext(), "게임 이름: " + game_name, Toast.LENGTH_LONG);
    }
}
