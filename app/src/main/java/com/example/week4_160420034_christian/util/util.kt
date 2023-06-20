package com.example.week4_160420034_christian.util

import android.app.NotificationChannel
import android.content.ClipDescription
import android.content.Context
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.example.week4_160420034_christian.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception
fun createNotifChannel(context: Context, importance:Int, showBagde:Boolean, name:String, description:String){
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
        val channelID = "${context.packageName}-$name"
        val channel = NotificationChannel(channelID,name,importance)
        channel.description = description
        channel.setShowBadge(showBagde)
    }
}

fun ImageView.loadImage(url:String?, progressBar: ProgressBar){
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.baseline_error_24)
        .into(this, object:Callback{
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
            }
        })
}

@BindingAdapter("android:imageUrl", "android:progressBar")
fun loadPhotoUrl(view: ImageView, url: String?, pb: ProgressBar){
    view.loadImage(url, pb)
}