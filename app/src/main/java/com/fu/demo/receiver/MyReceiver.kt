package com.fu.demo.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
//        TODO("MyReceiver.onReceive() is not implemented")
        val extras = intent.extras
        val info = extras?.getString("info", "无")
        Log.i("MyReceiver", "接收到了广播:$info")
        Toast.makeText(context, "收到广播了:$info", Toast.LENGTH_LONG).show()
    }
}
