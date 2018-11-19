package edu.wpi.clockdemo;

import android.app.PendingIntent;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlarmManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }
    private static MainActivity inst;

    public static MainActivity instance() {
        return inst;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    PendingIntent pendingIntent;

    public void onMainClick(View v) {
        TimePicker alarmTP = findViewById(R.id.timePicker);
        Intent createAlarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
        createAlarmIntent.putExtra(AlarmClock.EXTRA_HOUR, alarmTP.getHour());
        createAlarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, alarmTP.getMinute());

        getApplicationContext().startActivity(createAlarmIntent);
    }


    public void setAlarmText(String text){
        TextView alarmTextView = findViewById(R.id.alarmText);
        alarmTextView.setText(text);
    }
}
