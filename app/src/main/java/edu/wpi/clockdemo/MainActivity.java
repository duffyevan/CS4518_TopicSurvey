package edu.wpi.clockdemo;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    private int alarm_index = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    ////// On Click Handlers //////

    public void onTPClick(View v) {
        TimePicker alarmTP = findViewById(R.id.timePicker);
        this.setAlarm(alarmTP.getHour(), alarmTP.getMinute());
    }

    public void onHourClick(View v) {
        Calendar time = Calendar.getInstance();
        time.setTime(new Date()); // Set the time to now
        time.add(Calendar.HOUR, 1);
        this.setAlarm(time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));
    }

    public void onHalfHourClick(View v) {
        Calendar time = Calendar.getInstance();
        time.setTime(new Date()); // Set the time to now
        time.add(Calendar.MINUTE, 30);
        this.setAlarm(time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));
    }

    public void onTwoHourClick(View v) {
        Calendar time = Calendar.getInstance();
        time.setTime(new Date()); // Set the time to now
        time.add(Calendar.HOUR, 2);
        this.setAlarm(time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));
    }

    public void onEightHourClick(View v) {
        Calendar time = Calendar.getInstance();
        time.setTime(new Date()); // Set the time to now
        time.add(Calendar.HOUR, 8);
        this.setAlarm(time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));
    }

    ////// Set Alarm //////

    /**
     * Set an alarm for a given time
     * @param hour The hour for the alarm
     * @param minute The minute for the alarm
     */
    private void setAlarm(int hour, int minute) {
        Intent createAlarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
        createAlarmIntent.putExtra(AlarmClock.EXTRA_HOUR, hour);
        createAlarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, minute);
        createAlarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE,  "Demo Alarm " + this.alarm_index++);

        Switch toggle = findViewById(R.id.switch1);

        createAlarmIntent.putExtra(AlarmClock.EXTRA_SKIP_UI, toggle.isChecked());

        getApplicationContext().startActivity(createAlarmIntent);
    }

}
