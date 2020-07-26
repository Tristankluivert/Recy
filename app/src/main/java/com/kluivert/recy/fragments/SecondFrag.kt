package com.kluivert.recy.fragments

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.kluivert.recy.R
import com.kluivert.recy.TabActivity


const val CHANNEL_ID = "secondAppID"
const val CHANNEL_NAME = "secondAppName"

class SecondFrag : Fragment() {


    lateinit var btnNoti : Button

    val  NOTIFICATION_ID  = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createNotification()

           btnNoti = view.findViewById(R.id.btnNoti)

        val intent = Intent(context,TabActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT)
        }
       val notification = NotificationCompat.Builder(context!!, CHANNEL_ID)
           .setContentTitle("Works")
           .setContentText("Beautiful code")
           .setContentIntent(pendingIntent)
           .setSmallIcon(R.drawable.ic_message)
           .setPriority(NotificationCompat.PRIORITY_HIGH)
           .build()


        val mana = NotificationManagerCompat.from(context!!)

        btnNoti.setOnClickListener {
            mana.notify(NOTIFICATION_ID,notification)
        }

    }

    fun createNotification(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val noti = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.BLUE
                canShowBadge()
                setShowBadge(true)
                enableLights(true)
                enableVibration(true)
            }
           val manager = context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(noti)

        }

    }

}