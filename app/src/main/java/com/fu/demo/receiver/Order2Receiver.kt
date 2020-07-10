package com.fu.demo.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log

class Order2Receiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val extras = intent.extras
        val info = extras?.getString("info", "无")
        Log.i("MyReceiver", "我是Order2广播接收器，接收到了广播:$info")
//        extras?.putString("info", info + "(我已经被Order2处理过)")
        val bundle = Bundle()
        bundle.putString("info", "我是Order2广播接收器")
        setResultExtras(bundle)
//        abortBroadcast()  //拦截广播,只能拦截有序广播
    }
}
