package com.example.stampsproject2

import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

fun getApi(url: String, callback: (response: String?, error: String?) -> Unit) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url(url)
        .build()

    client.newCall(request).enqueue(object: Callback {
        override fun onFailure(call: Call, e: IOException) {
            callback(null, e.message)
        }

        override fun onResponse(call: Call, response: Response) {
            val responseData = response.body?.string()
            response.close()
            callback(responseData, null)
        }
    })
}
