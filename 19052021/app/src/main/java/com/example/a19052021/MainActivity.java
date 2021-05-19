package com.example.a19052021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat
            notificationManagerCompat;
    private static final String CHANNEL_1_ID = "channel1";
    private static final String CHANNEL_2_ID = "channel2";
    private EditText editTextTitle;
    private EditText editTextMessage;
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannels();
        editTextTitle = findViewById(R.id.editText_title);
        editTextMessage = findViewById(R.id.editText_message);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOnChannel1();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOnChannel2();
            }
        });
        notificationManagerCompat =
                NotificationManagerCompat.from(this);
    }
    private void createNotificationChannels() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1", NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is channel 1");
            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel 2"
                    ,
                    NotificationManager.IMPORTANCE_LOW
            );
            channel1.setDescription("This is channel 2");
            NotificationManager manager =
                    this.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
    private void sendOnChannel1() {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Notification notification;
        notification = new NotificationCompat.
                Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_notification1)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        int notificationId = 1;
        notificationManagerCompat.notify(notificationId,
                notification);
    }
    private void sendOnChannel2() {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        Notification notification = new
                NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_star)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_PROMO)
                .build();
        int notificationId = 2;
        notificationManagerCompat.notify(notificationId,
                notification);
    }
}