package ly.gamingcenter.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class GCApplication : Application() {

    companion object {
        const val CHANNEL_ID = "gc_notifications"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        // عند تفعيل Firebase، أضف هنا: FirebaseApp.initializeApp(this)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "إشعارات قيمنق سنتر",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "عروض وتحديثات المتجر"
            }
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }
    }
}
