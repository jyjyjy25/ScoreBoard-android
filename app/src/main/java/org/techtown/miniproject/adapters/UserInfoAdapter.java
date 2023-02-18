package org.techtown.miniproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.miniproject.R;
import org.techtown.miniproject.activities.DetailUserActivity;
import org.techtown.miniproject.items.UserItem;

import java.util.ArrayList;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder>{
    Context context;
    ArrayList<UserItem> items = new ArrayList<UserItem>();
    TextView user_name, user_age, user_gender, win_num, lose_num;

    public UserInfoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public UserInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.user_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserInfoAdapter.ViewHolder holder, int position) {
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
        CardView card_view;

        public ViewHolder(View itemView) {
            super(itemView) ;

            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(context, DetailUserActivity.class);

                        intent.putExtra("name", items.get(pos).getUser_name());
                        Log.d("Tag", items.get(pos).getUser_name());
                        intent.putExtra("age", items.get(pos).getUser_age());
                        intent.putExtra("gender", items.get(pos).getUser_gender());
                        intent.putExtra("win_cnt", items.get(pos).getWin_num());
                        intent.putExtra("lose_cnt", items.get(pos).getLose_num());

                        context.startActivity(intent);
                    }
                }
            });

            card_view = itemView.findViewById(R.id.layout_container);
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

//public class UserAdapter extends RecyclerView.Adapter<ItemView>{
//    Context context;
//    private UserCase sel_type;
//    ArrayList<UserItem> items = new ArrayList<UserItem>();
//
//    public UserAdapter(Context context, UserCase sel_type) {
//        this.context = context;
//        this.sel_type = sel_type;
//    }
//
//    @NonNull
//    @Override
//    public ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if(sel_type == UserCase.INFO){
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View itemView = inflater.inflate(R.layout.user_item, parent, false);
//            return new ViewHolderUserInfo(itemView, context);
//        } else if(sel_type == UserCase.NEWSCORE){
//
//        }
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ItemView holder, int position) {
//        if (holder instanceof ViewHolderUserInfo){
//            ViewHolderUserInfo viewHolderMovieLarge = (ViewHolderUserInfo)holder;
//            viewHolderMovieLarge.onBind(items.get(position));
//        } else {
//
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//
//    public void addItem(UserItem item) {
//        items.add(item);
//    }
//
//    public void addItems(ArrayList<UserItem> items) {
//        this.items = items;
//    }
//
//    public UserItem getItem(int position) {
//        return items.get(position);
//    }
//
//}
