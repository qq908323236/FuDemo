package com.fu.demo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.fastjson.JSONObject
import com.fu.demo.R
import okhttp3.*
import java.io.IOException

class OkhttpActivity : AppCompatActivity() {

    val TAG = "OkhttpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)
    }

    /**
     * 异步GET请求
     */
    fun asyncGetRequest(view: View) {
        //玩Android的首页文章列表API接口
        val requestUrl = "https://www.wanandroid.com/article/list/0/json"
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            .url(requestUrl)
            .get() //默认是get请求，可以不写
            .build()
        val call = okHttpClient.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i(TAG, "onFailure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                val string = response.body?.string()
                val jsonObject = JSONObject.parseObject(string)
                Log.i(TAG, "onResponse: ")
                Log.i(TAG, "数据:${jsonObject.toJSONString()}")
            }
        })
        Log.i(TAG, "asyncGetRequest: ")
    }
}