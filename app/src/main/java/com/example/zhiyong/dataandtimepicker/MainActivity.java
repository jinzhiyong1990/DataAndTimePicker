package com.example.zhiyong.dataandtimepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private DatePicker datePicker;
    private TextView textView;
    private int year, month, day, hour, minut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        initView();
        getCurrentTimer();
        setPicker();

    }

    private void getCurrentTimer() {
//        获取系统当前时间
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minut = calendar.get(Calendar.MINUTE);
    }

    private void setPicker() {
//        设置为24小时制
        timePicker.setIs24HourView(true);
//        设置时间选择器的当前时间
        timePicker.setCurrentHour(hour);
        timePicker.setCurrentMinute(minut);
//        添加监听器
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                当时间选择器发生改变的时候调用:
                /*
                1. 时间选择器的对象
                2. 小时
                3. 分钟

                 */
                System.out.println("From TimePicker" + hourOfDay + ":" + minute);
            }
        });

//        datePicker:
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //当日期发生变化时触发
                System.out.println("From DatePicker" + year +"/" + monthOfYear + "/" + dayOfMonth);

            }
        });
    }

    private void initView(){
        timePicker = findViewById(R.id.timer);
        datePicker = findViewById(R.id.date);
        textView = findViewById(R.id.text222);
    }


}
