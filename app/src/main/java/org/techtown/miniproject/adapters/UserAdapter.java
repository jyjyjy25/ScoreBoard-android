package org.techtown.miniproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.miniproject.R;
import org.techtown.miniproject.items.UserItem;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    Context context;
    ArrayList<UserItem> items = new ArrayList<UserItem>();
    TextView user_name, user_age, user_gender, win_num, lose_num;

    public UserAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.user_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        UserItem item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(UserItem item) {
        items.add(item);
    }

    public void addItems(ArrayList<UserItem> items) {
        this.items = items;
    }

    public UserItem getItem(int position) {
        return items.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView) ;

            user_name = itemView.findViewById(R.id.user_name) ;
            user_age = itemView.findViewById(R.id.user_age) ;
            user_gender = itemView.findViewById(R.id.user_gender) ;
            win_num = itemView.findViewById(R.id.win_num) ;
            lose_num = itemView.findViewById(R.id.lose_num) ;
        }

        public void setItem(UserItem item) {
            user_name.setText(item.getUser_name());
            user_age.setText(String.valueOf(item.getUser_age()));
            user_gender.setText(item.getUser_gender());
            win_num.setText(String.valueOf(item.getWin_num()));
            lose_num.setText(String.valueOf(item.getLose_num()));
        }
    }
}
