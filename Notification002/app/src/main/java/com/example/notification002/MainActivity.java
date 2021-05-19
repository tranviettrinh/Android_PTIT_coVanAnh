package com.example.notification002;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat
            notificationManagerCompat;
    private EditText editTime;
    private static final String CHANNEL_1_ID = "channel1";
    private Button button;
    final String CHANNEL_ID = "101";
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("This is notification channel");
            NotificationManager manager =
                    getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        editTime = findViewById(R.id.editTime);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String time = editTime.getText().toString();
                String[] tmp = time.split(":");
                final int tmpHour, tmpMinute, tmpSecond;
                tmpHour = Integer.parseInt(tmp[0]);
                tmpMinute = Integer.parseInt(tmp[1]);
                tmpSecond = Integer.parseInt(tmp[2]);


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            Calendar c = Calendar.getInstance();
                            int hour, minute, second;
                            hour = c.get(Calendar.HOUR_OF_DAY);
                            minute = c.get(Calendar.MINUTE);
                            second = c.get(Calendar.SECOND);
                            if (hour == tmpHour && minute == tmpMinute &&
                                    second >= tmpSecond) {
                                NotificationCompat.Builder builder =
                                        new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                                                .setSmallIcon(R.drawable.ic_launcher_background)
                                                .setContentTitle("ALARM")
                                                .setContentText("TIME'S UP")
                                                .setColor(Color.RED)
                                                .setPriority(NotificationCompat.PRIORITY_HIGH)
                                                .setAutoCancel(true);
                                NotificationManagerCompat notificationManagerCompat =
                                        NotificationManagerCompat.from(MainActivity.this);
                                int notificationId = 22;
                                notificationManagerCompat.notify(notificationId, builder.build());
                                break;
                            }
                        }
                    }
                }).start();
            }
        });
    }
}