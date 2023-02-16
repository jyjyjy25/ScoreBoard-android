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

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewscoreDateActivity extends AppCompatActivity {
    int pYear=0, pMonth=0, pDay=0;
    DatePickerDialog datePickerDialog;

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newscore_date);

        Button match_date = (Button) findViewById(R.id.match_date);

        /* 오늘 날짜 가져오기 */
        Calendar calendar = Calendar.getInstance();
        pYear = calendar.get(Calendar.YEAR);
        pMonth = calendar.get(Calendar.MONTH) + 1;
        pDay = calendar.get(Calendar.DAY_OF_MONTH);

        /* match_date의 text를 오늘 날짜로 설정하기*/
        String date = pYear + ". " + pMonth + ". " + pDay + ".";
        match_date.setText(date);

        /* match_date 버튼 이벤트 설정 */
        match_date.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                /* 버튼 클릭 시 datePickerDialog 띄우기 */
                datePickerDialog = new DatePickerDialog(NewscoreDateActivity.this, R.style.MyDatePickerStyle,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                month = month + 1;
                                String date = year + ". " + month + ". " + dayOfMonth + ".";
                                match_date.setText(date);
                            }
                        }, pYear, pMonth-1, pDay);
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
