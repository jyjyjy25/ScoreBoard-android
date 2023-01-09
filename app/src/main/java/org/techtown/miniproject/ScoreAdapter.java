package org.techtown.miniproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ViewHolder>{

    Context context;
    ArrayList<ScoreItem> items = new ArrayList<ScoreItem>();
    TextView match_date_year, match_date_monthANDday, user1_name, user2_name, user1_score, user2_score;

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

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView) ;

            match_date_year = itemView.findViewById(R.id.match_date_year) ;
            match_date_monthANDday = itemView.findViewById(R.id.match_date_monthANDday) ;
            user1_name = itemView.findViewById(R.id.user1_name) ;
            user2_name = itemView.findViewById(R.id.user2_name) ;
            user1_score = itemView.findViewById(R.id.user1_score) ;
            user2_score = itemView.findViewById(R.id.user2_score) ;

        }

        public void setItem(ScoreItem item) {
            match_date_year.setText(String.valueOf(item.getMatch_date_year()));
            match_date_monthANDday.setText(item.getMatch_date_monthANDday());
            user1_name.setText(item.getUser1_name());
            user2_name.setText(item.getUser2_name());
            user1_score.setText(String.valueOf(item.getUser1_score()));
            user2_score.setText(String.valueOf(item.getUser2_score()));
        }
    }
}
