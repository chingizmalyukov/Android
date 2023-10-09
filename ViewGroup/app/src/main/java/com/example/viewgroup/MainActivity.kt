package com.example.viewgroup


import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.viewgroup.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.taskBlock.setUpperText("Upper text from MainActivity")
        binding.taskBlock.setBottomText("Bottom text from MainActivity")

    }
}