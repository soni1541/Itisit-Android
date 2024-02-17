package com.example.itisit;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class Receiver extends BroadcastReceiver {

    private static final String CHANEL_ID = "ch1"; // ID канала
    private NotificationManagerCompat notificationManagerCompat; // менеджер нотификаций

    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context);
    }

    public void showNotification(Context context) {

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel(
//                    CHANEL_ID,
//                    "channel_2",
//                    NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//        }
//
//        notificationManagerCompat = notificationManagerCompat.from(context);
//
//        NotificationCompat.Builder builder =
//                new NotificationCompat.Builder(context)
//                        .setSmallIcon(R.drawable.icon)
//                        .setContentTitle("Продолжите обучение ")
//                        .setContentText("Вы забросили курсы С++ (((")
//                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//

    }
}
