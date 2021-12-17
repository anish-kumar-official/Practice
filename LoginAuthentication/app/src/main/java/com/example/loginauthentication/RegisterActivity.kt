package com.example.loginauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnSignup.setOnClickListener{
          when{
              TextUtils.isEmpty(etEnterName.text.toString().trim { it <=' ' }) ->{
                  Toast.makeText(this,"Plesae enter your name",Toast.LENGTH_SHORT).show()
              }
              TextUtils.isEmpty(etEnterPhone.text.toString().trim { it <=' ' }) ->{
                  Toast.makeText(this,"Plesae enter your Phone Number",Toast.LENGTH_SHORT).show()
              }
              TextUtils.isEmpty(etEnterUsername.text.toString().trim { it <=' ' }) ->{
                  Toast.makeText(this,"Plesae enter your UserName",Toast.LENGTH_SHORT).show()
              }
              TextUtils.isEmpty(etEnterPassword.text.toString().trim { it <=' ' }) ->{
                  Toast.makeText(this,"Plesae enter your Password",Toast.LENGTH_SHORT).show()
              }
              else -> {
                  val name = etEnterName.text.toString()
                  val phoneno = etEnterPhone.text.toString().toInt()
                  val Username = etEnterUsername.text.toString()
                  val password = etEnterPassword.text.toString()

                 FirebaseAuth.getInstance().createUserWithEmailAndPassword(Username,password).addOnCompleteListener{
                     Task ->
                     run {
                         if (Task.isSuccessful) {
                             val firebaseuser: FirebaseUser = Task.result!!.user!!
                             val value = Toast.makeText(
                                 this,
                                 "You are successfully registered",
                                 Toast.LENGTH_SHORT
                             ).show()

                             val it = Intent(this, MainActivity::class.java)
                             it.flags =
                                 Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                             it.putExtra("username_id", firebaseuser.uid)
                             it.putExtra("name", firebaseuser.displayName)
                             startActivity(it)
                             finish()
                         } else {
                             Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                         }
                     }


                 }
          }

        }
         }
    }
}