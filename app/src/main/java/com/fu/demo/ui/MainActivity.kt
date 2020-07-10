package com.fu.demo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fu.demo.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun broadcastReceiver(view: View) {
        val intent = Intent(this, BroadcastActivity::class.java)
        startActivity(intent)
    }

    fun startOkhttp(view: View) {
        val intent = Intent(this, OkhttpActivity::class.java)
        startActivity(intent)
    }
}