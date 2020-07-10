package com.fu.demo.ui

import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fu.demo.R
import com.fu.demo.receiver.MyReceiver
import com.fu.demo.receiver.Order1Receiver
import com.fu.demo.receiver.Order2Receiver

class BroadcastActivity : AppCompatActivity() {

    lateinit var myReceiver: MyReceiver
    lateinit var order1Receiver: Order1Receiver
    lateinit var order2Receiver: Order2Receiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        //动态注册广播
        myReceiver = MyReceiver()
        val intentFilter = IntentFilter("com.fu.dynamic.test")
        registerReceiver(myReceiver, intentFilter)

        //动态注册广播，用来测试有序广播 priority值大的先收到广播
        order1Receiver = Order1Receiver()
        val order1Filter = IntentFilter("com.fu.broadcast.order")
        order1Filter.priority = 1
        registerReceiver(order1Receiver, order1Filter)

        order2Receiver = Order2Receiver()
        val order2Filter = IntentFilter("com.fu.broadcast.order")
        order2Filter.priority = 2
        registerReceiver(order2Receiver, order2Filter)

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


    fun sendStaticOrderBroadcast(view: View) {
        Toast.makeText(
            this, "无法发送给静态注册的广播接收器发送有序广播，" +
                    "因为发送静态注册的广播需要显示发送，就是要添加Component，" +
                    "并且要指定广播接收器的完整包名", Toast.LENGTH_LONG
        ).show()
//        val intent = Intent("com.fu.broadcast.order")
//        intent.putExtra("info", "测试静态注册有序广播")
//        //静态注册的广播接收器只能通过显示发送(8.0以上)
//        intent.setComponent(ComponentName("com.fu.demo", "com.fu.demo.receiver.Order1Receiver"))
//        intent.setComponent(ComponentName("com.fu.demo", "com.fu.demo.receiver.Order2Receiver"))
//        sendBroadcast(intent)
    }

    fun sendDynamicOrderBroadcast(view: View) {
        val intent = Intent("com.fu.broadcast.order")
        intent.putExtra("info", "测试动态注册有序广播")
        sendOrderedBroadcast(intent, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReceiver)
        unregisterReceiver(order1Receiver)
        unregisterReceiver(order2Receiver)
    }
}