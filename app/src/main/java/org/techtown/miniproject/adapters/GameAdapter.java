package org.techtown.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.miniproject.items.GameItem;
import org.techtown.miniproject.R;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder>{

    Context context;
    ArrayList<GameItem> items = new ArrayList<GameItem>();
    TextView game_name, game_event, game_count;

    public GameAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.game_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GameAdapter.ViewHolder holder, int position) {
        GameItem item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(GameItem item) {
        items.add(item);
    }

    public void addItems(ArrayList<GameItem> items) {
        this.items = items;
    }

    public GameItem getItem(int position) {
        return items.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView) ;

            game_name = itemView.findViewById(R.id.game_name) ;
            game_event = itemView.findViewById(R.id.game_event) ;
            game_count = itemView.findViewById(R.id.game_count) ;
        }

        public void setItem(GameItem item) {
            game_name.setText(item.getGame_name());
            game_event.setText(item.getGame_event());
            game_count.setText(String.valueOf(item.getGame_count()));
        }
    }
}
