package com.example.loginauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = intent.getStringExtra("username_id")
        val name = intent.getStringExtra("name")
       tvMainName.text = "${name}"
        tvMainUsername.text = "${username}"
        btnSignOut.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            Intent(this,LoginActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }
}