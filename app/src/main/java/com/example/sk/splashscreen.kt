package com.example.sk

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class splashscreen : AppCompatActivity() {
    private val splashDuration: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.splashscreen)

        Handler().postDelayed({
            startActivity(Intent(this, LoginPage::class.java))
            finish() // Finish the splash activity to prevent going back to it
        }, splashDuration)
    }
}
