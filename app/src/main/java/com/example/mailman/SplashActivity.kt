package com.example.mailman

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        // If user is authenticated, navigate to mail else navigate to sign in.
        Handler().postDelayed({
            if(user != null) {
                val intent = Intent(this, MailActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}