package id.ac.ubaya.informatika.advweek4.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import id.ac.ubaya.informatika.advweek4.R
import id.ac.ubaya.informatika.advweek4.view.MainActivity
import java.lang.Exception

fun createNotificationChannel(context:Context, importance:Int, showBadge:Boolean, name:String, description:String){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "${context.packageName}-$name"
        val channel = NotificationChannel(channelId, name, importance)
        channel.description = description
        channel.setShowBadge(showBadge)

        val notificationManager = context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}

fun ImageView.loadImage(url:String, progressBar:ProgressBar){
    Picasso.get()
            .load(url)
            .resize(400,400)
            .centerCrop()
            .error(R.drawable.ic_baseline_error_24)
            .into(this, object: Callback {
                override fun onSuccess() {
                    progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {

                }

            })
}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoUrl(v:ImageView, url:String?, pb:ProgressBar) {
    if (url != null) {
        v.loadImage(url, pb)
    }
}

//@BindingAdapter("android:imageUrl2", "android:progressBar2")
//fun loadPhotoUrl2(v:ImageView, url:String?, pb:ProgressBar) {
//    if (url != null) {
//        v.loadImage(url, pb)
//    }
//}


