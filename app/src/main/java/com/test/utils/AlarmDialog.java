package com.test.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.NonNull;

import com.test.R;

//弹出设置闹钟提醒对话框
public class AlarmDialog extends Dialog implements View.OnClickListener {
    TimePicker timePicker;
    Button setBtn,cancelBtn;
    public AlarmDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_alarm);
        timePicker = findViewById(R.id.dialog_alarm_dp);
        cancelBtn = findViewById(R.id.dialog_alarm_btn_cancel);
        setBtn = findViewById(R.id.dialog_alarm_btn_set);
        cancelBtn.setOnClickListener(this);
        setBtn.setOnClickListener(this);    //添加监听事件
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_alarm_btn_cancel:
                cancel();
                break;
            case R.id.dialog_alarm_btn_set:

                break;
        }
    }
}
