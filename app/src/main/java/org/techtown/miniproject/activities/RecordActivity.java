package org.techtown.miniproject.activities;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

import org.techtown.miniproject.R;
import org.techtown.miniproject.adapters.ScoreAdapter;
import org.techtown.miniproject.items.ScoreItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RecordActivity extends AppCompatActivity {
    RecyclerView score_recycler_view;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextview;
    TextInputLayout textInputLayout;

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        /* 선택된 tab 텍스트 색상 설정 */
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setTabTextColors(Color.rgb(153, 153, 153), Color.rgb(0, 0, 0));

        /* recycler view 설정 */
        score_recycler_view = (RecyclerView) findViewById(R.id.score_recycler_view);
        LinearLayoutManager score_layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        score_recycler_view.setLayoutManager(score_layoutManager);
        ScoreAdapter score_adapter = new ScoreAdapter(getApplicationContext());

        score_adapter.addItem(new ScoreItem("2022. 10. 18.", "가위바위보", "Gabe", "June", 4, 0));
        score_adapter.addItem(new ScoreItem("2022. 11. 21.", "탁구", "Nowee", "Ann", 3, 1));

        score_recycler_view.setAdapter(score_adapter);

        /* dropdown 설정 */
        ArrayList gameList = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.game)));
        gameList.sort(Comparator.naturalOrder());
        gameList.add(0, "전체");
        String[] games = (String[]) gameList.toArray(new String[gameList.size()]);

        textInputLayout = findViewById(R.id.dateFilterContainer);
        autoCompleteTextview = findViewById(R.id.datesFilterSpinner);

        ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, games);
        autoCompleteTextview.setAdapter(itemAdapter);
        autoCompleteTextview.setDropDownBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.bg_dropdown, null));

        autoCompleteTextview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });



    }
}
