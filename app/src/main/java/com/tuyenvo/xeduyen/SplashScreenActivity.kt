package com.tuyenvo.xeduyen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tuyenvo.xeduyen.onboarding.activities.OnBoardingActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Intent(this, OnBoardingActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }
}