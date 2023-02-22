package org.techtown.miniproject.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.miniproject.R;
import org.techtown.miniproject.items.GameItem;
import org.techtown.miniproject.items.ScoreItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder>{

    Context context;
    ArrayList<ScoreItem> items = new ArrayList<ScoreItem>();
    TextView match_date, game_name, user1_name, user2_name, user1_score, user2_score;

    public ScoreAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ScoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.score_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ScoreAdapter.ViewHolder holder, int position) {
        ScoreItem item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(ScoreItem item) {
        items.add(item);
    }

    public void addItems(ArrayList<ScoreItem> items) {
        this.items = items;
    }

    public ScoreItem getItem(int position) {
        return items.get(position);
    }

    public ArrayList<ScoreItem> getItems() {return items; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView) ;

            match_date = itemView.findViewById(R.id.match_date);
            game_name = itemView.findViewById(R.id.game_name);
            user1_name = itemView.findViewById(R.id.user1_name) ;
            user2_name = itemView.findViewById(R.id.user2_name) ;
            user1_score = itemView.findViewById(R.id.user1_score) ;
            user2_score = itemView.findViewById(R.id.user2_score) ;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void setItem(ScoreItem item) {
            LocalDate date = item.getMatch_date();
            String yy = date.format(DateTimeFormatter.ofPattern("yyyy"));
            String mm = date.format(DateTimeFormatter.ofPattern("MM"));
            String dd = date.format(DateTimeFormatter.ofPattern("dd"));

            match_date.setText(yy + ". " + mm + ". " + dd + ".");
            game_name.setText(item.getGame_name());
            user1_name.setText(item.getUser1_name());
            user2_name.setText(item.getUser2_name());
            user1_score.setText(String.valueOf(item.getUser1_score()));
            user2_score.setText(String.valueOf(item.getUser2_score()));
        }
    }
}
