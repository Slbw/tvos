package com.ifxme.tvos.mvp.ui.activity.task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.model.Task;
import com.ifxme.tvos.mvp.ui.activity.BaseActivity;
import com.ifxme.tvos.mvp.util.DateUtil;

public class TaskDetailActivity extends BaseActivity {

    private TextView tvBeginTime, tvStaffName, tvTaskDesc, tvRemark;
    public static final String INTENT_TASK_INFO = "taskInfo";
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
    }

    @Override
    protected void initView() {
        super.initView();
        tvBeginTime = (TextView) findViewById(R.id.tvBeginTime);
        tvStaffName = (TextView) findViewById(R.id.tvStaffName);
        tvTaskDesc = (TextView) findViewById(R.id.tvTaskDesc);
        tvRemark = (TextView) findViewById(R.id.tvRemark);
    }

    @Override
    protected void initData() {
        super.initData();
        if (getIntent().hasExtra(INTENT_TASK_INFO)) {
            task = (Task) getIntent().getSerializableExtra(INTENT_TASK_INFO);
        }
        if (task == null) {
            finish();
            return;
        }
        fillData(task);
    }

    @Override
    protected void initListener() {
        super.initListener();
    }

    private void fillData(Task task)
    {
        getSupportActionBar().setTitle(task.taskName);
        tvBeginTime.setText("开始时间："+DateUtil.getWellFormatedTime(task.beginTime));
        tvStaffName.setText("负责人："+task.staffName);
        tvTaskDesc.setText("任务描述："+task.taskDesc);
        tvRemark.setText("备注："+task.taskRemark);
    }
}
