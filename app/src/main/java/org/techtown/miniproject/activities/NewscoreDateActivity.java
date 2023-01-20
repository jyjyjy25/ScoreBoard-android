package org.techtown.miniproject.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.techtown.miniproject.R;
import org.w3c.dom.Text;

public class NewscoreDateActivity extends AppCompatActivity {
    int pYear=0, pMonth=0, pDay=0;
    DatePickerDialog datePickerDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newscore_date);

        /* 날짜 입력 버튼 */
        Button match_date = (Button) findViewById(R.id.match_date);
        match_date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                /* 오늘 날짜 가져오기 */
                Calendar calendar = Calendar.getInstance();
                pYear = calendar.get(Calendar.YEAR);
                pMonth = calendar.get(Calendar.MONTH);
                pDay = calendar.get(Calendar.DAY_OF_MONTH);

                /* 버튼 클릭 시 datePickerDialog 띄우기 */
                datePickerDialog = new DatePickerDialog(NewscoreDateActivity.this, R.style.MyDatePickerStyle,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                month = month+1;
                                String date = year + ". " + month + ". " + dayOfMonth + ".";
                                match_date.setText(date);
                            }
                        },pYear, pMonth, pDay);
                datePickerDialog.show();
                datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.MainColorPrimary));
                datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.MainColorPrimary));
            }
        });

        /* 다음 버튼 */
        Button next_button = (Button) findViewById(R.id.next_button);
        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewscoreGameActivity.class);
                startActivityResult.launch(intent);
            }
        });

    }

    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                    }
                }
            });
}
