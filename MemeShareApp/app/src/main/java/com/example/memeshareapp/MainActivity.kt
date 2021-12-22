package com.example.memeshareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

// Request a string response from the provided URL.
        val jsonObrequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
              val url = response.getString("url")
                Glide.with(this).load(url).into(ivMeme)
            },
            Response.ErrorListener { error ->
                  Toast.makeText(this,"something went wrong",Toast.LENGTH_SHORT).show()
            }
        )
    queue.add(jsonObrequest)
    }
}