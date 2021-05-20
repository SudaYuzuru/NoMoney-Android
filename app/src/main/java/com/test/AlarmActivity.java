package com.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.test.R;
import com.test.frag_record.BaseRecordFragment;

import java.util.Calendar;

public class AlarmActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.dialog_alarm_dp);  //获取时间拾取组件
        timePicker.setIs24HourView(true);    //设置使用24小时制
        Button button_add = (Button) findViewById(R.id.alarm_btn_set);  //获取“添加提醒”按钮
        //为“添加提醒”按钮添加单击事件监听器
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置提醒
                Intent intent = new Intent(AlarmActivity.this,ClockActivity.class);  //创建Intent对象
                PendingIntent pendingIntent = PendingIntent.getActivity(AlarmActivity.this,0,intent,0);   //获取显示闹钟的pendingintent
                AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);    //获取alarmManager对象
                Calendar calendar = Calendar.getInstance(); //获取日历对象
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());  //设置小时数
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());    //设置分钟数
                calendar.set(Calendar.SECOND,0);   //设置秒数
                alarm.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);  //设置提醒
                Toast.makeText(AlarmActivity.this,"提醒设置成功！",Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void onClick(View view) {
        finish();
    }
}
