package com.ifxme.tvos.mvp.model;

import java.io.Serializable;

/**
 * Created by Slbw on 2016/9/21.
 */

public class Task implements Serializable{

    public int id;
    public String taskName;
    public String taskDesc;
    public int createrId;
    public String createrName;
    public long beginTime;
    public int type;
    public int staffId;
    public String staffName;
    public String taskRemark;
}
