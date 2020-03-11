package com.pavel.rebrain.fcm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.pavel.rebrain.App
import com.pavel.rebrain.R
import com.pavel.rebrain.screen.main.MainActivity
import timber.log.Timber

/**
 * класс службы обработки пуш-уведомлений
 */
class FoodAppFirebaseMessagingService : FirebaseMessagingService() {

    companion object {
        private const val CHANNEL_ID = "FoodApp Channel Id"
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Timber.tag(App.APP_LOG_TAG).i("New token $token")
    }

    // onMessageReceived вызывается только, если имеется лишь поле data (без notification)
    // или если приложении находится в foreground
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Timber.tag(App.APP_LOG_TAG).i("Новое пуш-уведомление")
        Timber.tag(App.APP_LOG_TAG).i("From: ${remoteMessage.from}")

        // если уведомление имеет payload
        remoteMessage.data.isNotEmpty().let {
            Timber.tag(App.APP_LOG_TAG).i("Message data payload: ${remoteMessage.data}")
        }

        // данные из поля notification
        remoteMessage.notification?.let {
            Timber.tag(App.APP_LOG_TAG).i("Message Notification Body: ${it.body}")
            showNotification(it.body ?: "empty")
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID, "FoodApp Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(serviceChannel)
        }
    }

    private fun showNotification(text: String) {
        createNotificationChannel()

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, 0
        )

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("FoodApp")
            .setContentText(text)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(pendingIntent)
            .build()


        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, notification)
    }
}