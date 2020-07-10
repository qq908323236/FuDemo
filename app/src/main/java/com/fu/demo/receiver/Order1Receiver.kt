package com.fu.demo.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class Order1Receiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val extras = intent.extras
        val info = extras?.getString("info", "无")
        Log.i("MyReceiver", "我是Order1广播接收器，接收到了广播:$info")
        val resultExtras = getResultExtras(true)
        val string = resultExtras.getString("info")
        Log.i("MyReceiver", "我是Order1广播接收器，接收到了广播里其他的消息:$string")
    }
}
