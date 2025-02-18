package com.example.realprojectandroidpertama

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfilePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)
        title = "About"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}