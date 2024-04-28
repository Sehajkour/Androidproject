package com.example.sk

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Progress3 : AppCompatActivity() {

    private var isStarted = false
    private var primaryProgressStatus = 0
    private lateinit var btnProgressBarSecondary: Button
    private lateinit var progressBarSecondary: ProgressBar
    private lateinit var textViewPrimary: TextView
    private var handler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress1)

        btnProgressBarSecondary = findViewById(R.id.btnProgressBarSecondary)
        progressBarSecondary = findViewById(R.id.progressBarSecondary)
        textViewPrimary = findViewById(R.id.textViewPrimary)

        handler = Handler()

        btnProgressBarSecondary.setOnClickListener {
            if (!isStarted) {
                startProgress()
            } else {
                stopProgress()
            }
        }
    }

    private fun startProgress() {
        isStarted = true
        primaryProgressStatus = progressBarSecondary.progress
        Thread {
            while (primaryProgressStatus < 100) {
                primaryProgressStatus += 1

                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                runOnUiThread {
                    progressBarSecondary.progress = primaryProgressStatus
                    textViewPrimary.text = "Complete $primaryProgressStatus% of 100"
                }
            }
            isStarted = false
        }.start()
    }

    private fun stopProgress() {
        isStarted = false
    }}