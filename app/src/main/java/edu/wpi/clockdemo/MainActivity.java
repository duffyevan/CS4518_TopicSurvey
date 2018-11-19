package edu.wpi.clockdemo;

import android.app.PendingIntent;
import android.content.Intent;
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

    AlarmManager alarmManager;

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
        alarmSet = false;
    }

    boolean alarmSet;
    PendingIntent pendingIntent;

    public void onMainClick(View v) {
        TimePicker alarmTP = findViewById(R.id.timePicker);
        TextView alarmTextView = findViewById(R.id.alarmText);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (alarmSet) {
            alarmManager.cancel(pendingIntent);
        }
        else{
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, alarmTP.getHour());
            calendar.set(Calendar.MINUTE, alarmTP.getMinute());
            Intent myIntent = new Intent(MainActivity.this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
            alarmTextView.setText("Alarm set for " + alarmTP.getHour() + ":" + alarmTP.getMinute());
        }
    }

    public void setAlarmText(String text){
        TextView alarmTextView = findViewById(R.id.alarmText);
        alarmTextView.setText(text);
    }
}
