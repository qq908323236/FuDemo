package com.fu.demo.ui

import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fu.demo.R
import com.fu.demo.receiver.MyReceiver

class BroadcastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        //动态注册广播
        val myReceiver = MyReceiver()
        val intentFilter = IntentFilter("com.fu.dynamic.test")
        registerReceiver(myReceiver, intentFilter)
    }

    fun sendStaticBroadcast(view: View) {
        val intent = Intent()
        intent.action = "com.fu.test"
        intent.putExtra("info", "测试静态注册广播")
        //静态注册的广播接收器只能通过显示发送(8.0以上)
        intent.setComponent(ComponentName("com.fu.demo", "com.fu.demo.receiver.MyReceiver"))
        sendBroadcast(intent)
    }

    fun sendDynamicBroadcast(view: View) {
        val intent = Intent("com.fu.dynamic.test")
        intent.putExtra("info", "测试动态注册广播")
        sendBroadcast(intent)
    }
}