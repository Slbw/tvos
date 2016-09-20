package com.ifxme.tvos.mvp.ui.adapter;

/**
 * Created by Slbw on 2016/9/20.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.model.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserHolder> {


    private List<User> userList;
    private Context context;
    private OnItemClickListener itemClickListener;

    public UserListAdapter(Context context, List<User> userList) {
        this.userList = userList;
        this.context = context;
    }


    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick((Integer) v.getTag());
                }
            }
        });
        return new UserHolder(layout);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.itemView.setTag(position);
        User user = userList.get(position);
        holder.tvName.setText(user.userName);
        holder.tvRoleName.setText(user.role);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvRoleName;

        public UserHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvRoleName = (TextView) itemView.findViewById(R.id.tvRoleName);
        }
    }


    public interface OnItemClickListener {
        public void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

}

