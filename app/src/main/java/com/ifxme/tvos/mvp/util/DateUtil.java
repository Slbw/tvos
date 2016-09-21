package com.ifxme.tvos.mvp.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Slbw on 2016/9/21.
 */

public class DateUtil {


    /**
     * 获取格式化好的日期+小时
     * @param timeStamp
     * @return
     */
    public static String getWellFormatedDate(long timeStamp) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow = new Date();
        Date date = new Date(timeStamp);
        SimpleDateFormat sdfTimeDate = new SimpleDateFormat("yyyy年M月d日");
        SimpleDateFormat sdfDay = new SimpleDateFormat("M月d日 ");
        SimpleDateFormat sdfHour = new SimpleDateFormat("H:mm");
        if (sdfTimeDate.format(dateNow).equals(sdfTimeDate.format(date))) // 今天
        {
            return sdfHour.format(date);
        } else {// 本年
            return sdfDay.format(date) + sdfHour.format(date);
        }
    }

    /**
     * 获取格式化好的小时
     * @param timeStamp
     * @return
     */
    public static String getWellFormatedTime(long timeStamp) {
        Date date = new Date(timeStamp);
        SimpleDateFormat sdfHour = new SimpleDateFormat("H:mm");
        return sdfHour.format(date);
    }

}
