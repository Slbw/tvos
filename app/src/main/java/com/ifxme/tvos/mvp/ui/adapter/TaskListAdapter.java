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
import com.ifxme.tvos.mvp.model.Task;
import com.ifxme.tvos.mvp.model.User;
import com.ifxme.tvos.mvp.util.DateUtil;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.UserHolder> {


    private List<Task> taskList;
    private Context context;
    private OnItemClickListener itemClickListener;

    public TaskListAdapter(Context context, List<Task> taskList) {
        this.taskList = taskList;
        this.context = context;
    }


    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_task, parent, false);
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
        Task task = taskList.get(position);
        holder.tvTaskName.setText(task.taskName);
        holder.tvTaskDesc.setText(task.taskDesc);
        holder.tvStaffName.setText(task.staffName);
        holder.tvBeginTime.setText(DateUtil.getWellFormatedTime(task.beginTime));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {

        private TextView tvTaskName;
        private TextView tvTaskDesc;
        private TextView tvStaffName;
        private TextView tvBeginTime;

        public UserHolder(View itemView) {
            super(itemView);
            tvTaskName = (TextView) itemView.findViewById(R.id.tvTaskName);
            tvTaskDesc = (TextView) itemView.findViewById(R.id.tvTaskDesc);
            tvStaffName = (TextView) itemView.findViewById(R.id.tvStaffName);
            tvBeginTime = (TextView) itemView.findViewById(R.id.tvBeginTime);
        }
    }


    public interface OnItemClickListener {
        public void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

}

