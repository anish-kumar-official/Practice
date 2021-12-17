package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val TAG="MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            Log.d(TAG,"this is called in IO thread ${Thread.currentThread().name}")
            val ans = doNetworkcalls()
            withContext(Dispatchers.Main){
                Log.d(TAG,"this is called in Main thread ${Thread.currentThread().name}")
                tvView.text = ans
            }

        }
    }
}
suspend fun doNetworkcalls(): String {
    delay(5000L)
    return "Completed successfully"
}


