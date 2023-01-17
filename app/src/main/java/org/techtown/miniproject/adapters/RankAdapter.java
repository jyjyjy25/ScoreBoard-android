package org.techtown.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.miniproject.R;
import org.techtown.miniproject.items.RankItem;

import java.util.ArrayList;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.ViewHolder> {
    Context context;
    ArrayList<RankItem> items = new ArrayList<RankItem>();
    TextView ranking, user_name, user_age, user_gender, win_num, lose_num;

    public RankAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.rank_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RankItem item = items.get(position);
        holder.setItem(item);
    }

    public void addItem(RankItem item) {
        items.add(item);
    }

    public void addItems(ArrayList<RankItem> items) {
        this.items = items;
    }

    public RankItem getItem(int position) {
        return items.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView) ;

            ranking = itemView.findViewById(R.id.ranking);
            user_name = itemView.findViewById(R.id.user_name) ;
            user_age = itemView.findViewById(R.id.user_age) ;
            user_gender = itemView.findViewById(R.id.user_gender) ;
            win_num = itemView.findViewById(R.id.win_num) ;
            lose_num = itemView.findViewById(R.id.lose_num) ;
        }

        public void setItem(RankItem item) {
            ranking.setText(String.valueOf(item.getRanking()));
            user_name.setText(item.getUser_name());
            user_age.setText(String.valueOf(item.getUser_age()));
            user_gender.setText(item.getUser_gender());
            win_num.setText(String.valueOf(item.getWin_num()));
            lose_num.setText(String.valueOf(item.getLose_num()));
        }
    }
}
