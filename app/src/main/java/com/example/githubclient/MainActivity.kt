package com.example.githubclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubclient.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var vb:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }
}